import {Component} from 'react';

class ClassStateExample extends Component{
    /*
        component 생명 주기 함수
            **render() : 화면에 코드를 구현하는 함수
            **constructor(props) : 처음 한 번만 호출하여 생성자 역할을 함
                                   컴포넌트 안에서 사용되는 state 변수를 선언하고 부모 객체에서 받은 props를 초기화할 때 사용한다
                                   매개변수에 props를 넣고, super(props)가 있어야 에러가 나지 않는다
            getDerivedStateFromProps() : render를 실행하기 직전에 실행
            componentDidMount() : render를 실행하고 나서 실행

    */

    constructor(props){
        super(props)
        this.state = {number1 : 0, number2 : 0}; // state 선언
    }

    // render(){
    //     const {number1, number2} = this.state;
    //     return(
    //         <div>
    //             <h1>{number1}</h1>
    //             <button onClick={()=>{
    //                 this.setState({number1: number1+1})
    //             }}>Click Me!</button>
    //             <h1>{number2}</h1>
    //             <button onClick={()=>{
    //                 this.setState({number2: number2-1})
    //             }}>Click Me!</button>
    //         </div>
    //     )
    // }

    render(){
        const {number1, number2} = this.state;
        const {btnName} = this.props;
        return(
            <div>
                <h1>{number1}</h1>
                <button onClick={this.numberSumOneEvent}>Click Me!</button>
                <h1>{number2}</h1>
                <button onClick={()=>{
                   this.numberSubOneEvent();
                }}>{btnName}</button>
            </div>
        )
    }

    numberSumOneEvent = () =>{
        this.setState({number1: this.state.number1+1})
    }

    numberSubOneEvent = (number2) =>{
        this.setState({number2: this.state.number2-100})
    }
}

export default ClassStateExample;