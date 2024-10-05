async function test(){

    // 아래는 시도했던 코드

    // const session_value = sessionStorage.getItem('id')
    //
    // alert("session_value: " + session_value)
    // console.log("session_value: " + session_value)
    //
    // return session_value


    // ---------------------------------------------------------------------------------
    // mainFrom에 있는 코드 그냥 옮겨둔것 사용하지 않는중인 코드
    // html에서 script 불러와도 실행이 안돼 html 자체에 적어서 사용했음..
    fetch('/session')
        .then(response => response.json())
        .then(SessionDto => {
            alert(SessionDto.user.user_id); // 서버에서 전달받은 username 출력
        });

}

async function getSession(){
    let response = await fetch('/session');
    let json = await response.json();
    return json.user.user_id;
}