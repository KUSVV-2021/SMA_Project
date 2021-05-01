# [소검] CTIP 개발 환경

> 작성자: 전도현(IMRaccoon)

<br />

## 개발 환경

- IDE: Jetbrains 사의 IntelliJ
- JDK: OpenJDK 11.0.11 (Java SE 11(LTS))
  - [Download](https://www.oracle.com/java/technologies/javase-downloads.html)
- Gradle 6.8
  - [Download](https://gradle.org/releases/#6.8)
  - 'binary-only' 로 사용해도 무관합니다.

<br />

## 설치 방법

### Java

#### 1. 다운로드 받습니다.

- 버전 11.0.11 임을 확인합니다.

#### 2. 환경변수를 변경합니다.

- 새로 Java 를 받은 경우 설치와 함께 자동으로 세팅되며 3번으로 이동합니다.
- 기존에 설치된 버전이 다른 경우 아래의 순서로 작업을 수행합니다.

```
A. 설치된 Java의 디렉토리를 확인합니다.
(C:\Program Files\Java\jdk11.0.11)
B. Win + Q키를 동시에 누르고 '시스템 환경 변수 편집' 검색
C. 시스템 속성 창의 우측 하단에 '환경 변수' 클릭
D. JAVA_HOME을 A단계에서 확인한 경로로 바꾸어 줍니다.
E. JAVA_PATH를 C:\ProgramData\Oracle\Java\javapath 로 바꾸어줍니다. (해당 경로에 바로가기가 있는 지 확인)
```

#### 3. CMD 에서 `java --version` 입력으로 설치를 확인합니다.

<br />

### Gradle

#### 1. 다운로드 받습니다.

- 버전 6.8을 확인합니다.
- binary-only 의 경우, sample과 docs가 없는 버전입니다.

#### 2. 환경변수를 설정합니다.

```
A. Win + Q키를 동시에 누르고 '시스템 환경 변수 편집' 검색
B. 시스템 속성 창의 우측 하단에 '환경 변수' 클릭
C. 아래의 '시스템 변수'에서 '새로 만들기' 클릭
D. 변수 이름: GRADLE_HOME, 변수 값: 2번의 폴더 경로 입력 후 저장
E. '시스템 변수'에서 'Path' 변수를 누르고 '편집' 클릭
F. 우측 상단의 새로 만들기 후 %GRADLE_HOME%\bin 입력
G. 확인 누르고 나와서 한번 더 확인 누르기
```

#### 3. CMD 에서 `gradle -v ` 입력으로 설치를 확인합니다..

<br />

## 개발하시면서 참고하실 사항

#### 1. 'main' 브랜치에 자잘한 push 을 넣지 않도록 주의해 해주세요

- 해당 브랜치에서 생기는 모든 push 행위는 CI로 넘어가 코드 분석을 하게 됩니다.  
- push 를 하셔도 무관하시나 최소 기능 단위의 완성의 경우에만 하는 것을 요청드립니다.
- 후에 기능에 대한 수정과 같은 빠른 수정을 요하는 작업의 경우는 무관합니다.
- 팀 자체적으로 branch 생성을 하거나, fork를 통해 작업하시는 것을 추천드립니다.

#### 2. 협엽을 요하는 상황에서 build 명령어를 먼저 실행해주세요

- push 하시기 전에 `gradle build` 명령어를 통해 Unit Test 및 빌드에 문제가 없는지 확인해주세요.


#### 3. 진행하시면서 특정 문제가 발생하는 경우, 빠르게 말씀해주세요

- Discord 를 통해 연락주시면 빠르게 대응하겠습니다.