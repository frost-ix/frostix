package com.frostix.backend.domain.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.frostix.backend.domain.user.VO.user;
import com.frostix.backend.domain.user.repository.UserRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

	@Autowired
	private final PasswordEncoder pwEncoder;
	@Autowired
	private final UserRepo userRepo;

	public UserServiceImpl(PasswordEncoder pwEncoder, UserRepo userRepo) {
		this.pwEncoder = pwEncoder;
		this.userRepo = userRepo;
	}

	@Override
	public ResponseEntity<List<user>> getUsers() {
		List<user> user = userRepo.findAll();
		return ResponseEntity.ok()
				.body(user);
	}

	@Override
	public ResponseEntity<user> createUser(user user) {
		log.info("Create user : " + user);
		user confirmUser = new user();
		if (!user.getUserStatus().equals("unknown")) {
			String userId = user.getUserId();
			if (userRepo.existsById(userId)) {
				log.error("User already exists. Return default value.");
				return ResponseEntity.badRequest()
						.body(user);
			}
			String raw = user.getUserPw();
			String encoded = pwEncoder.encode(raw);

			log.info("Encoded password : " + encoded);

			user.setUserPw(encoded);
			confirmUser = userRepo.save(user);
			return ResponseEntity.ok()
					.body(confirmUser);
		} else {
			log.error("User is null. Return default value.");
			return ResponseEntity.badRequest()
					.body(user);
		}
	}

	@Override
	public ResponseEntity<user> putUser(user user) {
		log.info("Put user : " + user);

		String raw = user.getUserPw();
		String encoded = pwEncoder.encode(raw);

		log.info("Encoded password : " + encoded);
		user.setUserPw(encoded);

		userRepo.save(user);
		return ResponseEntity.ok()
				.body(user);
	}

	@Override
	public ResponseEntity<String> deleteUser(String userId) {
		try {
			if (userId == null || userId.isEmpty()) {
				return ResponseEntity.badRequest()
						.body("var empty");
			} else if (!userRepo.existsById(userId)) {
				return ResponseEntity.badRequest()
						.body("Not found");
			}
			userRepo.deleteById(userId);
			return ResponseEntity.ok()
					.body("success");
		} catch (Exception e) {
			log.error("Error delete user : " + e);
			return ResponseEntity.badRequest()
					.body("error denied");
		}
	}
}
