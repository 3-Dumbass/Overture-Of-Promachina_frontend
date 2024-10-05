const createRoomForm = document.getElementById("create-room-form");
const roomList = document.getElementById("room-list");
const pagination = document.getElementById("pagination"); // 페이징 div

let currentPage = 1; // 현재 페이지
let roomsPerPage = 2; // 페이지당 방 개수

async function createRoom(roomName){
    const data = {
        "roomName": roomName,
        "gameMode": "WINNER_TAKE_ALL" // 요청에 포함할 데이터
    };

    const url=`${API_URL}/api/v1/game-room/create`
  const response = await fetch(url, {
    method: 'POST', // HTTP 메서드
    headers: {
      'Accept': '*/*', // 응답 타입
      'Content-Type': 'application/json' // 요청 본문의 데이터 타입
    },
    body: JSON.stringify(data) // 객체를 JSON 문자열로 변환
  });

  if (!response.ok) {
    throw new Error(`HTTP error! status: ${response.status}`);
  }

  const result = await response.json(); // JSON 형식으로 응답 받기
  return result;
}

async function getRoomList(page,size){
  try {
    const response = await fetch(`${API_URL}/api/v1/game-room-list/list?page=${page}&size=${size}`);
    const result = await response.json(); // JSON 응답을 파싱

    // data 배열과 pagination 정보
    const gameRooms = result.data;
    const pagination = result.pagination;

    // pagination 정보 로그
    console.log("Pagination Info: ", pagination);

    const res={
      rooms:gameRooms.map(room=>{
        return makeRoomObject(room.gameRoomId, room.gameRoomTitle);
      }),
      totalPage: pagination.totalPage,
    }

    return  res
  } catch (error) {
    console.error('Error fetching game rooms:', error);
  }
}

function makeRoomObject(id, roomName){
  return {
    id: id,
    name: roomName,
    description: "방에 대한 설명입니다." // 설명 추가
  };
}

createRoomForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const roomName = document.getElementById("room-name").value;

    createRoom(roomName).then(i => {
            renderRoomList(); // 방 목록 렌더링
        }
    );
    createRoomForm.reset(); // 폼 초기화
});

async function renderRoomList() {
  roomList.innerHTML = ""; // 기존 방 목록 삭제
  pagination.innerHTML = ""; // 기존 페이징 버튼 삭제
  const roomInfo = await getRoomList(currentPage - 1, roomsPerPage);
  const displayedRooms = roomInfo.rooms;
  console.log(displayedRooms)

  displayedRooms.forEach(room => {
    const roomBox = document.createElement("div");
    roomBox.classList.add("room-box");

    const info = document.createElement("div");
    info.classList.add("info");
    info.innerHTML = `
      <h3>${room.name}</h3>
      <p>${room.description}</p>
    `;

    const joinButton = document.createElement("button");
    joinButton.textContent = "참가하기";
    joinButton.addEventListener("click", () => {
      // 방 입장 처리 (예: 페이지 이동, 방 정보 전달)
      console.log(`${room.name} 방에 입장합니다!`);
    });

    roomBox.appendChild(info);
    roomBox.appendChild(joinButton); // 버튼을 info 아래에 추가

    // 방 ID 표시
    const roomIdSpan = document.createElement("span");
    roomIdSpan.classList.add("room-id");
    roomIdSpan.textContent = `#${room.id}`;
    roomBox.appendChild(roomIdSpan); // roomBox의 가장 마지막에 추가하여 우측 상단에 배치

    roomList.appendChild(roomBox);
  });

  // 페이징 버튼 생성
  const totalPages = roomInfo.totalPage;
  for (let i = 1; i <= totalPages; i++) {
    const pageButton = document.createElement("button");
    pageButton.textContent = i;
    pageButton.addEventListener("click", () => {
      currentPage = i;
      renderRoomList();
    });
    pagination.appendChild(pageButton);
  }
}

window.onload= function (){
  renderRoomList();
}