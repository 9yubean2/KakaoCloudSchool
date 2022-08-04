import './App.css';

function App() {
  return (
    <div >
      <h1 class="text-3xl font-bold">BOX OFFICE LIST</h1>
      <div>
        <input type="date"/><button>SEARCH</button>
      </div>
      <div>
        <table>
          <thead>
            <tr>
              <th>순위</th>
              <th>포스터</th>
              <th>영화제목</th>
              <th>주연배우</th>
              <th>영화 개봉일</th>
              <th>삭제</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td>1</td>
            </tr>
            
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
