# chalim-backend
차림 백엔드팀 레포지토리입니다.


## **📍**프로젝트 소개
<img width="537" alt="스크린샷 2024-06-25 오후 11 29 23" src="https://github.com/Cha-lim/chalim-backend/assets/95922668/e88be2c1-a8bb-46fd-8e6e-38c4bc72297e">

---

## **📍사용 기술 스택**

- **프레임워크**: Spring Boot, Flask
- **언어**: Java 17, python
- **데이터베이스**: H2 (runtime only)
- **API 클라이언트**: Google Maps Services, Open AI
- **유효성 검사**: Hibernate Validator
- **클라우드 서비스**: Naver Cloud Platform
- **컨테이너**: Docker

---

## **📍아키텍처**
<img width="745" alt="스크린샷 2024-06-25 오후 11 29 33" src="https://github.com/Cha-lim/chalim-backend/assets/95922668/366e2fad-8338-4865-8669-d7c1cf7a60ee">

---

## **📍역할**

-   시스템 아키텍처 설계
-   Docker를 사용한 코드 컨테이너화
-   Flask를 이용한 AI 모델 서빙_OCR 모델을 API로 통합하여 서비스 제공
-   Open AI를 이용한 메뉴 설명 API
-   사용자 위치 좌표 전송 및 음식점 조회
-   워드클라우드

---

## **📍개발 환경**

- **운영체제**: Ubuntu 20.04
- **IDE/에디터**: IntelliJ IDEA, Visual Studio Code
- **버전 관리**: Git, GitHub
- **패키지 매니저**: Maven Central, pip (Flask 용)
- **기타 도구**: Lombok, H2 Database (for in-memory database testing)

---

## **📍협업 도구**

- **커뮤니케이션**: Slack
- **프로젝트 및 문서 관리**: Notion
    <img width="625" alt="스크린샷 2024-06-25 오후 11 29 43" src="https://github.com/Cha-lim/chalim-backend/assets/95922668/6216ceb8-997a-4c66-9ec5-03cd2925baa5">

- **API Test:** Postman
- **기타 도구**: 게더 타운(협업 및 실시간 피드백 도구)
  
### 커밋 유형 지정

- 커밋 유형은 영어 대문자로 작성하기
    
    
    | 커밋 유형 | 의미 |
    | --- | --- |
    | Feat | 새로운 기능 추가 |
    | Fix | 버그 수정 |
    | Docs | 문서 수정 |
    | Style | 코드 formatting, 세미콜론 누락, 코드 자체의 변경이 없는 경우 |
    | Refactor | 코드 리팩토링 |
    | Test | 테스트 코드, 리팩토링 테스트 코드 추가 |
    | Chore | 패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore |
    | Design | CSS 등 사용자 UI 디자인 변경 |
    | Comment | 필요한 주석 추가 및 변경 |
    | Rename | 파일 또는 폴더 명을 수정하거나 옮기는 작업만인 경우 |
    | Remove | 파일을 삭제하는 작업만 수행한 경우 |
    | !BREAKING CHANGE | 커다란 API 변경의 경우 |
    | !HOTFIX | 급하게 치명적인 버그를 고쳐야 하는 경우 |

### 2. 제목과 본문을 빈행으로 분리

- 커밋 유형 이후 제목과 본문은 한글로 작성하여 내용이 잘 전달될 수 있도록 할 것
- 본문에는 변경한 내용과 이유 설명 (어떻게보다는 무엇 & 왜를 설명)

### 3. 제목 첫 글자는 대문자로, 끝에는 `.` 금지

### 4. 제목은 영문 기준 50자 이내로 할 것

### 5. 자신의 코드가 직관적으로 바로 파악할 수 있다고 생각하지 말자

### 6. 여러가지 항목이 있다면 글머리 기호를 통해 가독성 높이기

```
- 변경 내용 1
- 변경 내용 2
- 변경 내용 3
```

</aside>

### 규칙에 맞는 좋은 커밋메시지를 작성해야 하는 이유

- 팀원과의 소통
- 편리하게 과거 추적 가능
- 나중에 실무에서 익숙해지기 위해


### 한 커밋에는 한 가지 문제만!

- 추적 가능하게 유지해주기
- 너무 많은 문제를 한 커밋에 담으면 추적하기 어렵다.

  
