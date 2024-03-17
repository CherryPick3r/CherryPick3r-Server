# 광진구 음식점 추천 어플 '체리피커'
![KakaoTalk_Photo_2023-06-02-10-54-00 001 복사본](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/bf55ff4b-8202-4509-a281-a8ae9ef84177)

이제는 음식 추천도 재미있게! 체리피커

## 사용 기술

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white"> <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=openjdk&logoColor=white"> <br>
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white"> <br>
<img src="https://img.shields.io/badge/Github Action-181717?style=for-the-badge&logo=github&logoColor=white"> <br>
<img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white"> <br>

## Team

![스크린샷 2024-03-17 오후 7 22 57](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/a4ab0844-2266-4e43-ad85-ea2dab876fad) ![스크린샷 2024-03-17 오후 7 22 45](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/49b9e10c-ab5d-49f0-add3-7e3b7c1ea0c5)

  
## 배경

사람들은 먹는 것에 진심입니다. 

유튜브 컨텐츠 60%가 먹방과 음식과 관련된 컨텐츠이고, 인스타그램과 같은 소셜미디어에서 먹방, 맛집과 관련한 태그는 상위 1%에 도달합니다.

이에 저희는 연령층이 낮아질 수록 짧은 길이의 영상을 선호한다는 연구결과을 토대로, 짧은 게임을 통해서 음식점을 추천받고 원하는 식당을 찾아갈 수 있는 서비스를 설계하였습니다.

저희의 서비스는 초기 유저의 취향을 간단한 게임을 통해 설정한 후, 이에 맞는 식당을 게임의 형태로 유저에게 추천해줍니다. 

유저는 오른쪽으로 화면을 스와이프하여 좋아요를, 왼쪽으로 스와이프하여 싫어요를 할 수 있습니다.

이를 통해 마지막 추천된 음식점을 통해, 즐겨찾기 및 목적에 맞는 음식점을 확인할 수 있습니다.

또한 유저의 취향분석을 통해 음식점 선호 패턴을 확인할 수 있습니다.


## 서비스

![KakaoTalk_Photo_2023-06-02-10-54-00 007](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/8630181b-3579-4531-8360-da7dcf983b1d) 

![스크린샷 2024-03-17 오후 7 40 35](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/317c4e69-4626-454f-bf4e-9a9902656cfc) ![스크린샷 2024-03-17 오후 7 40 38](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/31c50867-d09a-43dd-a1cc-6f850d6ae3b0) 

![스크린샷 2024-03-17 오후 7 40 41](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/59449e5c-7b6f-41e4-a431-cd0fc63533b0) ![스크린샷 2024-03-17 오후 7 40 44](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/505d84e8-d71b-4dcc-955a-f30f11e8904b) ![스크린샷 2024-03-17 오후 7 40 50](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/bd465593-48c8-48db-85c1-96cb06d7e97e)


체리피커는 스와이프를 기반으로 유저의 취향을 점점 찾아서 음식점을 추천해주는 IOS 애플리케이션 서비스입니다.

유저는 단순히 화면에 등장하는 음식점을 느낌에 따라 왼쪽⬅️ 또는 오른쪽➡️으로 스와이프하면 마음에 쏙 드는 음식점을 추천받을 수 있습니다.

기존의 음식점을 찾는 수고로움에 게임을 접목해 유저에게 적합한 음식점을 찾아줍니다.

## 주요 기능 및 개발 사항

- Java spring boot을 이용한 api 개발
- 룰 베이스 학습 방식을 도입한 음식점 추천 알고리즘 도입 
- AWS 활용 자동배포 시스템 구축


### How to recommend “restaurant” based on “personal preference” ?

1. 유저의 취향을 기반으로 음식점을 게임형태로 추천해주는 시스템을 제안하였습니다.
2. 유저는 초기 취향 게임을 통해서 본인의 취향을 세팅하고 게임을 진행할 수 있으며, 별도의 목적에 맞는 식당을 ‘단체 모임’, ‘혼밥’, ‘카페 공부’, ‘술집’ 중에 선택하여 카테고리별 게임도 진행할 수 있습니다.
3. 유저는 ‘취향 분석’ 서비스를 통해서 본인의 취향의 상위 퍼센트를 확인할 수 있습니다.
4. ‘취향 분석’ 서비스에서는 추가적으로 ‘미니 인플루언서’, ‘카페인 뱀파이어’, ‘술고래’등 음식취향 분석을 확인할 수 있습니다.

## 추천 알고리즘에 대한 설명

### 유저의 선택에 따른 가게 추천 도출 로직

![image](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/c7569ae9-697b-4da1-9f66-832aeb555362)


### 유저의 취향 상위%(Top user preference) 로직
- 기존 태그 희소성 로직: 1 / {(해당 태그들을 가진 가게의 개수)/ 전체 가게 수} 
- 유저의 취향 태그의 희소성 로직: ∑(태그의 희소성 값) * (유저의 태그)
- 유저의 희소성 상위 비율 =.전체 유저 중 유저 희소성이 차지하는 비율

![image](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/e246c98f-a784-436b-aecc-9fc1de6be8d4)


### 취향 카테고리(preference Category) 기능

- 각 preference Category에 대한 기준 태그 값이 존재합니다.

- 유저의 취향 태그와 preference Category와의 오차 계산

- MSE = Mean Squared Error

![image](https://github.com/CherryPick3r/CherryPick3r-Server/assets/44383895/176c0f1e-c877-4d3a-8ac9-bab10df021cc)


