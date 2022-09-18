import axios from 'axios';
import React, { useState } from 'react';
import './App.css';
import Lists from './components/Lists';

export default function App() {

  const [query, setQuery] = useState("");

  const [movieList,setMovieList]= useState([  ]);


  const optionNow = {

    url:'https://api.themoviedb.org/3/movie/now_playing',
    method:'GET',
    params:{api_key:'My',
            language:'ko-KR',
            region:'KR'},
    responseType:'json'

  }
 

  const option = {

    url:'https://api.themoviedb.org/3/movie/popular',
    method:'GET',
    params:{api_key:'My',
            language:'ko-KR'},
    responseType:'json'

  }

  const optionTopRate = {

    url:'https://api.themoviedb.org/3/movie/top_rated',
    method:'GET',
    params:{api_key:'My',
            language:'ko-KR'},
    responseType:'json'

  }

  let resultList = [];

  const now = () =>{
    
    axios(optionNow)
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



  const topRate = () =>{
    
    axios(optionTopRate)
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
        <nav className="text-sm font-medium mb-10">
          <ul className="flex items-center space-x-5">
            <li>
              <button className="block px-3 py-2 rounded-md bg-sky-500 text-white" onClick={now}>NOW PLAYING</button>
            </li>
            <li>
              <button className="block px-3 py-2 rounded-md bg-sky-500 text-white" onClick={search}>POPULAR</button>
            </li>
            <li>
              <button className="block px-3 py-2 rounded-md bg-sky-500 text-white" onClick={topRate}>TOP RATED</button>
            </li>
          </ul>
        </nav>
    
        <Lists movieList={movieList}
              setMovieList={setMovieList}/> 
      </div>  
    </div>
    
   
  );
}
