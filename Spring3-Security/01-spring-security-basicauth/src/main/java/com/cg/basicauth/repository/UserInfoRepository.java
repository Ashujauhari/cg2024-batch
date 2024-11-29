package com.cg.basicauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.basicauth.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}
