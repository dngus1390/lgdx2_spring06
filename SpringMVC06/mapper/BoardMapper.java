package com.lgdxs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lgdxs.entity.Board;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT * FROM BOARD")
	List<Board> boardList();
	
	@Select("SELECT * FROM BOARD WHERE IDX = #{idx}")
	Board boardContents(int idx);
	
	@Insert("INSERT INTO BOARD(TITLE, CONTENTS, WRITER) VALUES (#{title}, #{contents}, #{writer})")
	void boardInsert(Board board);
	
	@Delete("DELETE FROM BOARD WHERE IDX=#{idx}")
	void boardDelete(int idx);
	
	@Update("UPDATE BOARD SET TITLE = #{title}, CONTENTS = #{contents}, WRITER = #{writer} WHERE IDX=#{idx} ")
	void boardUpdate(Board board);
	
	@Update("UPDATE BOARD SET COUNT = COUNT+1 WHERE IDX = #{idx}")
	void boardCount(int idx);
	
	
	
	
	
}
