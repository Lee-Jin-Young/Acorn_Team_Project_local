package com.acorn.soso.test.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.acorn.soso.test.dto.BookDto;

public interface BookDao {
	public void saveBook(BookDto dto);
	public List<BookDto> bookList(int group_num);
	public void deleteBook(BookDto dto);
}
