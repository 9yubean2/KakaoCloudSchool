import React from 'react'
import { DragDropContext, Draggable, Droppable } from 'react-beautiful-dnd';
import List from './List'
import Edit from './Edit'

const Lists = React.memo(({todoData,setTodoData,deleteClick})=>{

    console.log("Lists");
     const handleDrop=(e)=>{
        //만약에 drop end한 위치가 DragDropContext밖이면 return
        if(!e.destination) return;

        // copy todoData
        const updateTodo = todoData;

        //drag되는 요소 삭제
        const [reorder] = updateTodo.splice(e.source.index,1);

        //drop되는 위치에 삽입
        updateTodo.splice(e.destination.index,0,reorder);

        //순서 바꾼 배열로 setTodoData 
        setTodoData(updateTodo);

    }

    return (
        <div>
            <DragDropContext onDragEnd={handleDrop}>
                <Droppable droppableId='to-do'>
                    {(provided)=>(
                        <div {...provided.droppableProps} ref={provided.innerRef}>
                        {todoData.map((data,index) => (
                            <Draggable 
                                key={data.id}
                                draggableId={data.id.toString()}
                                index={index}>
                                    {(provided,snapshot)=>(
                                        <List id={data.id}
                                        title={data.title}
                                        completed={data.completed}
                                        editMode={data.editMode}
                                        todoData={todoData}
                                        setTodoData={setTodoData}
                                        provided={provided}
                                        snapshot={snapshot}
                                        deleteClick={deleteClick}/>
                                    )                                             
                                    }
                            </Draggable>
                        ))}
                        {provided.placeholder}
                        </div>
                    )}
                </Droppable>
            </DragDropContext>
        </div>
    )
});
export default Lists;

//구조 분해 할당을 이용
//export default function Lists({todoData,setTodoData}) {

    // const handleDrop=(e)=>{
    //     //만약에 drop end한 위치가 DragDropContext밖이면 return
    //     if(!e.destination) return;

    //     // copy todoData
    //     const updateTodo = todoData;

    //     //drag되는 요소 삭제
    //     const [reorder] = updateTodo.splice(e.source.index,1);

    //     //drop되는 위치에 삽입
    //     updateTodo.splice(e.destination.index,0,reorder);

    //     //순서 바꾼 배열로 setTodoData 
    //     setTodoData(updateTodo);

    // }

    // return (
    //     <div>
    //         <DragDropContext onDragEnd={handleDrop}>
    //             <Droppable droppableId='to-do'>
    //                 {(provided)=>(
    //                     <div {...provided.droppableProps} ref={provided.innerRef}>
    //                     {todoData.map((data,index) => (
    //                         <Draggable 
    //                             key={data.id}
    //                             draggableId={data.id.toString()}
    //                             index={index}>
    //                                 {(provided,snapshot)=>(
    //                                     <List id={data.id}
    //                                     title={data.title}
    //                                     completed={data.completed}
    //                                     todoData={todoData}
    //                                     setTodoData={setTodoData}
    //                                     provided={provided}
    //                                     snapshot={snapshot}/>
    //                             )}
    //                         </Draggable>
    //                     ))}
    //                     {provided.placeholder}
    //                     </div>
    //                 )}
    //             </Droppable>
    //         </DragDropContext>
    //     </div>
    // )
//}
