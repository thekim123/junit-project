package com.thekim12.junitproject.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.thekim12.junitproject.domain.BookRepository;
import com.thekim12.junitproject.util.MailSenderStub;
import com.thekim12.junitproject.web.dto.BookRespDto;
import com.thekim12.junitproject.web.dto.BookSaveReqDto;

@DataJpaTest
public class BookServiceTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void 책등록하기_테스트() {
		// given
		BookSaveReqDto dto = new BookSaveReqDto();
		dto.setTitle("junit lecture");
		dto.setAuthor("momo");
		
		// stub
		MailSenderStub mailSenderStub = new MailSenderStub();
		
		// when
		BookService bookService = new BookService(bookRepository, mailSenderStub);
		BookRespDto bookRespDto =  bookService.책등록하기(dto);
		
		// then
		assertEquals(dto.getTitle(), bookRespDto.getTitle());
		assertEquals(dto.getAuthor(), bookRespDto.getAuthor());
	}

}