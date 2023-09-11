package com.acorn.soso.group_managing.dao;

import java.util.List;

import com.acorn.soso.group_managing.dto.GroupMemberInfoDto;

public interface GroupMemberInfoDao {
	public List<GroupMemberInfoDto> getGroupMemberWritingList(GroupMemberInfoDto dto);
	public List<GroupMemberInfoDto> getGroupMemberCommentList(GroupMemberInfoDto dto);
	public int getGroupMemberWCount(GroupMemberInfoDto dto);
	public int getGroupMemberCCount(GroupMemberInfoDto dto);
}
