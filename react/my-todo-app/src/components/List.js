import React, { useCallback, useState } from 'react';
const List = React.memo(({id,title,completed,editMode,todoData,setTodoData,provided,snapshot,deleteClick}) => {


    const [edit, setEdit] = useState("");
    console.log("List");

    const checkClick = (id) => {
        const updateTodo = todoData.map((data) => {
            if (data.id === id) {
                data.completed = !data.completed
            }
            return data;
        });
    
        setTodoData(updateTodo);
    }

    const editClick = (id) => {
        const updateTodo = todoData.map((data) => {
            if (data.id === id) {
                data.editMode = !data.editMode
            }
            return data;
        });
    
        setTodoData(updateTodo);
    }

    const editSaveClick = (id) => {
        const editTodo = todoData.map((data) => {
            if (data.id === id) {
                data.title = edit
                data.editMode = !data.editMode
            }
            return data;
        });
    
        setTodoData(editTodo);
    }

    const backClick = (id) => {
        if(window.confirm("Cancel to Edit?")){
            setEdit("");
            const editCancelTodo = todoData.map((data) => {
                if (data.id === id) {
                    data.editMode = !data.editMode
                }
                return data;
            });
            setTodoData(editCancelTodo);
        }
        else{
            return;
        }
    }

    const editInput=(e)=>{
        setEdit(e.target.value);
    }

    
    if(editMode){
        return(
            <div key={id}
            {...provided.draggableProps} 
            ref={provided.innerRef}
            {...provided.dragHandleProps}>
                <div className={`${snapshot.isDragging?"bg-gray-300":"bg-gray-100"} 
                                flex items-center justify-between
                                w-full px-2 py-1 mx-1 my-2 text-gray-600  border rounded`}>
                    <div className='items-center' >
                        <input type="text" placeholder={title}
                        value={edit}
                        className='w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow'
                        onChange={editInput}/>
                    </div>
                    <div className='items-center'>
                        <button     
                            className="h-10 px-4 rounded bg-[#6fcaed] text-white"
                            onClick={()=>editSaveClick(id)}>Save
                        </button>
                        <button 
                            className="h-10 px-4 rounded bg-[#fa6055] text-white"
                            onClick={()=>backClick(id)}>Back
                        </button>
                    </div>
                </div>
            </div>

        )
    }else{
        return (
    
            <div key={id}
                                        {...provided.draggableProps} 
                                        ref={provided.innerRef}
                                        {...provided.dragHandleProps}>
                                            <div className={`${snapshot.isDragging?"bg-gray-300":"bg-gray-100"} 
                                                            flex items-center justify-between
                                                            w-full px-2 py-1 mx-1 my-2 text-gray-600  border rounded`}
                                                            id={`List${id}`}>
                                                <div className='items-center' >
                                                    <input type="checkbox"
                                                            defaultChecked={false}
                                                            onChange={() => checkClick(id)} />
                                                {" "}<span id={id} className={completed ? "line-through" : undefined}>{title}</span>
                                                </div>
                                                <div className='items-center'>
                                                    <button     
                                                        className="h-10 px-4 rounded bg-[#ffd36e] text-white"
                                                        onClick={()=>editClick(id,title)}
                                                        id={`btnEdit${id}`}>Edit
                                                    </button>
                                                    <button 
                                                        className="h-10 px-4 rounded bg-[#fa6055] text-white"
                                                        onClick={()=>deleteClick(id)}
                                                        id={`btnDelete${id}`}>Delete
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
          )
    }

  
});

export default List;