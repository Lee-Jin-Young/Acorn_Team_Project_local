package com.acorn.soso.group.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.soso.group.dto.GroupDto;
import com.acorn.soso.group.dto.GroupJoinDto;
@Repository
public class GroupJoinDaoImpl implements GroupJoinDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public void insert(GroupJoinDto dto) {
		session.insert("join.insert", dto);
	}

	@Override
	public int getIsJoin(GroupJoinDto dto) {
	    try {
	        return session.selectOne("join.getIsJoin", dto);
	    } catch (Exception e) {
	        // 예외 처리 로직
	        return -1; // 예외 발생 시 -1 반환
	    }
	}

	@Override
	public void cancleJoin(GroupJoinDto dto) {
		session.delete("join.cancleJoin", dto);
	}

	@Override
	public void managerJoin(GroupDto groupDto) {
		session.insert("join.managerJoin", groupDto);
		session.update("join.updateNow", groupDto);
	}
}
