import React, { useCallback, useState } from 'react';
import "./App.css";
import Lists from './components/Lists';
import Form from './components/Form';

//render method 没有
//함수의 return값이 JSX
export default function App() {
  console.log("App");
  
  const [todoData,setTodoData]= useState([
    {
      id: '1',
      title: '공부하기',
      completed:false,
      editMode:false
    },
  ]);

  const [value, setValue] = useState("");

  const deleteClick = useCallback((id) => {
    if(window.confirm("Really Delete?")){
        const newTodoData = todoData.filter((data)=> data.id !== id)
        setTodoData(newTodoData);
    }
    else{
        return;
    }
  },[todoData]);

  return (
    <div className="flex items-center justify-center w-screen h-screen bg-[#ddedc0]">
    <div className="w-full p-6 m-4 bg-white rounded shadow md:w-3/4 md:max-w-lg lg:w-3/4 lg: max-w-lg">
        <div className="flex justify-between mb-3">
            <h1 className="text-2xl font-bold text-slate-900">TODO LIST</h1>
        </div>

          <Lists todoData={todoData}
                 setTodoData={setTodoData}
                 deleteClick={deleteClick}/>

          <Form todoData={todoData}
                setTodoData={setTodoData}
                value={value}
                setValue={setValue}/>
        </div>

      </div>
  )
}
