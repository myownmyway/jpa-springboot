package com.wpw.jpaspringboot.controller;

import com.wpw.jpaspringboot.vo.RequestVo;
import com.wpw.jpaspringboot.entity.User;
import com.wpw.jpaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wpw
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get")
    public User getById(@RequestParam(value = "id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/listUser")
    public List<User> listUser() {
        return userService.listUser();
    }

    @PostMapping(value = "/save")
    public Long save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping(value = "/update")
    public Long update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping(value = "/listPagination")
    public List<User> listPagination(@RequestParam(value = "pageNumber") Integer pageNumber
            , @RequestParam(value = "pageSize") Integer pageSize) {
        return userService.listPagination(pageNumber, pageSize);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam(value = "id") Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping(value = "/batchDelete")
    public void batchDelete(@RequestBody RequestVo requestVo) {
        userService.batchDelete(requestVo.getIdList());
    }

}
