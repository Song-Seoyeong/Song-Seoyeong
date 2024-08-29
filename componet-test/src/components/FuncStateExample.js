import { useState } from "react";

// const FuncStateExample = () =>{
//     const [number1, setNumber1] = useState(0);
//     //   사용할 state, state를 수정할 수 있는 함수 만들어야함 >> 이걸 useState가 관리하게 됨
//     const [number2, setNumber2] = useState(0);
//     return(
//         <div>
//             <h1>{number1}</h1>
//             <button onClick={()=>{
//                 setNumber1(number1 + 1)
//             }}>Click me!</button>
//             <h1>{number2}</h1>
//             <button onClick={()=>{
//                 setNumber2(number2 - 2)
//             }}>Click me!</button>
//         </div>
//     )
// }

const FuncStateExample = () =>{
    const [number1, setNumber1] = useState(0);
    //   사용할 state, state를 수정할 수 있는 함수 만들어야함 >> 이걸 useState가 관리하게 됨
    const [number2, setNumber2] = useState(0);

    const numberSumOneEvent = () =>{
        setNumber1(number1 + 1)
    }

    const numberSubOneEvent = () =>{
        setNumber2(number2 - 2)
    }
    
    return(
        <div>
            <h1>{number1}</h1>
            <button onClick={()=>{
                numberSumOneEvent();
            }}>Click me!</button>
            <h1>{number2}</h1>
            <button onClick={()=>{
                numberSubOneEvent();
            }}>Click me!</button>
        </div>
    )
    
}


export default FuncStateExample;