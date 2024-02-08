package com.frostix.backend.domain.user.VO;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection = "users")
@Data
public class user {
	@Id
	@NonNull
	String userId;
	String userPw;
	String userName;
	String userStatus;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDateTime userRegDate;

	public user() {
		this.userStatus = "unknown";
		this.userRegDate = LocalDateTime.now();
	}

	public user(String userStatus, String userId, String userPw, String userName) {
		this.userStatus = userStatus;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
}
