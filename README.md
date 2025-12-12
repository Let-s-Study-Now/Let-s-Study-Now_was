# 📚 Let's Study Now - Backend

즉석 스터디 그룹 매칭 웹사이트 백엔드 서버  
실시간으로 스터디 그룹을 매칭해주는 웹사이트의 REST API 서버입니다.  
Spring Boot 기반으로 구축되었으며, WebSocket을 통한 실시간 통신을 지원합니다. ✨

<img src="https://raw.githubusercontent.com/Let-s-Study-Now/Let-s-Study-Now_doc/refs/heads/main/mainlogo.svg" width="500" height="500" alt="Main Logo">

---

## 👤 사용자 계정 / 회원 관리

- 회원가입 (JWT 기반 인증)
- 로그인 (Spring Security)
- 프로필 관리 (AWS S3 프로필 이미지 업로드)

---

## 🤝 그룹 매칭 / 참여

- **오픈 스터디 참여**

  - 공용 스터디룸 실시간 입장/퇴장 관리
  - 참여자 상태 관리

- **그룹 스터디 참여**

  - 공부 시간 설정 기반 자동 매칭 알고리즘
  - 스터디 세션 스케줄링
  - 참여자 그룹 관리

- **URL 공유 매칭**

  - 공유 링크 생성 및 초대 관리

- **스터디룸 퇴장**
  - 실시간 참여자 상태 업데이트

---

## 🖥 스터디룸 기능

- **공부 상태 표시 (공부 / 휴식)**

  - WebSocket 기반 실시간 상태 동기화
  - 참여자 상태 브로드캐스팅

- **타이머 기능**

  - 개인별 타이머 설정 관리
  - 자동 상태 변경 스케줄링
  - 알림 발송 시스템

- **실시간 채팅**

  - WebSocket(STOMP) 기반 실시간 메시지 전송
  - 채팅 히스토리 저장

- **상태메시지 등록**
  - 사용자별 상태메시지 CRUD

---

## 📝 추가 기능

- **체크리스트**

  - 체크리스트 CRUD API
  - 완료 표시 및 순서 변경
  - 사용자별 체크리스트 관리

- **디데이 설정**

  - 중요 날짜 등록 및 관리
  - 남은 시간 계산 API

- **스터디 기록 조회**

  - 개인별 스터디 통계
  - 기간별 학습 시간 집계

- **체크리스트 달성률 조회**
  - 일별/주별/월별 달성률 계산

---

## 🚀 목표

"Let's Study Now" 백엔드는 안정적이고 확장 가능한 실시간 스터디 매칭 시스템을 제공하여  
사용자들이 원활하게 함께 공부할 수 있는 환경을 지원하는 것을 목표로 합니다.

---

# Project Build Guide

## Tech Stack

이 프로젝트는 다음 기술 스택을 사용하여 구축되었습니다:

- **Framework**: Spring Boot 3.2.5
- **Language**: Java 17
- **Build Tool**: Gradle 8.8
- **Database**: MySQL (Azure Database for MySQL)
- **ORM**: Spring Data JPA (Hibernate)
- **Authentication**: Spring Security + JWT
- **Real-time Communication**: WebSocket (STOMP)
- **Cloud Storage**: AWS S3
- **Documentation**: Swagger (SpringDoc OpenAPI)
- **Other Libraries**: Lombok, Validation

---

## Prerequisites

시스템에 다음 소프트웨어가 설치되어 있어야 합니다:

- **Java 17** 이상
- **Gradle** (또는 프로젝트에 포함된 Gradle Wrapper 사용)
- **MySQL** 데이터베이스 (로컬 또는 클라우드)

---

## Database Setup

### 1. MySQL 데이터베이스 생성

로컬 MySQL 서버에서 데이터베이스를 생성합니다:

```sql
CREATE DATABASE letstudynow_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. 환경 변수 설정

프로젝트 실행에 필요한 환경 변수를 설정합니다:

```bash
DB_PASSWORD=your_database_password
JWT_SECRET_KEY=your_jwt_secret_key_at_least_256bits
S3_ACCESS_KEY=your_aws_s3_access_key
S3_SECRET_KEY=your_aws_s3_secret_key
S3_BUCKET=your_s3_bucket_name
```

**IntelliJ IDEA에서 설정:**
- Run > Edit Configurations... > Environment variables에 위 변수들을 추가

---

## Install Dependencies

Gradle을 사용하여 의존성을 설치합니다:

```sh
./gradlew build
```

---

## Run Application

### 개발 서버 실행

```sh
./gradlew bootRun
```

또는 IDE(IntelliJ IDEA, Eclipse 등)에서:

1. `LetsStudyNowRgApplication.java` 파일 열기
2. `main` 메서드 실행

서버가 정상적으로 시작되면 **Swagger UI**에서 API 문서를 확인할 수 있습니다:

**Swagger UI**: http://localhost:8080/swagger-ui/index.html

---

## Build for Production

프로덕션 빌드를 생성합니다:

```sh
./gradlew clean build
```

빌드된 JAR 파일은 `build/libs/` 디렉토리에 생성됩니다.

### JAR 파일 실행

```sh
java -jar build/libs/LetsStudyNow-rg-0.0.1-SNAPSHOT.jar
```

---

## Docker Support

### Docker 이미지 빌드

```sh
docker build -t letsstudynow-backend .
```

### Docker 컨테이너 실행

```sh
docker run -p 8080:8080 \
  -e DB_PASSWORD=your_password \
  -e JWT_SECRET_KEY=your_secret \
  -e S3_ACCESS_KEY=your_access_key \
  -e S3_SECRET_KEY=your_secret_key \
  -e S3_BUCKET=your_bucket \
  letsstudynow-backend
```

---

## Project Structure

```
.
├── .github/                         # GitHub 설정 파일
│   ├── ISSUE_TEMPLATE/
│   │   └── template.md
│   ├── workflows/
│   │   ├── auto-label.yml
│   │   ├── pr-comment.yml
│   │   └── pr-merged.yml
│   ├── auto-assign.yml
│   └── PULL_REQUEST_TEMPLATE.md
├── gradle/                          # Gradle Wrapper 파일
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/team/LetsStudyNow_rg/
│   │   │       ├── domain/                 # 도메인별 비즈니스 로직
│   │   │       │   ├── chat/              # 채팅 기능
│   │   │       │   │   ├── controller/
│   │   │       │   │   │   └── ChatController.java
│   │   │       │   │   ├── dto/
│   │   │       │   │   │   ├── ChatMessageRequest.java
│   │   │       │   │   │   └── ChatMessageResponse.java
│   │   │       │   │   ├── entity/
│   │   │       │   │   │   └── ChatMessage.java
│   │   │       │   │   ├── enums/
│   │   │       │   │   │   ├── ChatRoomType.java
│   │   │       │   │   │   └── MessageType.java
│   │   │       │   │   ├── repository/
│   │   │       │   │   │   └── ChatRepository.java
│   │   │       │   │   └── service/
│   │   │       │   │       └── ChatService.java
│   │   │       │   ├── checklist/         # 체크리스트 기능
│   │   │       │   │   ├── controller/
│   │   │       │   │   │   └── ChecklistController.java
│   │   │       │   │   ├── dto/
│   │   │       │   │   │   ├── request/
│   │   │       │   │   │   │   ├── ChecklistCreateDto.java
│   │   │       │   │   │   │   └── ChecklistUpdateDto.java
│   │   │       │   │   │   └── response/
│   │   │       │   │   │       └── ChecklistResponseDto.java
│   │   │       │   │   ├── entity/
│   │   │       │   │   │   └── Checklist.java
│   │   │       │   │   ├── exception/
│   │   │       │   │   │   ├── ChecklistExceptionHandler.java
│   │   │       │   │   │   └── ChecklistNotFoundException.java
│   │   │       │   │   ├── repository/
│   │   │       │   │   │   └── ChecklistRepository.java
│   │   │       │   │   └── service/
│   │   │       │   │       └── ChecklistService.java
│   │   │       │   ├── groupstudy/        # 그룹 스터디 기능
│   │   │       │   │   ├── controller/
│   │   │       │   │   │   ├── GroupController.java
│   │   │       │   │   │   ├── GroupMemberController.java
│   │   │       │   │   │   └── StudyRoomController.java
│   │   │       │   │   ├── domain/
│   │   │       │   │   │   ├── Group.java
│   │   │       │   │   │   ├── GroupMember.java
│   │   │       │   │   │   ├── StudyRoom.java
│   │   │       │   │   │   └── StudyRoomParticipant.java
│   │   │       │   │   ├── dto/
│   │   │       │   │   │   ├── AddGroupMemberRequest.java
│   │   │       │   │   │   ├── CreateGroupRequest.java
│   │   │       │   │   │   ├── CreateStudyRoomRequest.java
│   │   │       │   │   │   ├── GroupMemberResponse.java
│   │   │       │   │   │   ├── GroupResponse.java
│   │   │       │   │   │   ├── StudyRoomParticipantResponse.java
│   │   │       │   │   │   └── StudyRoomResponse.java
│   │   │       │   │   ├── repository/
│   │   │       │   │   │   ├── GroupMemberRepository.java
│   │   │       │   │   │   ├── GroupRepository.java
│   │   │       │   │   │   ├── StudyRoomParticipantRepository.java
│   │   │       │   │   │   └── StudyRoomRepository.java
│   │   │       │   │   ├── scheduler/
│   │   │       │   │   │   └── StudyRoomCleanupScheduler.java
│   │   │       │   │   └── service/
│   │   │       │   │       ├── GroupMemberService.java
│   │   │       │   │       ├── GroupService.java
│   │   │       │   │       └── StudyRoomService.java
│   │   │       │   ├── member/            # 회원 관리
│   │   │       │   │   ├── controller/
│   │   │       │   │   │   └── MemberController.java
│   │   │       │   │   ├── dto/
│   │   │       │   │   │   ├── request/
│   │   │       │   │   │   │   ├── AccountDeleteDto.java
│   │   │       │   │   │   │   ├── LoginDto.java
│   │   │       │   │   │   │   ├── PasswordChangeDto.java
│   │   │       │   │   │   │   ├── ProfileUpdateDto.java
│   │   │       │   │   │   │   └── RegisterDto.java
│   │   │       │   │   │   └── response/
│   │   │       │   │   │       └── ProfileDto.java
│   │   │       │   │   ├── entity/
│   │   │       │   │   │   └── Member.java
│   │   │       │   │   ├── enums/
│   │   │       │   │   │   └── Role.java
│   │   │       │   │   ├── exception/
│   │   │       │   │   │   ├── DuplicateEmailException.java
│   │   │       │   │   │   ├── DuplicateUsernameException.java
│   │   │       │   │   │   ├── MemberExceptionHandler.java
│   │   │       │   │   │   ├── MemberNotFoundException.java
│   │   │       │   │   │   └── PasswordMismatchException.java
│   │   │       │   │   ├── repository/
│   │   │       │   │   │   └── MemberRepository.java
│   │   │       │   │   └── service/
│   │   │       │   │       ├── MemberService.java
│   │   │       │   │       └── MemberUpdateService.java
│   │   │       │   ├── openstudy/         # 오픈 스터디 기능
│   │   │       │   │   ├── dto/
│   │   │       │   │   │   ├── OpenStudyRoomCreateDto.java
│   │   │       │   │   │   ├── OpenStudyRoomListDto.java
│   │   │       │   │   │   ├── PageResponseDto.java
│   │   │       │   │   │   ├── ParticipantResponseDto.java
│   │   │       │   │   │   └── RoomJoinResultDto.java
│   │   │       │   │   ├── exception/
│   │   │       │   │   │   ├── AlreadyInRoomException.java
│   │   │       │   │   │   ├── OpenStudyExceptionHandler.java
│   │   │       │   │   │   ├── RoomDeletingException.java
│   │   │       │   │   │   ├── RoomFullException.java
│   │   │       │   │   │   └── RoomNotFoundException.java
│   │   │       │   │   ├── scheduler/
│   │   │       │   │   │   └── RoomCleanupScheduler.java
│   │   │       │   │   ├── service/
│   │   │       │   │   │   └── ParticipantService.java
│   │   │       │   │   ├── OpenStudyRoom.java
│   │   │       │   │   ├── OpenStudyRoomController.java
│   │   │       │   │   ├── OpenStudyRoomRepository.java
│   │   │       │   │   ├── OpenStudyRoomService.java
│   │   │       │   │   ├── RoomParticipant.java
│   │   │       │   │   ├── RoomParticipantRepository.java
│   │   │       │   │   ├── RoomStatus.java
│   │   │       │   │   ├── StudyField.java
│   │   │       │   │   └── StudyFieldConverter.java
│   │   │       │   ├── studyroom/         # 스터디룸 기능
│   │   │       │   │   ├── controller/
│   │   │       │   │   │   └── StudySessionController.java
│   │   │       │   │   ├── dto/
│   │   │       │   │   │   ├── LevelInfoDto.java
│   │   │       │   │   │   ├── SessionEndResultDto.java
│   │   │       │   │   │   ├── SessionResponseDto.java
│   │   │       │   │   │   └── SessionStartRequestDto.java
│   │   │       │   │   ├── entity/
│   │   │       │   │   │   └── StudySession.java
│   │   │       │   │   ├── exception/
│   │   │       │   │   │   ├── SessionNotFoundException.java
│   │   │       │   │   │   └── StudyRoomExceptionHandler.java
│   │   │       │   │   ├── repository/
│   │   │       │   │   │   └── StudySessionRepository.java
│   │   │       │   │   └── service/
│   │   │       │   │       ├── LevelUpService.java
│   │   │       │   │       └── StudySessionService.java
│   │   │       │   └── timer/             # 타이머 기능
│   │   │       │       ├── controller/
│   │   │       │       │   └── PersonalTimerController.java
│   │   │       │       ├── dto/
│   │   │       │       │   ├── request/
│   │   │       │       │   │   └── PomodoroSettingRequest.java
│   │   │       │       │   └── response/
│   │   │       │       │       ├── PomodoroSettingResponse.java
│   │   │       │       │       ├── StudyTimeResponse.java
│   │   │       │       │       └── TimerStatusResponse.java
│   │   │       │       ├── entity/
│   │   │       │       │   ├── PersonalTimer.java
│   │   │       │       │   ├── PomodoroSetting.java
│   │   │       │       │   ├── StudyHistory.java
│   │   │       │       │   ├── TimerMode.java
│   │   │       │       │   └── TimerStatus.java
│   │   │       │       ├── repository/
│   │   │       │       │   ├── PersonalTimerRepository.java
│   │   │       │       │   ├── PomodoroSettingRepository.java
│   │   │       │       │   └── StudyHistoryRepository.java
│   │   │       │       └── service/
│   │   │       │           ├── PersonalTimerService.java
│   │   │       │           └── PomodoroSettingService.java
│   │   │       ├── global/                # 전역 설정 및 공통 기능
│   │   │       │   ├── auth/             # 사용자 인증
│   │   │       │   │   ├── CustomUser.java
│   │   │       │   │   └── MyUserDetailsService.java
│   │   │       │   ├── config/           # 설정 클래스
│   │   │       │   │   ├── SecurityConfig.java
│   │   │       │   │   ├── StompHandler.java
│   │   │       │   │   ├── WebConfig.java
│   │   │       │   │   └── WebSocketConfig.java
│   │   │       │   ├── exception/        # 예외 처리
│   │   │       │   │   ├── GlobalExceptionHandler.java
│   │   │       │   │   └── S3Exception.java
│   │   │       │   ├── jwt/              # JWT 인증
│   │   │       │   │   ├── JwtFilter.java
│   │   │       │   │   └── JwtUtil.java
│   │   │       │   └── s3/               # AWS S3 연동
│   │   │       │       └── S3Service.java
│   │   │       └── LetsStudyNowRgApplication.java  # 메인 애플리케이션
│   │   └── resources/
│   │       ├── application.properties    # 애플리케이션 설정
│   │       └── static/                   # 정적 리소스
│   │           ├── chat-test.html
│   │           └── index.html
│   └── test/                             # 테스트 코드
│       └── java/
│           └── com/team/LetsStudyNow_rg/
│               └── LetsStudyNowRgApplicationTests.java
├── .gitignore                            # Git 무시 파일 설정
├── build.gradle                          # Gradle 빌드 설정
├── Dockerfile                            # Docker 이미지 빌드 파일
├── gradlew                               # Gradle Wrapper (Unix)
├── gradlew.bat                           # Gradle Wrapper (Windows)
├── HELP.md                               # 추가 도움말
├── README.md                             # 프로젝트 문서
└── settings.gradle                       # Gradle 프로젝트 설정
```

---

## API Documentation

서버 실행 후 Swagger UI를 통해 API 문서를 확인할 수 있습니다:

**Swagger UI**: http://localhost:8080/swagger-ui/index.html
