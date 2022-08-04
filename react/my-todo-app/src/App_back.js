import React,{ Component }  from "react";
import "./App.css";
//class형 component

export default class App extends Component{
  
  constructor(props){
    super(props);
    this.state = {
      todoData : [
        {
          id: '1',
          title: '공부하기',
          completed:false
        },
        {
          id: '2',
          title: '운동하기',
          completed:false
        },
        {
          id: '3',
          title: '밥먹기',
          completed:false
        }
      ],value:""
    }
  }

  btnStyle = {
    color:'#ffffff',
    backgroundColor:'#fa6055',
    border:'none',
    padding:'7px 9px',
    borderRadius:'7px',
    cursor: 'pointer',
    float:'right',
  
  }

  btnAddStyle = {
    color:'#000000',
    backgroundColor:'#ffffff',
    border:'1px #828181 solid',
    padding:'7px 15px',
    borderRadius:'7px',
    cursor: 'pointer',
    float:'right',
    margin:'0px 15px'
  
  }

  getStyle=(completed)=>{
    return {
      padding:'20px 20px 20px 0px',
      borderBottom:'1px #5995e3 dashed',
      textDecoration:completed?'line-through':'none'
    }
  }

  getCheckStyle=()=>{
    return {
      margin:'0px 20px',
    
    }
  }

  formStyle=()=>{
    return {
      padding:'20px 5px 10px 10px',
    }
  }

  deleteClick = (id) => {
    //해당 아이디에 대한 할일 목록을 지워야 해요
    const newTodoData = this.state.todoData.filter((data)=> data.id !== id)
    //console.log(newTodoData);
    this.setState({todoData:newTodoData});
    //변경된 데이터를 가지고 화면을 repainting
    //React State
    
  }

  addClick = () => {

    let idx = 0;
    
    //현재 목록 개수 체크해서
    if(this.state.todoData.length<1){
      //1개도 없으면 추가하는 항목의 id를 1로
      idx=1;
    }
    else{
      //1개 이상 있으면 추가하는 항목의 id를 현재 id+1로
      const lastItem = this.state.todoData[this.state.todoData.length - 1];
      idx = parseInt(lastItem.id)+1;
    }
    //현재 배열에 배열요소 추가해서 새로운 배열 생성
    const addTodo = this.state.todoData.concat({ id: `${idx}`,title: `${this.state.value}`,completed:false });
    console.log(addTodo);

    //rendering
    this.setState({
      todoData: addTodo
    });

    //입력칸에 있는거 비워주기
    this.setState({value:""});
  }

  handleSubmit=(e)=>{
    //submit event 발생
    //default event 처리 안할 거에요
    e.preventDefault();

    let newTodo = {
      id: Date.now(),//유니크한 값을 표현하기 위해
      title: this.state.value,
      completed:false
    }

    this.setState({
      todoData:[...this.state.todoData,newTodo]
    })

    //입력칸에 있는거 비워주기
    this.setState({value:""});

  }

  handleChange=(e)=>{
    this.setState({value:e.target.value});
  }

  checkClick = (id) => {

    const updateTodo = this.state.todoData.map((data) => {
      if (data.id === id) {
        data.completed = !data.completed
      }
      return data;
    });

    this.setState({
      todoData: updateTodo
    });

    // const findIndex = this.state.todoData.findIndex(data => data.id === `${id}`);
    // let copyArray = [...this.state.todoData];
    // if(findIndex !== -1) {
    //   copyArray[findIndex] = {...copyArray[findIndex], completed: !(copyArray[findIndex].completed)};
    // }
    // console.log(copyArray);

    // this.setState({
    //   todoData: copyArray
    // });
    
    
    // if(document.getElementById(`${id}`).style.textDecorationLine === "line-through"){
    //   document.getElementById(`${id}`).style.textDecorationLine = '';
    
    // } else {
    //   document.getElementById(`${id}`).style.textDecorationLine = "line-through"
    // }
    

  }

  render(){
    return (
      //JSX Code
      <div className="container">
        <div className="todoBlock">
          
          <div>
            <h1>TODO LIST</h1>
          </div>

          {this.state.todoData.map(data=>( 
            <div style={this.getStyle(data.completed)} key={data.id}>
              <input type="checkbox" 
              defaultChecked={data.completed} style={this.getCheckStyle()}
              onChange={()=>this.checkClick(data.id)} />
              <span id={data.id}>{data.title}</span>
              <button style={this.btnStyle} 
                      onClick={()=>this.deleteClick(data.id)}>Delete</button><br></br>
          </div>
          ))}
          <div style={this.formStyle()}>
            <form style={{display:'flex'}} onSubmit={this.handleSubmit}>
              <input type="text" 
                     name="todoInput" 
                     placeholder="오늘의 할일을 입력하세요!" 
                     value={this.state.value} 
                     style={{flex:'10', padding:'10px', borderRadius:'5px', border:'1px #828181 solid'}}
                     onChange={this.handleChange} />
              
              
              <input type="submit"
                     value="Write ✏️" 
                     className="btn" 
                     style={this.btnAddStyle}/><br></br>
              {/* <input type="button"
                     value="Write ✏️" 
                     className="btn" 
                     style={this.btnAddStyle} 
                     onClick={this.addClick}/><br></br> */}
            </form>
          </div>
        </div>

      </div>
    )
  }
}
