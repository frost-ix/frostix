package com.frostix.backend.domain.board.dao;

import com.frostix.backend.domain.board.VO.boardVO;

import java.util.Map;

public interface boardDAO {
    Map<Integer, boardVO> getBoardList();
}
