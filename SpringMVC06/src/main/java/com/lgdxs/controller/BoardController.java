package com.lgdxs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgdxs.entity.Board;
import com.lgdxs.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// Spring Boot를 시작하는 클래스
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		List<Board> boardList = boardService.boardList();
		
		System.out.println(boardList.toString());
		
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	@GetMapping("/boardContents.do")
	public String boardContents(@RequestParam("idx") Long idx, Model model) {
		Board board = boardService.boardContents(idx);
		boardService.boardCount(idx);
		System.out.println(board.toString());
		
		model.addAttribute("board", board);
		model.addAttribute("ln","\n");
		return "boardContents";
	}
	
	@GetMapping("/boardInsert.do")
	public String boardInsert() {
		return "boardInsert";
	}
	
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board board) {
		boardService.boardInsert(board);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx") Long idx) {
		boardService.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardUpdate.do")
	public String boardUpdate(@RequestParam("idx")Long idx, Model model) {
		model.addAttribute("board", boardService.boardContents(idx));
		return "boardUpdate";
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(@RequestParam("idx")Long idx, Board board) {
		boardService.boardUpdate(board);
		return "redirect:/boardContents.do?idx=" + idx;
	}
	
	
	
}
