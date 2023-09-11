package com.acorn.soso.group_managing.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("GroupMemberInfoDto")
public class GroupMemberInfoDto {
	private int num;
	private int comu_num;
	private String writer;
	private String title;
	private String regdate;
	private String content;
	private int header;
	private int group_num;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;  //이전글의 글번호
	private int nextNum;  //다음글의 글번호
}
