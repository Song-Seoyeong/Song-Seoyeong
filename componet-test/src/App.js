import Test from './components/FuncComponent.js'
// 컴포넌트 명은 대문자일때만 인지한다
import Second from './components/ClassComponent.js'
import PropsEx1 from './components/PropsExample.js'
import PropsEx2 from './components/PropsExample2.js'
import ClassStateExample from './components/ClassStateExample.js'
import InDecrease from './components/Prac_NumInDecrease.js'
import FuncStateExample from './components/FuncStateExample.js'
import InDecrease2 from './components/Prac_NumInDerease2.js'
import FuncStateExample2 from './components/FuncStateExample2.js'
import PracInput from './components/Prac_Input.js'

function App() {
  return (
    <div style={{color:'green', border:'1px solid red', textAlign:'center',padding:'300px'}}>
      <Test/>
      <Second/>
      <hr/>
      <PropsEx1/>
      <hr/>
      <PropsEx1 food='라면'/>
      <hr/> 
      <PropsEx1>스파게티</PropsEx1>
      <hr/>
      <PropsEx1>
        <div style={{backgroundColor:'lightgray'}}>감자칩...</div>
      </PropsEx1>
      <hr/>
      <PropsEx2 food='탕수육'/>
      <hr/>
      <PropsEx2>
        <span>마라탕</span>
      </PropsEx2>

      <hr/>
      <ClassStateExample btnName='클릭'/>
      <hr/>
      <InDecrease/>

      <hr/>
      <FuncStateExample/>
      <hr/>
      <InDecrease2/>
      <hr/>
      <FuncStateExample2/>
      <hr/>
      <PracInput/>
    </div>
  );
}

export default App;
