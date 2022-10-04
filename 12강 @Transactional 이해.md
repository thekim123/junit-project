
### 12강 @Transactional 이해

#### 2022.10.04
- Junit - 테스트 도구(라이브러리)
- 메서드 실행 -> 종료 -> RollBack

![](https://velog.velcdn.com/images/thekim12/post/5b58cfcf-5f41-4ec0-9581-e19e0981c960/image.png)

![](https://velog.velcdn.com/images/thekim12/post/4b29f90e-c414-42e0-bd96-71285c84ee45/image.png)
#### 1. 설명
- BeforeEach -> update 순으로 테스트 실행됨.
- 이 때 BeforeEach에서 수행한 데이터가 다음 테스트 시에 메모리에 남게 된다.
- 그래서 이것을 지우는 초기화를 하더라도 auto-increment 때문에 id가 계속해서 증가하는 현상이 일어난다.
- 이것을 없애려면 테이블을 drop 해야함.

#### 2. 결론
- auto-increment 때문에 id검증은 왠만하면 안하는게 좋다.
- 굳이 해야 한다면 테이블을 drop한다. ( 실제 서버가 아닌경우)
- 실제 서버라면 id검증 테스트를 정말 안하는게 좋다.
- 해야만 한다면 다른 우회하는 방식을 찾아봐야한다.



