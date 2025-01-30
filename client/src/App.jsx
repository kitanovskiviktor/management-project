import { useState, useRef } from 'react'
import axios from "axios";

function App() {

    const usernameRef = useRef();
    const passwordRef = useRef();
    const usernameLoginRef = useRef();
    const passwordLoginRef = useRef();

    const registerUser = () => {
        const body = {
            username: usernameRef.current.value,
            password: passwordRef.current.value
        }
        axios.post("http://localhost:8080/api/user/register", body)
            .then((response) => console.log("Register Success"))
            .catch((error) => console.log('here', error.response.data));
    }

    const loginUser = () => {
        const body = {
            username: usernameLoginRef.current.value,
            password: passwordLoginRef.current.value
        }
        axios.post("http://localhost:8080/api/user/login", body)
            .then((response) => console.log(response))
            .catch((error) => console.log('here', error.response.data));
    }


  return (
    <>
      <div>
            <input ref={usernameRef} />
            <input ref={passwordRef} />
            <button onClick={registerUser}>Register</button>
      </div>

        <div>
            <input ref={usernameLoginRef} />
            <input ref={passwordLoginRef} />
            <button onClick={loginUser}>Login</button>
        </div>
    </>
  )
}

export default App
