package com.frostix.backend.domain.user.api;

import org.springframework.web.bind.annotation.RestController;

import com.frostix.backend.domain.user.VO.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class userAPI {
	@GetMapping("mypage")
	public ResponseEntity<user> getUser(@ModelAttribute user user) {
		System.out.println("userInfo : " + user);
		ResponseEntity<user> userInfo = new ResponseEntity<>(HttpStatus.OK);
		return userInfo;
	}

	/***
	 * @apiNote
	 *          <h1>createUser</h1>
	 * @param user
	 * @return ResponseEntity<user>
	 */
	@PostMapping("/create")
	public ResponseEntity<user> createUser(@ModelAttribute user user) {
		user backUser = new user();
		System.out.println("backUser (default) : " + backUser);
		System.out.println("ModelAttribute (from Front) : " + user);
		backUser = user;
		System.out.println("Changed value : " + backUser);
		return ResponseEntity.ok()
				.body(backUser);
	}

	@PutMapping("/update")
	public ResponseEntity<user> putMethodName(@ModelAttribute user entity) {
		System.out.println("entity : " + entity);
		return ResponseEntity.ok()
				.body(entity);
	}

	@DeleteMapping("/delete")
	public int deleteUser() {
		return 0;
	}
}
