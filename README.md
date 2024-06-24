# chalim-backend
메뉴번역 서비스 '차림' 백엔드 레포지토리

![image](https://github.com/FutureandKim/chalim-backend/assets/95979743/b1a63df6-28c0-429d-8df6-6173a917852b)

### 기술 스택
    언어: Java
    프레임워크: SpringBoot 
    DB: Mysql
    ORM: JPA
    AI 모델 서빙: Flask


### 프로젝트 소개
#### 목적 및 필요성
  
단순한 번역을 넘어서 음식에 대한 상세한 정보를 제공함으로써 외국인 사용자들이 메뉴를 더 쉽게 이해하고 선택할 수 있도록 돕는 것을 목적

#### 기능 요약

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







   
####  기대효과
- 사용자들은 메뉴를 보다 쉽게 이해할 수 있음
- 자신의 식습관 및 건강상태에 맞는 음식을 선택할 수 있음
- 지불해야하는 금액에 대한 명확한 정보를 얻을 수 있음

  
