package com.acorn.soso.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.soso.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SqlSession session;
	
	/*
	 * 매개변수로 전달되는 아이디가 DB에 이미 존재하는지 여부를 리턴하는 메소드
	 */
	@Override
	public int isExist(String inputId) {
		//DB에 저장된 같은 아이디가 0이면 존재하지 않는 아이디
		return session.selectOne("users.isExist", inputId);
	}
	
	@Override
	public int isExist2(String userName) {
		//DB에 저장된 같은 이름이 0이면 존재하지 않는 이름
		return session.selectOne("users.isExist2", userName);
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
		
	}

	@Override
	public UsersDto getData(String id) {
		// 여기서 최종적으로 리턴되는 값은 users.getData() 메소드를 호출한 뒤에 반환되는 resultType 데이터이다.
		return session.selectOne("users.getData", id);
	}
	@Override
	public UsersDto getNaver(String email) {
		return session.selectOne("users.getNaver", email);
	}
	
	@Override
	public void updatePwd(UsersDto dto) {
		session.update("users.updatePwd", dto);
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}
	
	@Override
	public UsersDto getId(String userName) {
		return session.selectOne("users.getId", userName);
	}

	@Override
	public void UpdateSocail(String id) {
		session.update("users.updateSocial", id);
		
	}
}
