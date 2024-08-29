import { Component } from "react";

class propsEx2 extends Component{
    render(){
        const {food, children} = this.props;
        return (
            <div>
                <div>배고파요 지금 {food}가(이) 먹고싶어요</div>
                <div>지금은요 {children}가(이) 먹고싶아요</div>
            </div>
        )
    }
}

propsEx2.defaultProps = {food :'삼겹살'}


export default propsEx2;