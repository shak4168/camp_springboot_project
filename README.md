# 상품/주문 관리 서비스

Spring Boot JPA를 활용한 상품 및 주문 관리 CRUD 프로젝트

## 기술 스택
- Java 17
- Spring Boot 4.1.0
- Spring Data JPA
- H2 Database
- Lombok
- Swagger

## 기능
- 상품 CRUD (등록/조회/수정/삭제)
- 주문 생성 및 단건 조회
- 주문 목록 페이지네이션
- N+1 문제 (JOIN FETCH) - 도전
- 재고 차감 및 낙관적 락(@Version) - 도전

## 주문 목록 조회를 실행하신 후 실행 응답
<img width="1416" height="816" alt="image" src="https://github.com/user-attachments/assets/ebc0385e-a085-4d9c-84ae-75e0c7f95474" />

## 재고 1인 상품에 대해 주문을 2번 시도했을 때 결과
- 첫 번째 시도
<img width="1410" height="286" alt="image" src="https://github.com/user-attachments/assets/3d1968b3-a4b1-4447-81ac-f96c5d381418" />
- 두 번째 시도 (500 에러)
<img width="1414" height="283" alt="image" src="https://github.com/user-attachments/assets/77de4d9e-a4ee-41d4-a417-d56254511f3c" />
<img width="1329" height="162" alt="image" src="https://github.com/user-attachments/assets/7cff355d-477f-4e04-9259-81ba0174578f" />

## 추가 내용
### 예외처리
- 첫 시도
<img width="1400" height="378" alt="image" src="https://github.com/user-attachments/assets/adb18bf7-3bbe-4d0b-aa49-a7df66cddb62" />
- 두 번째 시도 (400 에러)
<img width="1138" height="321" alt="image" src="https://github.com/user-attachments/assets/839b5b01-4589-4415-942d-b6a25e116846" />

## 실행 방법
1. 프로젝트 클론
2. 서버 실행
3. http://localhost:8080/swagger-ui/index.html 접속
