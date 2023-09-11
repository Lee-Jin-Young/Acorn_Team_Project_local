package com.acorn.soso.support.dao;

import java.util.List;

import com.acorn.soso.support.dto.InquireDto;

public interface InquireDao {
	//문의 등록하기
	public void insert(InquireDto dto);
	//등록한 문의글 불러오기
	public List<InquireDto> getList(String id);
	//등록한 문의글 불러오기(관리자가 볼 문의 내역리스트 )
	public List<InquireDto> getList2(String id);
	//등록한 문의글 상세 페이지 불러오기
	public InquireDto getData(int cs_num);
	//등록한 문의글 수정하기
	public void update(InquireDto dto);
	//등록한 문의글 삭제하기
	public void delete(int cs_num);
}
