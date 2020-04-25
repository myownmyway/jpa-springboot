package com.wpw.jpaspringboot.repository;

import com.wpw.jpaspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wpw
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
