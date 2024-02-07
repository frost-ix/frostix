package com.frostix.backend.domain.user.api;

import org.springframework.web.bind.annotation.RestController;

import com.frostix.backend.domain.user.VO.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController("/user")
public class userAPI {
	@GetMapping("/mypage")
	public user getUser() {
		return new user();
	}

	/***
	 * @apiNote
	 * @param user
	 * @return
	 */
	@PostMapping("/create")
	public int createUser(@RequestBody ResponseEntity<user> user) {
		int num = 0;
		String name = user.getBody().getNickname();
		System.out.println(name);
		if (name != null) {
			num = 1;
		}
		return num;
	}

	@PutMapping("/update")
	public ResponseEntity<user> putMethodName(@PathVariable String id, @RequestBody ResponseEntity<user> entity) {
		// TODO: process PUT request
		return entity;
	}

	@DeleteMapping("/delete")
	public int deleteUser() {
		return 0;
	}
}
