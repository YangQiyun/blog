package com.edu.seu.blog.repository;

import com.edu.seu.blog.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorityRepository extends JpaRepository<UserInfo,Integer>{
}
