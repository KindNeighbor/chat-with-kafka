# chat-with-kafka

## to - be
1. 채팅방이 화면에 같이 나오는 경우에는 따로 채팅 입장 api를 만들어야 하나? (퇴장 하는 것도 마찬가지.)
2. 아니면 입장시에 방이 없으면 만들어줘야 하니까 만들어야 하나 싶기도..? (생성하는 api에다가 기존 방이 없으면 만들고 있으면 에러 나게 하면 될지도?)
3. WebsocketConfig에서 withSocketJS 코드가 있는 경우 Apic에서 작동이 안되는데, React에서는 어떻게 되는 건지 아직 모르겠음. 확인 필요
4. 토큰이 들어가는 경우 작동 확인(메시지 입력시 닉네임도 적게 되어있는데, 토큰 활용 가능 시 닉네임도 자동으로 작성 가능)
5. docker-compose.yml에 image 버전 최신 걸로 할지 확인 (일단 되는 레퍼런스로 실행함)
6. 지금 구현한 건 싱글 zookeeper, kafka인데, 클러스터 구성을 할지 말지 고민

## 실행
1. docker desktop 실행
2. 인텔리제이 터미널에다가 docker-compose up 입력
3. 스프링 서버 실행

## 웹소켓 테스트

1. https://chrome.google.com/webstore/detail/apic-complete-api-solutio/ggnhohnkfcpcanfekomdkjffnfcjnjam?hl=ko 다운
2. 오른쪽 상단 아이콘 클릭
3. 

![웹소켓 test](https://user-images.githubusercontent.com/97837003/217046721-80f75965-edd3-4efb-90ce-d4a6a2f233bf.png)

일단 "보라색" 버튼 누르고,
- 빨간색 : 웹소켓 접속 url
- 노란색 : 메세지 받을 url (stomp 탭 눌러야됨)
- 초록색 : 메세지 전송하는 url

4. 메시지 하단에 requestBody 형식으로 작성
5. 작동 확인

![웹소켓 test - 2](https://user-images.githubusercontent.com/97837003/217045542-b01f1a77-aff1-4ed3-9260-11bb9c46fac8.png)
