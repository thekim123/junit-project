#### 2022.09.22 수강


## 11강 update 테스트

```java
	@Test
	public void 책수정_test() {
		// given
		Long id = 1L;
		String title = "junit5";
		String author = "thekim12";

		Book book = new Book(id, title, author);

		// when
		Book bookPS = bookRepository.save(book);
		bookRepository.findAll().stream().forEach(b -> {
			System.out.println(b.getId());
			System.out.println(b.getTitle());
			System.out.println(b.getAuthor());
			System.out.println("---------------------------------");
		});

		// then
```
업데이트 테스트를 구현하고 실행해보았다.
부분 테스트를 실행하면 제대로 나오는데 전체 테스트를 실행하면 아래 그림과 같은 결과가 나온다.
![](https://velog.velcdn.com/images/thekim12/post/d500e590-1208-498c-8397-6f615f3e1d97/image.png)

어... 분명 id가 1이 나와야되는데 왜why 5와 6인가? 이것은 insert가 두번되었다는 것인데...

이것은 저번 시간에 했던 것과 같은 이유로 increment속성이 계속 증가하기 때문이다. 저번에 했던것과 똑같이 이 테스트를 수행하기 전에 테이블 삭제 쿼리를 실행시키도록 했다.

```java
	@Sql("classpath:db/tableInit.sql")
	@Test
	public void 책수정_test() {
		// given
```


실행 결과는 아래와 같다.
![](https://velog.velcdn.com/images/thekim12/post/9cea7c3e-ecdc-4811-af05-9c4088b107c2/image.png)

결과적으로 총 개수가 1개뿐이니 업데이트가 완료된것이다.

그런데 이상한 점은 저렇게 테이블을 드롭시키면 beforeEach에서 insert한 데이터는 안날라가는 것일까? 이 부분은 다음 시간에 알려준다고 하신다.

코드의 마지막에 
```java
		assertEquals(id, bookPS.getId());
		assertEquals(title, bookPS.getTitle());
		assertEquals(author, bookPS.getAuthor());
```
를 추가시키고 마무리하였다.



