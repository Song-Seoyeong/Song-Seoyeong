// textField에 값을 입력하고 값 전달 버튼을 누르면 h1 태그에 값이 들어가게 하고
// 값 삭제 버튼을 누르면 h1 태그에 값이 비어있게하기

import { useState } from "react";

const Prac_Input = () =>{
    const [text, setText] = useState();
    const [value, setValue] = useState();

    const setting = e =>{
        setValue(e.target.value)
    }

    const insertText = () =>{
        
        setText(value)
    }

    const deleteText = () =>{
        setText()
    }

    return(
        <div>
            <h1>결과</h1>
            <h1>{text}</h1>
            <input onChange={setting}/>
            <br/><br/>
            <button onClick={insertText}>값 전달</button>&nbsp;|&nbsp;
            <button onClick={deleteText}>값 삭제</button>
        </div>
    )
}

export default Prac_Input;