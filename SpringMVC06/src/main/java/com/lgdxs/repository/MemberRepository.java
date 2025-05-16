package com.lgdxs.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgdxs.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>  {

	Member findByIdAndPw(String id, String pw);
	
	

}
