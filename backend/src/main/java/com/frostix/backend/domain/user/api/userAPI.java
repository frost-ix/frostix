package com.frostix.backend.domain.user.api;

import org.springframework.web.bind.annotation.RestController;

import com.frostix.backend.domain.user.VO.user;
import com.frostix.backend.domain.user.service.UserService;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Log4j2
@RestController
public class UserAPI {
	private final UserService userService;

	public UserAPI(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<user>> getUsers() {
		ResponseEntity<List<user>> userInfo = userService.getUsers();
		return userInfo;
	}

	/***
	 * @apiNote
	 *          <h1>createUser</h1>
	 * @param user
	 * @return ResponseEntity<user>
	 */
	@PostMapping("/user")
	public ResponseEntity<user> createUser(@ModelAttribute user user) {
		log.info("Post Create API user : " + user);
		return userService.createUser(user);
	}

	@PutMapping("/user")
	public ResponseEntity<user> putMethodName(@ModelAttribute user entity) {
		System.out.println("entity : " + entity);
		return userService.putUser(entity);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		log.info("Target user : " + userId);
		return userService.deleteUser(userId);
	}
}
