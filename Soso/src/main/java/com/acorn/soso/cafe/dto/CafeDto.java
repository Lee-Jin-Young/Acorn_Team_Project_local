package com.acorn.soso.cafe.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("cafeDto")
public class CafeDto {
	private int comu_num;
	private String writer;
	private String title;
	private String content;
	private String header;
	private int viewCount;
	private String regdate;
	private int group_num;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;  //이전글의 글번호
	private int nextNum;  //다음글의 글번호

	
}
