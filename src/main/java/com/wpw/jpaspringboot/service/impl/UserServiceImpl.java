package com.wpw.jpaspringboot.service.impl;

import com.wpw.jpaspringboot.entity.User;
import com.wpw.jpaspringboot.repository.UserRepository;
import com.wpw.jpaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wpw
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public Long save(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Long update(User user) {
        preCheck(user);
        return userRepository.save(user).getId();
    }

    @Override
    public List<User> listPagination(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return userRepository.findAll(pageRequest).getContent();

    }

    @Override
    public void deleteById(Long id) {
        preCheckIsExists(id);
        userRepository.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        List<User> userList = userRepository.findAllById(idList);
        List<Long> idListNew = userList.stream().map(User::getId).collect(Collectors.toList());
        idList.retainAll(idListNew);
        System.out.println("idList = " + idList);
        userRepository.deleteInBatch(userList);
    }

    private void preCheckIsExists(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            if (Objects.isNull(u)) {
                return;
            }
        }
    }

    private void preCheck(User user) {
        preCheckIsExists(user.getId());
    }
}
