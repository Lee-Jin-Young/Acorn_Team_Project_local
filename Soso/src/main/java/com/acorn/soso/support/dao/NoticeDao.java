package com.acorn.soso.support.dao;

import java.util.List;

import com.acorn.soso.support.dto.NoticeDto;

public interface NoticeDao {
	//공지 목록
	public List<NoticeDto>getList(NoticeDto dto);
	//공지목록2 (고객센터 메인 페이지에 쓰일)
	public List<NoticeDto>getList2(NoticeDto dto);
	//공지 추가
	public void insert(NoticeDto dto);
	//공지 정보 얻어오기
	public NoticeDto getData(int notice_num);
	//공지 수정
	public void update(NoticeDto dto);
	//공지 삭제
	public void delete(int notice_num);
	//공지의 갯수
	public int getCount(NoticeDto dto);
}
