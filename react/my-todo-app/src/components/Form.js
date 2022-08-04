import React from 'react'

export default function Form({todoData,setTodoData,value,setValue}) {
  console.log("Form");

    const handleSubmit=(e)=>{ 
        //submit event 발생
        //default event 처리 안할 거에요
        e.preventDefault();
    
        let newTodo = {
          id: Date.now(),//유니크한 값을 표현하기 위해
          title: value,
          completed:false
        }
    
        setTodoData([...todoData,newTodo]);
    
        //입력칸에 있는거 비워주기
        setValue("");
    
      }
    
      const handleChange=(e)=>{
        setValue(e.target.value);
      }

  return (
        <div>
             <form onSubmit={handleSubmit} className="flex pt-2">
              <input type="text" 
                     name="todoInput" 
                     placeholder="오늘의 할일을 입력하세요!" 
                     value={value} 
                     className='w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow'
                     onChange={handleChange} />
              
              
              <input type="submit"
                     value="Write ✏️" 
                     className='p-2 text-black rounded border-2 border-[#969696]'/><br></br>
            </form>
        </div>
    
  )
}
