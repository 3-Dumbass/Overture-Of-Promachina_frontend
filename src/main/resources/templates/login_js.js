// 로그인 폼 요소를 가져옵니다.
const loginForm = document.getElementById("login-form");
// 로그인 폼 아래에 회원가입 링크를 추가합니다.
const signupLink = document.createElement("div");
signupLink.classList.add("signup-link");
signupLink.innerHTML = "<a href='/signup'>회원가입</a>"; // signup 페이지로 이동하는 링크
loginForm.parentNode.insertBefore(signupLink, loginForm.nextSibling); // 로그인 폼 아래에 추가

loginForm.addEventListener("submit", (event) => {
  event.preventDefault(); // 기본 submit 동작 방지

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  // 실제 로그인 검증 로직 (서버와 통신하여 사용자 정보 확인)
  // ...

  // 로그인 성공 시
  if (/* 로그인 성공 조건 */a) {
    // 로그인 성공 후 처리 (예: 사용자 정보 업데이트, 페이지 이동)
    // ...
  } else {
    // 로그인 실패 시 처리 (예: 오류 메시지 표시)
    // ...
  }
});

