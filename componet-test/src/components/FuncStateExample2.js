import {useState} from 'react'

const FuncStateExample2 = () =>{
    const [name, setName] = useState();
    const [job, setJob] = useState();

    const changeName = e =>{
        setName(e.target.value)
    }

    const changeJob = e =>{
        setJob(e.target.value)
    }   

    return(
        <div>
            <input type='text' onBlur={changeName}/>
            <br/>
            <input onChange={changeJob}/>
            <br/>
            <span>이름 : {name}</span><br/>
            <span>직업 : {job}</span>
        </div>
    )
}

export default FuncStateExample2;