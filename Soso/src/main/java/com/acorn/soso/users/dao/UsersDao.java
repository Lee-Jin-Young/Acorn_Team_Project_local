package com.acorn.soso.users.dao;

import com.acorn.soso.users.dto.UsersDto;

public interface UsersDao {
	//인자로 전달된 아이디가 존재 하는지 여부를 리턴하는 메소드
	public int isExist(String inputId);
	//인자로 전달된 아이디가 존재 하는지 여부를 리턴하는 메소드
	public int isExist2(String userName);
	//인자로 전달된 가입하는 회원의 정보를 DB에 저장하는 메소드
	public void insert(UsersDto dto);
	//인자로 전달하는 아이디에 해당하는 정보를 리턴하는 메소드
	public UsersDto getData(String id);
	//email유저 정보 리턴
	public UsersDto getNaver(String email);
	//비밀번호를 수정하는 메소드
	public void updatePwd(UsersDto dto);
	//개인정보를 수정하는 메소드
	public void update(UsersDto dto);
	//회원정보를 삭제하는 메소드
	public void delete(String id);
	//인자로 전달하는 이름에 해당하는 정보를 리턴하는 메소드
	public UsersDto getId(String userName);
	//통합 로그인 업데이트
	public void UpdateSocail(String id);
}
