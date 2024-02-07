package com.frostix.backend.domain.user.VO;

import lombok.Data;

@Data
public class user {
	String userId;
	String userPw;

	public user() {
		this.userId = "unknown";
		this.userPw = "0000";
	}

	public user(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
}
