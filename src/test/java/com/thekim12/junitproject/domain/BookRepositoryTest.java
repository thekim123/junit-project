package com.thekim12.junitproject.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class BookRepositoryTest {

	@Autowired // 테스트할 때는 @autowired로 DI하는게 좋다.
	private BookRepository bookRepository;

	@BeforeEach // 각 테스트 시작 전에 한번씩 실행
	public void 데이터준비() {
		String title = "junit";
		String author = "momo";

		Book book = Book.builder().title(title).author(author).build();
		bookRepository.save(book);
	}

	// 1. 책 등록
	@Test
	public void 책등록_test() {
		// given ( 데이터 준비 )
		String title = "junit5";
		String author = "thekim12";

		Book book = Book.builder().title(title).author(author).build();

		// when ( 테스트 실행 )
		Book bookPersistence = bookRepository.save(book);

		// then ( 검증 )
		assertEquals(title, bookPersistence.getTitle());
		assertEquals(author, bookPersistence.getAuthor());
	} // 트랜잭션 종료(저장된 데이터를 초기화함)

	// 2. 책 목록보기
	@Test
	public void 책목록보기_test() {
		// given - 줄 데이터 없음
		String title = "junit";
		String author = "momo";

		// when
		List<Book> bookPersistence = bookRepository.findAll();

		// then
		assertEquals(title, bookPersistence.get(0).getTitle());
		assertEquals(author, bookPersistence.get(0).getAuthor());

	}

	// 3. 책 한권보기
	@Sql("classpath:db/tableInit.sql")
	@Test
	public void 책한건보기_test() {
		// given
		String title = "junit";
		String author = "momo";

		// when
		Book bookPersistence = bookRepository.findById(1L).get();

		// then
		assertEquals(title, bookPersistence.getTitle());
		assertEquals(author, bookPersistence.getAuthor());
	}

	// 4. 책 삭제
	@Sql("classpath:db/tableInit.sql")
	@Test
	public void 책삭제_test() {
		// given
		Long id = 1L;

		// when
		bookRepository.deleteById(id);

		// then
		assertFalse(bookRepository.findById(id).isPresent());
	}

	// 5. 책 수정
	@Sql("classpath:db/tableInit.sql")
	@Test
	public void 책수정_test() {
		// given
		Long id = 1L;
		String title = "junit5";
		String author = "thekim12";

		Book book = new Book(id, title, author);

		// when
		Book bookPS = bookRepository.save(book);
//		bookRepository.findAll().stream().forEach(b -> {
//			System.out.println(b.getId());
//			System.out.println(b.getTitle());
//			System.out.println(b.getAuthor());
//			System.out.println("---------------------------------");
//		});

		// then
		assertEquals(id, bookPS.getId());
		assertEquals(title, bookPS.getTitle());
		assertEquals(author, bookPS.getAuthor());
		
	}

}
