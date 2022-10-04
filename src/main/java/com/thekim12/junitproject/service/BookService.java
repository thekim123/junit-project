package com.thekim12.junitproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thekim12.junitproject.domain.Book;
import com.thekim12.junitproject.domain.BookRepository;
import com.thekim12.junitproject.web.dto.BookRespDto;
import com.thekim12.junitproject.web.dto.BookSaveReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;

	// 1. 책등록
	@Transactional(rollbackFor = RuntimeException.class)
	public BookRespDto 책등록하기(BookSaveReqDto dto) {
		Book bookPS = bookRepository.save(dto.toEntity());
		return new BookRespDto().toDto(bookPS);
	}

	// 2. 책 목록보기
	public List<BookRespDto> 책목록보기(){
		return bookRepository.findAll().stream()
				.map(new BookRespDto()::toDto)
				.collect(Collectors.toList());
	}

	// 3. 책 한건보기

	// 4. 책삭제

	// 5. 책수정

}
