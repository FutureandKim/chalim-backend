# Java 17 베이스 이미지 선택
FROM openjdk:17

# 작업 디렉토리 설정
WORKDIR /app

# 현재 디렉토리의 소스 코드를 컨테이너의 작업 디렉토리로 복사
COPY . /app

# Gradle을 사용하여 프로젝트 빌드
RUN ./gradlew build

# 빌드된 JAR 파일 실행
CMD ["java", "-jar", "build/libs/backend-0.0.1-SNAPSHOT.jar"]
