let isLoggedIn = false; // 로그인 상태 초기값은 false
let username = ""; // 닉네임 저장 변수
let coins = 0; // 잔여 코인 수 저장 변수

const sites = [
  {
    image: "images/site1.jpg",
    title: "사이트 1",
    description: "사이트 1에 대한 간단한 설명입니다.",
    link:"/betting-room"
  },
  {
    image: "images/site2.jpg",
    title: "사이트 2",
    description: "사이트 2에 대한 간단한 설명입니다."
  },
  // 여기에 사이트 정보를 더 추가합니다.
];

const container = document.querySelector(".container");

sites.forEach(site => {
  const siteBlock = document.createElement("div");
  siteBlock.classList.add("site-block");
  if(site.link){
    siteBlock.onclick = (event) => {
      location.href = site.link;
    };
    siteBlock.style = "cursor: pointer";
  }

  const image = document.createElement("img");
  image.src = site.image;
  image.alt = site.title;
  siteBlock.appendChild(image);

  const title = document.createElement("h3");
  title.textContent = site.title;
  siteBlock.appendChild(title);

  const description = document.createElement("p");
  description.textContent = site.description;
  siteBlock.appendChild(description);

  container.appendChild(siteBlock);
});

// 로그인 성공 시 실행되는 함수 예시
function handleLoginSuccess(user) {
  isLoggedIn = true;
  username = user.username;
  coins = user.coins;

  // user-info 요소를 가져옵니다.
  const userInfo = document.querySelector(".user-info");

  // 로그인/회원가입 버튼을 닉네임과 잔여 코인 정보로 바꿉니다.
  userInfo.innerHTML = `
    <li>
      <span>
        ${username}
      </span>
    </li>
    <li>
      <span>
        잔여 코인: ${coins}
      </span>
    </li>
      <span>
        잔여 칩: ${chip}
      </span>
    </li>
  `;
}

// 로그아웃 시 실행되는 함수 예시
function handleLogout() {
  isLoggedIn = false;
  username = "";
  coins = 0;

  // user-info 요소를 가져옵니다.
  const userInfo = document.querySelector(".user-info");

  // 로그인/회원가입 버튼으로 돌려놓습니다.
  userInfo.innerHTML = `
    <li><a href="#" class="button">로그인</a></li>
    <li><a href="#" class="button">회원가입</a></li>
  `;
}