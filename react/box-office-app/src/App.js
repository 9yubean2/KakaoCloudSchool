import axios from 'axios';
import React, { useState } from 'react';
import './App.css';
import Lists from './components/Lists';

export default function App() {

  const [query, setQuery] = useState("");

  const [movieList,setMovieList]= useState([  ]);

 
  const option = {

    url:'https://api.themoviedb.org/3/movie/popular',
    method:'GET',
    params:{api_key:'84dcca61f9944a6e09e7dfcf27364b36'},
    responseType:'json'

  }

  let resultList = [];

  const search = () =>{
    
    axios(option)
    .then(function(response){
      let results = response.data.results;

      results.map((result)=>{
        let newList = {
          id: `${result.id}`,//유니크한 값을 표현하기 위해
          title: `${result.title}`,
          posterPath:`${result.poster_path}`,
          releaseDate:`${result.release_date}`,
          average:`${result.vote_average}`,
          popularity: `${result.popularity}`,
          language:`${result.original_language}`        
        }
        console.log(newList);
        resultList.push(newList);
      })

      console.log(resultList);
      
      
    })
    .catch(function(){
      alert('Fail to Loading..');
    })
    .finally(function(){
      alert('Done!');
      console.log(movieList);
      
      console.log(resultList);
      setMovieList(resultList); 
      // movieList.map((movie)=>{
      //   console.log(movie.title);
      // })
    })
  }


  const queryHandler = (e) =>{
    setQuery(e.target.value);
  }  


  return (
    <div className="flex items-center justify-center w-90 min-h-screen max-h-fit bg-[#757575]">
      <div className="flex items-center w-full p-10 m-10 bg-white rounded shadow w-5/6 h-5/6  max-h-max flex-col">
        <div>
          <h1 className="text-3xl font-bold m-8">
            MOVIE LIST
          </h1>
        </div>
        <div >
          <input type='date'className='w-96 px-3 py-2 mr-4 text-gray-500 border rounded shadow'/>
          <button className="h-10 px-4 rounded bg-[#66add4] text-white"
            onClick={search}>SEARCH</button>
        </div>
        <nav className="py-4 px-6 text-sm font-medium m-8">
          <ul className="flex space-x-3">
            <li>
              <p className="block px-3 py-2 rounded-md bg-sky-500 text-white">TOP RATED</p>
            </li>
            <li>
              <p className="block px-3 py-2 rounded-md bg-sky-500 text-white">TOP RATED</p>
            </li>
            <li>
              <p className="block px-3 py-2 rounded-md bg-sky-500 text-white">TOP RATED</p>
            </li>
          </ul>
        </nav>
    
        <Lists movieList={movieList}
              setMovieList={setMovieList}/> 
      </div>  
    </div>
    
   
  );
}
