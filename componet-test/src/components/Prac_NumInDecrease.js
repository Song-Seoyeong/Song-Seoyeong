// 한 숫자를 가지고 버튼 두개로 1씩 올리고 내리는 클래스 컴포넌트 만들기

import { Component } from "react";

class inDecrease extends Component{
    constructor(props){
        super(props);
        this.state = {number: 0}
    }

    render(){
        const {number} = this.state
        return(
            <span style={{fontWeight:'bold', fontSize:'30px'}}>
                <button onClick={()=>{
                    this.setState({number: number+1})
                }}>++</button>
                &nbsp;&nbsp;{number}&nbsp;&nbsp;
                <button onClick={()=>{
                    this.setState({number: number-1})
                }}>--</button>
            </span>
        )

    }
}

export default inDecrease;