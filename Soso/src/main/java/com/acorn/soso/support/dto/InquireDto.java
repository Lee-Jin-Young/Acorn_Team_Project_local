package com.acorn.soso.support.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("inquireDto")
public class InquireDto {
	private int cs_num;
	private String writer;
	private String category;
	private String title;
	private String content;
	private int confirm;
	private String regdate;
	private String user_email;
	private String answer;
}
