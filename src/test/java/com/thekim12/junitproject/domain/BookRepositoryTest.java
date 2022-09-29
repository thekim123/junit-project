package com.thekim12.junitproject.domain;


import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired  // 테스트할 때는 @autowired로 di하는게 좋다.
    private BookRepository bookRepository;

    // 1. 책 등록
    @Test
    public void 책등록_test(){
        // given ( 데이터 준비 )
        String title = "junit5";
        String author = "thekim12";

        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        // when ( 테스트 실행 )
        Book bookPersistence = bookRepository.save(book);

        // then ( 검증 )
        assertEquals(title, bookPersistence.getTitle());
        assertEquals(author, bookPersistence.getAuthor());
    }

    // 2. 책 목록보기

    // 3. 책 한권보기

    // 4. 책 수정

    // 5. 책 삭제

}
