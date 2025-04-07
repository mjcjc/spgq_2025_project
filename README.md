# spgq_2025_project

 한국공학대학교 2025년 스마트 폰 게임 프로그래밍(01) 강의 프로젝트
 
# 제목: AniRun(동물 달리기)

# 컨셉

AniRun은 들판위에서 동물이 살기 위해 음식을 먹으려 달리는 터치 기반 러닝 액션 게임입니다.
기존과 유사한 쿠키런을 모티브로 하여, 단순히 점프 슬라이드로만 게임을 하는 것이 아니라 동물마다 고유 스킬을 추가를 하여 콘텐츠를 증가할 예정입니다.

# 핵심 메카닉

1. 점프
  점프키를 눌러 장애물과 먹이를 먹을 수 있습니다.
2.슬라이드
 슬라이드는 쿠키런과 동일하게 홀딩을 할 시 엎드려서 달리게 되고 장애물을 피하며 먹이를 먹을 수 있습니다.
3. 스킬
   횟수를 제한하여 장애물을 파괴 혹은 생명력을 늘리게 해줍니다.

# 개발
1. 시작화면
   게임을 시작할 때 메인화면
2. 로비화면
   캐릭터와 게임시작하는 버튼화면
3. 게임화면
   플레이어가 게임을 주로 하는 화면
4.체력
  인게임에서 플레이어가 한 판당 얼마나 달릴 수 있는지에 대한 것
5.스킬
 인게임에서 플레이어가 총 2번을 사용하여 장애물 혹은 체력을 일시적으로 늘리게 해주는 것
6.장애물
 일정한 시간 혹은 일정 거리를 지나갈 시 x,y축내에 플레이어가 피해야 하는 것
7.먹이
 플레이어가 먹으면 먹을수록 점수 시스템을 부여하여 점점 점수가 늘어나고 체력을 아주 조금 늘리게 해주는 것.

# 게임 흐름도



![게임진짜 게임시작](https://github.com/user-attachments/assets/75ddb237-6a71-466a-9dc5-a8667933f408)
![게임시작](https://github.com/user-attachments/assets/7f96d883-9088-4de4-9673-904383ab3dbf)
![시작했을때](https://github.com/user-attachments/assets/ef5974dc-c47a-491e-9da9-2d43cf91f4f9)

# 개발 일정


|주차|날짜(예상)|내용|
|------|---|---|
|1주차|4월8일주|기획및 문서화 작업 확정|
|2주차|4월15주|각 Scene에 대한 설계|
|3주차|4월22주|Scene에 대한 필요 요소 구현|
|4주차|4월29주|체력 관련 로직 구현|
|5주차|5월6주|캐릭별 스킬, 점프 슬라이드 로직 구현|
|6주차|5월13주|장애물관련 오브젝트 구현|
|7주차|5월20주|먹이 및 달리기 관련 스코어 구현|
|8주차|5월27주|버그 테스트및 수정|
|9주차|6월3주|발표 동영상 제작 및 제출|

