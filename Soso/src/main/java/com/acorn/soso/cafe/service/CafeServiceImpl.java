package com.acorn.soso.cafe.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.acorn.soso.cafe.dao.CafeCommentDao;
import com.acorn.soso.cafe.dao.CafeDao;
import com.acorn.soso.cafe.dto.CafeCommentDto;
import com.acorn.soso.cafe.dto.CafeDto;
import com.acorn.soso.exception.NotDeleteException;


@Service
public class CafeServiceImpl implements CafeService{
	
	@Autowired
	private CafeDao cafeDao;
	
	@Autowired
	private CafeCommentDao cafeCommentDao;
	
	@Override
	public void getList(HttpServletRequest request, Model model, int num){
		final int PAGE_ROW_COUNT=5;
		
		final int PAGE_DISPLAY_COUNT=5;
		
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum = Integer.parseInt(strPageNum);
		}
		int startRowNum = 1 + (pageNum-1)*PAGE_ROW_COUNT;
		int endRowNum = pageNum*PAGE_ROW_COUNT;
		
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		//만일 키워드가 넘어오지 않는다면 
		if(keyword==null){
			//키워드와 검색 조건에 빈 문자열을 넣어준다. 
			//클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서  
			keyword="";
			condition=""; 
		}

		//특수기호를 인코딩한 키워드를 미리 준비한다. 
		String encodedK=URLEncoder.encode(keyword);
			
		//CafeDto 객체에 startRowNum 과 endRowNum 을 담는다.
		CafeDto dto=new CafeDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setGroup_num(num);

		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("title_content")){//제목 + 내용 검색인 경우
				//검색 키워드를 CafeDto 에 담아서 전달한다.
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){ //제목 검색인 경우
				dto.setTitle(keyword);
			}else if(condition.equals("writer")){ //작성자 검색인 경우
				dto.setWriter(keyword);
			} // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}
		
		//전체글의 갯수
		int totalRow=cafeDao.getCount(dto);
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		//전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount; //보정해 준다.
		}
		
		//글 목록 얻어오기
		List<CafeDto> list = cafeDao.getList(dto);
		
		//view page 에서 필요한 값을 Model 에 담아준다. 
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
		model.addAttribute("encodedK", encodedK);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("cafelist", list);
		model.addAttribute("totalRow", totalRow);
	}

	@Override
	public void getDetail(HttpServletRequest request, Model model, CafeDto dto) {
		
		//해당 글의 상세 페이지 링크를 통해 조회했을 때 해당 게시글의 조회수 올리기
		cafeDao.addViewCount(dto.getComu_num());
		
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		//만일 키워드가 넘어오지 않는다면 
		if(keyword==null){
			//키워드와 검색 조건에 빈 문자열을 넣어준다. 
			//클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서  
			keyword="";
			condition=""; 
		}
		
		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("title_content")){//제목 + 내용 검색인 경우
				//검색 키워드를 CafeDto 에 담아서 전달한다.
				dto.setTitle(keyword);
				dto.setContent(keyword);			
			}else if(condition.equals("title")){ //제목 검색인 경우
				dto.setTitle(keyword);	
			}else if(condition.equals("writer")){ //작성자 검색인 경우
				dto.setWriter(keyword);	
			} // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}
		
		//글하나의 정보를 얻어온다.
		CafeDto resultCafeDto = cafeDao.getData2(dto);
		
		//해당 글의 댓글 리스트를 얻어온다.
		CafeCommentDto resultCommentDto = cafeCommentDao.getData(dto.getComu_num());
		
		//특수기호를 인코딩한 키워드를 미리 준비한다. 
		String encodedK=URLEncoder.encode(keyword);
		
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=20;
		//detail.jsp 페이지에서는 항상 1페이지의 댓글 내용만 출력한다. 
		int pageNum=1;
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		//원글의 글번호를 이용해서 해당글에 달린 댓글 목록을 얻어온다.
		CafeCommentDto commentDto=new CafeCommentDto();
		commentDto.setComu_num(dto.getComu_num());
		//1페이지에 해당하는 startRowNum 과 endRowNum 을 dto 에 담아서  
		commentDto.setStartRowNum(startRowNum);
		commentDto.setEndRowNum(endRowNum);
		
		//1페이지에 해당하는 댓글 목록만 select 되도록 한다. 
		List<CafeCommentDto> commentList=cafeCommentDao.getList(commentDto);	
		
		//원글의 글번호를 이용해서 댓글 전체의 갯수를 얻어낸다.
		int totalRow=cafeCommentDao.getCount(dto.getComu_num());
		//댓글 전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		//Model 에 글 하나의 정보 담기
		model.addAttribute("cafeDto", resultCafeDto);
		model.addAttribute("commentDto", resultCommentDto);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
		model.addAttribute("encodedK", encodedK);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("commentList", commentList);
		model.addAttribute("totalPageCount", totalPageCount);
	}

	@Override
	public void saveContent(CafeDto dto) {
		cafeDao.insert(dto);
	}

	@Override
	public void updateContent(CafeDto dto) {
		cafeDao.update(dto);
	}

	@Override
	public void deleteContent(int comu_num, HttpServletRequest request) {
		//세션에서 로그인된 아이디를 읽어와서 
		String id=(String)request.getSession().getAttribute("id");
		//글 작성자와 로그인된 아이디가 다르다면 
		CafeDto dto=cafeDao.getData(comu_num);
		//예외를 발생시켜서 삭제가 안되도록 한다. 
		if(!id.equals(dto.getWriter())) {
			throw new NotDeleteException("남의 글 지우기 없기!");
		}
		//글 삭제하기 
		cafeDao.delete(comu_num);
	}
	//글수정 폼에 필요한 값을 HttpServletRequest 에 담아주는 메소드 
	@Override
	public void getData(HttpServletRequest request) {
		//수정할 글번호
		int comu_num=Integer.parseInt(request.getParameter("comu_num"));
		//수정할 글의 정보 얻어와서 
		CafeDto dto=cafeDao.getData(comu_num);
		//request 에 담아준다.
		request.setAttribute("dto", dto);
	}

	@Override
	public void saveComment(HttpServletRequest request) {
		//폼 전송되는 파라미터 추출 
		int comu_num=Integer.parseInt(request.getParameter("comu_num")); //원글의 글번호
		String target_id=request.getParameter("target_id"); //댓글 대상자의 아이디
		String content=request.getParameter("content"); //댓글의 내용 
		/*
		 *  원글의 댓글은 comment_group 번호가 전송이 안되고
		 *  댓글의 댓글은 comment_group 번호가 전송이 된다.
		 *  따라서 null 여부를 조사하면 원글의 댓글인지 댓글의 댓글인지 판단할수 있다. 
		 */
		String comment_group=request.getParameter("comment_group");

		//댓글 작성자는 session 영역에서 얻어내기
		String writer=(String)request.getSession().getAttribute("id");
		//댓글의 시퀀스 번호 미리 얻어내기
		int seq=cafeCommentDao.getSequence();
		
		//저장할 댓글의 정보를 dto 에 담기
		CafeCommentDto dto=new CafeCommentDto();
		dto.setComment_num(seq);
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setTarget_id(target_id);
		dto.setComu_num(comu_num);
		//원글의 댓글인경우
		if(comment_group == null){
			//댓글의 글번호를 comment_group 번호로 사용한다.
			dto.setComment_group(seq);
		}else{
			//전송된 comment_group 번호를 숫자로 바꾸서 dto 에 넣어준다. 
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		//댓글 정보를 DB 에 저장하기
		cafeCommentDao.insert(dto);	
	}

	@Override
	public void deleteComment(HttpServletRequest request) {
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		//삭제할 댓글 정보를 읽어와서 
		CafeCommentDto dto=cafeCommentDao.getData(comment_num);
		String id=(String)request.getSession().getAttribute("id");
		//글 작성자와 로그인된 아이디와 일치하지 않으면
		if(!dto.getWriter().equals(id)) {
			throw new NotDeleteException("다른 사람의 댓글을 삭제할 수 없습니다!");
		}
		//dao 를 이용해서 DB 에서 삭제하기
		cafeCommentDao.delete(comment_num);
	}

	@Override
	public void updateComment(CafeCommentDto dto) {
		cafeCommentDao.update(dto);
	}

	@Override
	public void moreCommentList(HttpServletRequest request) {
		//로그인된 아이디
		String id=(String)request.getSession().getAttribute("id");
		
		//ajax 요청 파라미터로 넘어오는 댓글의 페이지 번호를 읽어낸다
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		//ajax 요청 파라미터로 넘어오는 원글의 글 번호를 읽어낸다
		int comu_num=Integer.parseInt(request.getParameter("comu_num"));
		
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=10;
	
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
	
		//원글의 글번호를 이용해서 해당글에 달린 댓글 목록을 얻어온다.
		CafeCommentDto commentDto=new CafeCommentDto();
		commentDto.setComu_num(comu_num);
		//1페이지에 해당하는 startRowNum 과 endRowNum 을 dto 에 담아서  
		commentDto.setStartRowNum(startRowNum);
		commentDto.setEndRowNum(endRowNum);
		
		CafeDto dto = cafeDao.getData(comu_num);
		
		//pageNum에 해당하는 댓글 목록만 select 되도록 한다. 
		List<CafeCommentDto> commentList=cafeCommentDao.getList(commentDto);
		//원글의 글번호를 이용해서 댓글 전체의 갯수를 얻어낸다.
		int totalRow = cafeCommentDao.getCount(comu_num);
		//댓글 전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
	
		//view page 에 필요한 값 request 에 담아주기
		request.setAttribute("commentList", commentList);
		request.setAttribute("cafeDto", dto);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("comu_num", comu_num); //원글의 글번호
		request.setAttribute("pageNum", pageNum); //댓글의 페이지 번호
	}

}





