// 한 숫자를 가지고 버튼 두개로 1씩 올리고 내리는 함수 컴포넌트 만들기
import { useState } from "react";

const InDecrease2 = () =>{
    const [num, setNum] = useState(0);
    return(
        <span>
            <button onClick={()=>{setNum(num - 1)}}>--</button>
            {num}
            <button onClick={()=>{setNum(num + 1)}}>++</button>
        </span>
    )
}

export default InDecrease2;