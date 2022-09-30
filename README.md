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

