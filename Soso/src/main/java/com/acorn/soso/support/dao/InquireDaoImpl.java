package com.acorn.soso.support.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.soso.support.dto.InquireDto;

@Repository
public class InquireDaoImpl implements InquireDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(InquireDto dto) {
		session.insert("inquire.insert", dto);
	}

	@Override
	public List<InquireDto> getList(String id) {
		return session.selectList("inquire.getList", id);
	}
	@Override
	public List<InquireDto> getList2(String id) {
		return session.selectList("inquire.getList2", id);
	}

	@Override
	public InquireDto getData(int cs_num) {
		return session.selectOne("inquire.getData", cs_num);
	}

	@Override
	public void update(InquireDto dto) {
		session.update("inquire.update", dto);
	}

	@Override
	public void delete(int cs_num) {
		session.delete("inquire.delete", cs_num);
		
	}

}
