function test(){
    const session_value = sessionStorage.getItem('id')

    alert("session_value: " + session_value)
    console.log("session_value: " + session_value)

    return session_value
}