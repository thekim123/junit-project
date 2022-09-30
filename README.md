# junit-project
메타코딩 junit5 강의를 보면서 따라한 프로젝트
---
### 09/29 
6강까지 들음.

---

### 09/30 

#### 7강 select 테스트

- 테스트할 때는 @Autowired로 di하는 것이 좋다.
- Transaction이 종료되면 저장된 데이터를 초기화 한다.
- BeforAll - 테스트 시작 전에 한번만 실행
- BeforeEach - 각 테스트 시작 전에 한번씩 실행
    - BeforeEach + 각 테스트를 한 Transaction으로 본다.

#### 9,10강 delete 테스트
- findById는 Optional객체를 리턴한다
  - Null과 객체를 받을 수 있음
- 책 삭제 Test를 실행하면 오류없이 되지만 전체 실행하면 오류가 난다.
  - JUnit은 테스트 메소드를 순서보장이 안된다.
  - 순서 보장을 하려면 @Order를 사용해야 한다.
  - 테스트 메서드가 하나 실행 후 종료되면 데이터가 초기화 된다.
    - @Transactional() 이 초기화를 시킴.
    >1건 ->  2건->트랜잭션 종료 ->데이터 초기화
	  ***primary key auto_increment 값이 초기화가 안됨!!

  - 해결방법
	
```java
//느려지는 단점이있다!!

@Autowired
private EntityManager em;

@BeforeEach
public void db_init(){
	bookRepository.deleteAll();
	em
		.createNativeQuery("ALTER TABLE book ALTER COLUMN id RESTART WITH 1")
		.executeUpdate();
}
```

```java
//보통은 이 방법을 쓴다!!

@Sql("classpath:db/tableInit.sql")
// id(increment)를 불러오는 메서드 위에 작성한다.
```