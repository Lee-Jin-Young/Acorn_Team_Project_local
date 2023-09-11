package com.acorn.soso.support.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.soso.support.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<NoticeDto> getList(NoticeDto dto) {
		
		return session.selectList("notice.getList",dto);
	}
	//고객센터 메인페이지에 쓰일 목록
	@Override
	public List<NoticeDto> getList2(NoticeDto dto) {
		
		return session.selectList("notice.getList2",dto);
	}

	@Override
	public void insert(NoticeDto dto) {
		
		session.insert("notice.insert",dto);
	}

	@Override
	public NoticeDto getData(int notice_num) {
		
		return session.selectOne("notice.getData",notice_num);
	}

	@Override
	public void update(NoticeDto dto) {
		
		session.update("notice.update",dto);
	}

	@Override
	public void delete(int notice_num) {
		
		session.delete("notice.delete",notice_num);
	}

	@Override
	public int getCount(NoticeDto dto) {
		
		return session.selectOne("notice.getCount",dto);
	}

}
