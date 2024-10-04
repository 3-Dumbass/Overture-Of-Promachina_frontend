const createRoomForm = document.getElementById("create-room-form");
const roomList = document.getElementById("room-list");
const pagination = document.getElementById("pagination"); // 페이징 div

let rooms = []; // 방 목록 저장
let currentPage = 1; // 현재 페이지
let roomsPerPage = 2; // 페이지당 방 개수
let roomIdCounter = 1; // 방 ID 카운터

createRoomForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const roomName = document.getElementById("room-name").value;

  // 방 정보 객체 생성
  const newRoom = {
    id: roomIdCounter++, // 방 ID 추가
    name: roomName,
    description: "방에 대한 설명입니다." // 설명 추가
  };

  rooms.push(newRoom); // 방 목록에 추가
  renderRoomList(); // 방 목록 렌더링
  createRoomForm.reset(); // 폼 초기화
});

function renderRoomList() {
  roomList.innerHTML = ""; // 기존 방 목록 삭제
  pagination.innerHTML = ""; // 기존 페이징 버튼 삭제

  const startIndex = (currentPage - 1) * roomsPerPage;
  const endIndex = startIndex + roomsPerPage;
  const displayedRooms = rooms.slice(startIndex, endIndex);

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
  const totalPages = Math.ceil(rooms.length / roomsPerPage);
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