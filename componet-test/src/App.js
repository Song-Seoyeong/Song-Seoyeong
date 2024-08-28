import Test from './components/FuncComponent.js'
// 컴포넌트 명은 대문자일때만 인지한다
import Second from './components/ClassComponent.js'

function App() {
  return (
    <span style={{color:'pink', border:'1px solid red'}}>
      <Test/>
      <Second/>
    </span>
  );
}

export default App;
