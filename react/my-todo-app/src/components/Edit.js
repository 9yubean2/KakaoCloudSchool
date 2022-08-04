import React from 'react'

const Edit = React.memo(({id,title,completed,editMode,todoData,setTodoData,provided,snapshot,deleteClick}) => {

  return (
    <div key={id}
                                {...provided.draggableProps} 
                                ref={provided.innerRef}
                                {...provided.dragHandleProps}>
                                    <div className={`${snapshot.isDragging?"bg-gray-300":"bg-gray-100"} 
                                                    flex items-center justify-between
                                                    w-full px-2 py-1 mx-1 my-2 text-gray-600  border rounded`}>
                                        <div className='items-center' >
                                            <input type="text" value={title}/>
                                        </div>
                                        <div className='items-center'>
                                            <button     
                                                className="h-10 px-4 rounded bg-[#6fcaed] text-white">Save
                                            </button>
                                            <button 
                                                className="h-10 px-4 rounded bg-[#fa6055] text-white"
                                                onClick={()=>deleteClick(id)}>Back
                                            </button>
                                        </div>
                                    </div>
                                </div>
  )
});

export default Edit;