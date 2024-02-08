package com.frostix.backend.domain.board.api;

import com.frostix.backend.domain.board.response.boardEntityHandler;
import com.frostix.backend.domain.board.service.boardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import com.frostix.backend.domain.board.VO.boardVO;
import com.frostix.backend.domain.board.VO.resultVO;

import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/board")
@Log4j2
public class boardController {
	private final boardService boardServ;
	private final boardEntityHandler handler;

	public boardController(boardService boardServ, boardEntityHandler handler) {
		this.boardServ = boardServ;
		this.handler = handler;
	}

	/***
	 * @apiNote
	 *          <h2>Subs</h2>
	 *          - return status code & data & message <br>
	 *          - Use try-catch. <br>
	 *          -------------
	 *          <h2>Logic</h2>
	 *          - if setData && setMessage -> send Ok status <200>
	 *          - else send Not found status <404>
	 * @param id
	 * @return response entity
	 */
	@GetMapping("/list/{id}")
	public ResponseEntity<resultVO> getBoard(@PathVariable int id) {
		log.info("Get board's item from board ID");
		resultVO dto = new resultVO();
		try {
			boardVO vo = boardServ.getBoard(id);
			dto.setData(vo);
			dto.setMessage("success !");
			return ResponseEntity.ok()
					.body(dto);
		} catch (Exception e) {
			log.error("[Board Exception] Get board one : " + e.getMessage(), e);
			return ResponseEntity.notFound()
					.build();
		}
	}

	@GetMapping("/list")
	@Nullable
	public Map<Integer, boardVO> getBoardList() {
		try {
			Map<Integer, boardVO> boardData = boardServ.getBoardList();
			return boardData;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
		}
	}

	@PostMapping("write")
	public int postBoard() {

		return 1;
	}
}
