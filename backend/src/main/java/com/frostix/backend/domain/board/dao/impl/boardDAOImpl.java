package com.frostix.backend.domain.board.dao.impl;

import com.frostix.backend.domain.board.VO.boardVO;
import com.frostix.backend.domain.board.dao.boardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class boardDAOImpl implements boardDAO {
    @Override
    public Map<Integer, boardVO> getBoardList() {
        return null;
    }
}
