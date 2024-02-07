package com.frostix.backend.domain.user.VO;

import lombok.Data;

@Data
public class user {
	String userId;
	String userPw;
	String nickname;

	public user() {
		this.userId = null;
		this.userPw = null;
		this.nickname = "익명";
	}
}
