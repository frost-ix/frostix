package com.frostix.backend.domain.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.frostix.backend.domain.user.VO.user;

public interface UserService {
	ResponseEntity<List<user>> getUsers();

	ResponseEntity<user> createUser(user user);

	ResponseEntity<user> putUser(user user);

	ResponseEntity<String> deleteUser(String userId);
}