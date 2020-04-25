package com.wpw.jpaspringboot.service;

import com.wpw.jpaspringboot.entity.User;

import java.util.List;

/**
 * @author wpw
 */
public interface UserService {
    /**
     * 根据用户id查找用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User getById(Long id);

    /**
     * 获取用户列表信息，这个用法其实很少，谁会全表查呢
     *
     * @return 用户列表信息
     */
    List<User> listUser();

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 主键
     */
    Long save(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 主键
     */
    Long update(User user);

    /**
     * 进行分页数据的查询
     *
     * @param pageNumber 其实页
     * @param pageSize   分页大小
     * @return 返回分页后的数据信息
     */
    List<User> listPagination(Integer pageNumber, Integer pageSize);

    /**
     * 根据用户id删除用户信息
     *
     * @param id 用户id
     */
    void deleteById(Long id);

    void batchDelete(List<Long> idList);
}
