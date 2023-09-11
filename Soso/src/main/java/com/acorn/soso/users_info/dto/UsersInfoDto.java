package com.acorn.soso.users_info.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("usersInfoDto")
public class UsersInfoDto {
	private int num;
	private String group_name;
	private String writer;
	private String title;
	private String regdate;
	private String content;
	private int group_num;
	private int comu_num;
	private int cs_num;
	
	private int startRowNum;
	private int endRowNum;
	private int prevNum;  //이전글의 글번호
	private int nextNum;  //다음글의 글번호
}
