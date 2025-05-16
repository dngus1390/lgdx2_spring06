package com.lgdxs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
public class Member {
	
	@Id
	private String id;
	
	private String pw;
	
	private String nick;
	
	private String addr;

}
