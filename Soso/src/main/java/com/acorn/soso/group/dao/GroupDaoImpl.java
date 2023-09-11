package com.acorn.soso.group.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.soso.group.dto.GroupDto;
import com.acorn.soso.group.dto.GroupJoinDto;

@Repository
public class GroupDaoImpl implements GroupDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<GroupDto> getList(GroupDto dto) {
		return session.selectList("group.getList", dto);
	}

	//소모임 개설하기
	@Override
	public void insert(GroupDto dto) {
		session.insert("group.insert", dto);
	}

	@Override
	public GroupDto getData(int num) {
		return session.selectOne("group.getData", num);
	}

	@Override
	public void delete(int num) {
		session.delete("group.delete", num);
	}

	@Override
	public void update(GroupDto dto) {
		session.update("group.update", dto);
	}

	@Override
	public GroupDto getData(String title) {
		return session.selectOne("group.getData2", title);
	}

	@Override
	public int getCount(GroupDto dto) {
		return session.selectOne("group.getCount", dto);
	}
	
	@Override
	public void addViewCount(int num) {
		session.update("group.addViewCount", num);
		
	}
	
	@Override
	public List<GroupDto> getViewList(GroupDto dto) {
	    return session.selectList("group.getViewList", dto);
    }

	@Override
    public List<GroupDto> getGroupsByGenreAndSearch(GroupDto dto) {
        return session.selectList("group.getGroupsByGenreAndSearch", dto);
    }
	
	//group_num의 시퀀스 얻어내
	@Override
	public int groupNumSeq() {
		return session.selectOne("group.getSequence");
	}
}
