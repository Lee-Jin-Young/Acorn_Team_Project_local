package com.acorn.soso.group.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.soso.group.dto.GroupDto;
import com.acorn.soso.group.dto.GroupReviewDto;


public interface GroupService {
	//list가져오기
	public void getList(HttpServletRequest request);
	//ranking list 가져오기
	public void getRanking(HttpServletRequest request);
	
	//사진 upload*DB 저장하기
	public void saveImage(GroupDto dto, HttpServletRequest request);
	//detail 페이지에 필요한 data를 ModelAndView에 저장
	public void getDetail(ModelAndView mView, int num);
	//모임 업데이트(request로 수정사항을 받아서 dto에 저장한 다음에 전송)
	public void update(GroupDto dto, HttpServletRequest request);
	//모임 삭제-> 번호를 매개로 해서 삭제
	public void delete(int num);
	
	//리뷰에 관련한 기능
	//리뷰 저장
	public void saveReview(HttpServletRequest request);
	//리뷰 삭제
	public void deleteReview(HttpServletRequest request);
	//리뷰 수정
	public void updateReview(GroupReviewDto dto);
	//ajax 리스트 출력
	public void moreReview(HttpServletRequest request);
	//평점 평균
	public void avgRate(String title);
	//detail 페이지에 리뷰 보이게 하기 위한 리뷰 리스트 호출
	public void reviewList(HttpServletRequest request, Model model);
	
	//소모임 가입에 관련한 기능
	public void joinGroup(HttpServletRequest request);
	
	//찜하기 및 찜 취소하기
	public void jjim(HttpServletRequest request);
	//ajax처리로 찜하기&찜취소 기능 구현
	public boolean jjim2(HttpServletRequest request);
	//찜 여부 확인
	public void knowjjim(HttpServletRequest request);
	
}
