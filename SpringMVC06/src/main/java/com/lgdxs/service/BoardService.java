package com.lgdxs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgdxs.entity.Board;
import com.lgdxs.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	public List<Board> boardList() {
		// TODO Auto-generated method stub
		return boardRepository.findAll();
	}

	public Board boardContents(Long idx) {
		// TODO Auto-generated method stub
		return boardRepository.findById(idx)
				.orElseThrow(() -> new RuntimeException("에러"));
	}
	
	public void boardInsert(Board board) {
		// TODO Auto-generated method stub
		boardRepository.save(board);
	}

	public void boardDelete(Long idx) {
		// TODO Auto-generated method stub
		boardRepository.deleteById(idx);
	}
	
	@Transactional
	public void boardUpdate(Board board) {
		// TODO Auto-generated method stub
		Board oBoard = boardRepository.findById(board.getIdx())
				.orElseThrow(() -> new RuntimeException("해당 포스트는 존재하지 않음"));
		oBoard.updateBoard(board.getTitle(), board.getContents());
	}
	
	@Transactional
	public void boardCount(Long idx) {
		// TODO Auto-generated method stub
		Board board = boardRepository.findById(idx)
				.orElseThrow(() -> new RuntimeException("해당 포스트는 존재하지 않습니다."));
		board.updateCount();
		boardRepository.count(idx);
	}



	

}
