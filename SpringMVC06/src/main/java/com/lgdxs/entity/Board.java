package com.lgdxs.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	// jpa에서는 대부분 long을 사용함 이게 권장사항이라고...함...?
	
	private String title;
	
	@Column(length = 2000)
	private String contents;
	
	@Column(updatable = false) // 수정 막음
	private String writer;
	
//	@Column(insertable = false, updatable = false, columnDefinition = "int default 0")
	@Column(insertable = false, columnDefinition = "int default 0")
	private Long count;
	
	@Column(insertable = false, updatable = false, columnDefinition = "datetime default now()")
	private Date indate;
	
	@Builder
	public Board(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
	public void updateBoard(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public void updateCount() {
		this.count += 1;
	}
}
