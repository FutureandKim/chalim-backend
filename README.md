# chalim-backend
차림 백엔드팀 레포지토리입니다.


## **📍**프로젝트 소개
<img width="537" alt="스크린샷 2024-06-25 오후 11 29 23" src="https://github.com/Cha-lim/chalim-backend/assets/95922668/e88be2c1-a8bb-46fd-8e6e-38c4bc72297e">


단순번역을 넘어서 음식에 대한 상세한 정보를 제공함으로써 외국인 사용자들이 메뉴를 더 쉽게 이해하고 선택할 수 있도록 돕는 것을 목적
    
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


---


## 📍 기능 요약
1. 언어 지원: 영어, 일본어, 중국어 기능 제공

    <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/5079cf69-e641-47e5-8d49-fd711cdf51e2" width="200" height="400"/>
    <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/9408936b-8551-461d-ba97-3a0f70d5a501" width="200" height="400"/>

2. 텍스트 기반 AI 정보 제공: 카메라로 메뉴판을 찍으면 텍스트를 인식하여 각 메뉴를 사용자가 이해하기 쉽도록 자국의 언어로 번역해주며 chat GPT를 이용하여 각 음식에 대한 설명, 알레르기 정보를 간략하게 제공

   <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/2dcbf046-6587-4d3e-9ad8-0fcab7f7cd60" width="200" height="400"/>
   <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/d766f58e-8b62-4714-934e-4c3d572d21ee" width="200" height="400"/>
   <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/b97a5d1b-69a7-477d-b450-60ce897bd9ee" width="200" height="400"/>

3. 환율 기반 가격 정보: 사용자의 국가 화폐 단위로 환율을 적용해 음식 가격 정보를 제공

   <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/e43c8abb-43af-4145-8131-361a9a14f4bc" width="200" height="400"/>

4. 리뷰 분석 및 추천 메뉴 제공: 음식점 리뷰를 분석해 인기메뉴를 추천하고, 이를 워드클라우드 형태로 시각화

   <img src="https://github.com/Cha-lim/chalim-frontend/assets/86235780/9e20a86a-a52a-4b92-a6b2-fd8cf3eefd96" width="200" height="400"/>
  
---

## 📍기대효과
- 사용자들은 메뉴를 보다 쉽게 이해할 수 있음
- 자신의 식습관 및 건강상태에 맞는 음식을 선택할 수 있음
- 지불해야하는 금액에 대한 명확한 정보를 얻을 수 있음

  
