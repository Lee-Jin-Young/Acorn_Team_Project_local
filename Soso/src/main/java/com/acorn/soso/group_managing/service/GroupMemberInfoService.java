package com.acorn.soso.group_managing.service;

import org.springframework.ui.Model;

import com.acorn.soso.group_managing.dto.GroupMemberInfoDto;

public interface GroupMemberInfoService {
	public void getGroupMemberWritingList(GroupMemberInfoDto dto, Model model);
	public void getGroupMemberCommentList(GroupMemberInfoDto dto, Model model);
}
