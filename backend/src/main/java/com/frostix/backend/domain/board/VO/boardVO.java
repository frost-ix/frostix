package com.frostix.backend.domain.board.VO;

import lombok.Data;

@Data
public class boardVO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private int viewCnt;
}
