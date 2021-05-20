# [소검] 이슈 지정 및 처리 방법

> 작성자: 전도현(IMRaccoon)

<br />

### Overview

- 현재 저희 팀 이슈는 Github Issue, Github Project, Github Milestone으로 운영하고 있습니다.
- 실제로 사용하셔야 할 기능은 Github Issue 와 Github Project 입니다.
- 각 Issue들은 대괄호('[]')를 통해 구분 가능합니다.
  - SR: Spec Review
  - CP: Category Partition Testing (System Testing)
  - BF: Brute Force Testing (System Testing)

<br />

### How To use Github Project

- Github Project는 총 2개로 분리되어 있습니다.

  - System Testing: 실제 동작 테스트를 실패한 상황에 대한 Issue
  - Spec Review: 문서에 대한 리뷰

- 해당 Project를 열면 총 4개의 구역으로 분리되어 있습니다.

  - To do: 해결되지 않은 이슈
  - In progress: 진행 중인 이슈
  - Wait for review: 해결한 뒤에 해결됨을 소검팀에게 전달할 이슈
  - Done: 소검팀의 검수 이후, 해결된 이슈

- 각각의 구역에 대한 역할을 인지하시고, Issue를 하나씩 확인하시면 됩니다.

<br />

### How To use Github Issue

- Issue를 사용할 때에는 총 4가지의 기능을 사용합니다.
  - Assignees (좌측): 해당 이슈를 맡은, 또는 해결한 사람
  - Project (좌측): 각각의 Issue에 대한 Project가 지정되어 있는데 상황에 따라 To do -> In progress 등으로 상황에 맞게 수정합니다.
  - Comment (하단): 해당 이슈에 대해 의문 또는 질문이 있을 경우 이슈에 대해 질문사항을 남겨주시면 소검팀에서 피드백을 합니다. 소검팀에서 이슈에 대한 Comment를 모니터링 하고 있으며, 소검팀은 답변 이후 전체 방에서 해당 이슈에 대한 답변을 남겼음을 알립니다.
  - Close Issue (하단): 소검팀에서 해당 이슈를 모두 리뷰한 뒤에 하는 작업입니다. 객체지향팀에서는 이슈를 닫지 않도록 주의합니다.

#### Spec Review

- Numbering 규칙

  - SR 00XX: 전체적인 수정사항
  - SR 10XX: Stage 1000
  - SR 20XX: SRS
  - SR 30XX: Stage 2030

- 제목 규칙
  - 문서의 Index를 기반으로 작성하였습니다.

#### System Testing

- Numbering 규칙

  - CP 10XX: User 기반 테스트
  - CP 20XX: Manager 기반 테스트
  - BF 01XX: Start Order 기반 테스트
  - BF 02XX: Input Choice 기반 테스트
  - BF 03XX: Determine Prepayment 기반 테스트
  - BF 04XX: Serve Item 기반 테스트
  - BF 05XX: Input Precode 기반 테스트
  - BF 06XX: Enter Administrator mode 기반 테스트
  - BF 07XX: Add Itemlist 기반 테스트
  - BF 08XX: Remove Itemlist 기반 테스트
  - BF 09XX: Change Stock 기반 테스트
  - BF 10XX: Change Item Price 기반 테스트
  - BF 11XX: Check Sales History 기반 테스트

- 내용
  - System Testing의 경우 TestRail이라는 툴을 사용합니다.
  - 해당 툴의 주소는 각각 이슈에 작성되어 있습니다.
  - 따라서 주소를 통해 어떤 조건을 통해 테스트를 진행했는지 확인하시면 됩니다.
  - TestRail Account
    - ID: kusma@konkuk.ac.kr
    - PW: kusma
