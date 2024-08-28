function App() {
  const value = 'hi my name is Zito'
  return (
    <div className="App">
      <h1>안녕하세요</h1>
      <div style={{border:'2px solid pink'}}>
        감사해요
      </div>
      <div className='hello'>
        잘있어요
      </div>
      <div style={{color:'gray', fontSize: '30px'}}>{value}</div>
      <div style={{color:'blue', fontSize: '50px'}}>
        {value === 'hi my name is Zito'? (
          '자기소개입니다'
        ):(
          '아닙니다'
        )}
      </div>
    </div>
  );
}

export default App;


// app 함수 생성
// 함수를 배포하기 위해 export default로 배포 (파일을 배포하는게 아님)
// 람다식??