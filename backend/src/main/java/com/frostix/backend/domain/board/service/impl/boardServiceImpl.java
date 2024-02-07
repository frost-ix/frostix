package com.frostix.backend.domain.board.service.impl;

import com.frostix.backend.domain.board.VO.boardVO;
import com.frostix.backend.domain.board.service.boardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class boardServiceImpl implements boardService {
    @Override
    public boardVO getBoard(int id) {
        boardVO vo = null;
        return vo;
    }

    @Override
    public Map<Integer, boardVO> getBoardList() {
        Map<Integer, boardVO> boardList = null;
        return boardList;
    }
}
