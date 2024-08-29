// const propsEx1 = props =>{
//     return (
//         <div>
//             <div>현재 먹고싶은 음식은 {props.food}입니다.</div>
//             <div>내일 먹고 싶은 음식은 {props.children}입니다.</div>
//             <div>{props.children}</div>
//         </div>
//     )
// // }

// const propsEx1 = props =>{
//     const {food, children} = props;
//     return (
//         <div>
//             <div>현재 먹고싶은 음식은 {food}입니다.</div>
//             <div>내일 먹고 싶은 음식은 {children}입니다.</div>
//             <div>{children}</div>
//         </div>
//     )
// }

const propsEx1 = ({food, children}) =>{
    
    return (
        <div>
            <div>현재 먹고싶은 음식은 {food}입니다.</div>
            <div>내일 먹고 싶은 음식은 {children}입니다.</div>
            <div>{children}</div>
        </div>
    )
}

propsEx1.defaultProps = {food: '바나나'}

export default propsEx1;