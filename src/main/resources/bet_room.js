const bettingArea = document.getElementById('betting-area');
const joinButton = document.getElementById('join-button');
const bettingForm = document.getElementById('betting-form');
const betAmountInput = document.getElementById('bet-amount');
const betButton = document.getElementById('bet-button');
const betCompleteButton = document.getElementById('bet-complete-button');
const resultPanel = document.getElementById('result-panel');
const winButton = document.getElementById('win-button');
const loseButton = document.getElementById('lose-button');
const userCoinsDisplay = document.getElementById('user-coins');

let users = []; // 배팅한 유저 정보 저장
let totalBetAmount = 0; // 총 배팅 금액
let userCoins = 0; // 유저 코인 잔액

// 벡엔드 API에서 유저 코인 가져오는 함수 (예시)
function getUserCoins() {
  // 벡엔드 API 호출하여 유저 코인 정보 가져오기
  // ...
  // 예시: 벡엔드에서 코인 100개 가져온 경우
  userCoins = 100;
  userCoinsDisplay.textContent = userCoins;
}

// 참여 버튼 클릭 이벤트
joinButton.addEventListener('click', () => {
  joinButton.style.display = 'none';
  bettingForm.style.display = 'block';
});

// 배팅 버튼 클릭 이벤트
betButton.addEventListener('click', () => {
  const betAmount = parseInt(betAmountInput.value);

  // 벡엔드 API에서 배팅 처리 (예시)
  // ...

  // 유저 정보 업데이트 (기존에 배팅한 정보가 있는 경우 합산)
  const existingUser = users.find(user => user.name === '사용자'); // 기존 유저 찾기
  if (existingUser) {
    existingUser.betAmount += betAmount; // 기존 배팅 금액에 더하기
  } else {
    // 유저 정보 추가 (벡엔드에서 받아온 유저 정보 사용)
    const newUser = {
      icon: 'images/user.png', // 벡엔드에서 받아온 유저 아이콘
      name: '사용자', // 벡엔드에서 받아온 유저 이름
      betAmount: betAmount
    };
    users.push(newUser);
  }

  updateBettingArea();
  totalBetAmount += betAmount;
  userCoins -= betAmount;
  userCoinsDisplay.textContent = userCoins;

  // 배팅 폼 초기화
  betAmountInput.value = '';

  // 배팅 완료 버튼 보이기
  betCompleteButton.style.display = 'block';
});

// 배팅 완료 버튼 클릭 이벤트
betCompleteButton.addEventListener('click', () => {
  // 배팅 완료 처리 (벡엔드 API 호출)
  // ...

  betButton.style.display = 'none'; // 배팅하기 버튼 숨기기
  betCompleteButton.style.display = 'none'; // 배팅 완료 버튼 숨기기
  resultPanel.style.display = 'block'; // 승리/패배 버튼 보이기
  bettingForm.style.display = 'none'; // 배팅 폼 숨기기
});

// 배팅 영역 업데이트 함수
function updateBettingArea() {
  // 배팅 금액 기준으로 내림차순 정렬
  users.sort((a, b) => b.betAmount - a.betAmount);
  bettingArea.innerHTML = ''; // 기존 배팅 정보 삭제
  users.forEach(user => {
    const userBetElement = document.createElement('div');
    userBetElement.classList.add('user-bet');
    // 이미지, 이름, 배팅 금액을 수평으로 배치
    userBetElement.innerHTML = `
      <img src="${user.icon}" alt="${user.name} 아이콘">
      <span>${user.name}</span>
      <span>${user.betAmount} 코인</span>
    `;
    bettingArea.appendChild(userBetElement);
    // 총액 정보 추가 (이미지, 이름, 배팅 금액과 동일한 길이로 만들기 위해 userBetElement 아래에 추가)
    const totalCoinsSpan = document.createElement('span');
    totalCoinsSpan.textContent = `총액: ${userCoins} 코인`;
    bettingArea.appendChild(totalCoinsSpan);
  });
}

// 승리/패배 버튼 이벤트 처리
winButton.addEventListener('click', () => {
  // 승리 처리 (벡엔드 API 호출)
  // ...

  // 승리한 유저들에게 코인 배분 (벡엔드에서 처리)
  // ...

  // 결과 표시
  alert("승리! 코인이 지급되었습니다.");
  resetGame();
});

loseButton.addEventListener('click', () => {
  // 패배 처리 (벡엔드 API 호출)
  // ...

  // 결과 표시
  alert("패배! 코인이 잃었습니다.");
  resetGame();
});

// 게임 초기화 함수
function resetGame() {
  users = [];
  totalBetAmount = 0;
  updateBettingArea();
  resultPanel.style.display = 'none';
  joinButton.style.display = 'block';
  bettingForm.style.display = 'none';
  getUserCoins(); // 벡엔드에서 유저 코인 정보 갱신
}

// 초기화: 유저 코인 정보 가져오기
getUserCoins();