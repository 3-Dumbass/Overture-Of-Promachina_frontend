const signupForm = document.getElementById("signup-form");

signupForm.addEventListener("submit", (event) => {
  event.preventDefault(); // 기본 submit 동작 방지

  const loginId = document.getElementById("loginId").value;
  const nickname = document.getElementById("nickname").value;
  const password = document.getElementById("password").value;
  const passwordConfirm = document.getElementById("password-confirm").value;

  // 비밀번호 확인
  if (password !== passwordConfirm) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }

  // 실제 회원가입 처리 로직 (서버와 통신하여 사용자 정보 저장)
  // ...

  // 회원가입 성공 시
  if (null/* 회원가입 성공 조건 */) {
    // 회원가입 성공 후 처리 (예: 로그인 페이지로 이동)
    // ...
  } else {
    // 회원가입 실패 시 처리 (예: 오류 메시지 표시)
    // ...
  }
});