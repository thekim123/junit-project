#### 2022.10.04 수강

### 14강. 서비스레이어 책 목록보기
```java
	public List<BookRespDto> 책목록보기(){
		return bookRepository.findAll().stream()
				.map(new BookRespDto()::toDto)
				.collect(Collectors.toList());
	}
```

- stream에 대한 수업이 진행되었다.
![](https://velog.velcdn.com/images/thekim12/post/1710fc08-eb9b-458f-be4f-3d7664e848e2/image.png)
![](https://velog.velcdn.com/images/thekim12/post/0a86af33-26d3-4e14-88ba-49351d899041/image.png)


- 위 그림을 참조하여 어부가 물고기를 잡는 과정처럼 이해하면 편하다.
- stream은 하나의 강인데, 여러 물고기가 살고 있다.
- filter를 통해 강에 있는 물고기 종을 고른다.
- map을 이용하여 filter로 고른 물고기들을 새로운 stream(강)을 만들어 넣는다.
- collect로 이 물고기들을 List로 만든다(예를 들어 통조림 가공을 한다던지).
- 자바 1.8에 나온 메서드 참조 문법이다.
- 생성자도 참조할 수 있고, 특정 인스턴스 메서드, static메서드도 참조할 수 있다.
- 야 북레포에서 전부다 들고와서 물가에 일단 뿌려 그리고 이거 변환해서 다시 복제해서 들고갈게 얘로 toDto로 변환하고 얘만 있으니까 다시 들고갈게. - 비유임


위 코드는 아래처럼 적을 수도 있다.
```java
public List<BookRespDto> 책목록보기(){
	return bookRepository.findAll().stream()
		.map((bookPS) -> new BookRespDto().toDto(bookPS))
		.collect(Collectors.toList());
	}
```

