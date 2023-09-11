package com.acorn.soso.group.dao;

import com.acorn.soso.group.dto.GroupDto;
import com.acorn.soso.group.dto.GroupJoinDto;

public interface GroupJoinDao {
	//소모임 가입을 위한 인서트
	public void insert(GroupJoinDto dto);
	
	//소모임 가입 상태 확인
	public int getIsJoin(GroupJoinDto dto);
	
	//소모임 가입 신청 취소
	public void cancleJoin(GroupJoinDto dto);
	
	//그룹생성시 그룹장 소모임 가입
	public void managerJoin(GroupDto groupDto);
}
