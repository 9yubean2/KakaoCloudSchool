import React from 'react'

const Lists = ({movieList,setMovieList}) => {
  return (
    <ul className="divide-y divide-slate-100 min-h-min max-h-fit">
    {movieList.map((movie) => (
        // <div className="bg-gray-100 flex items-center justify-between w-full px-2 py-1 mx-1 my-2 text-gray-600  border rounded">
    
      <article className="flex space-x-8 p-6">
        <img src={`https://image.tmdb.org/t/p/w500${movie.posterPath}`} alt="" width="80" height="100" className="flex-none rounded-md bg-slate-100" />
        <div className="min-w-0 relative flex-auto">
        <p className="text-slate-400">{`#${movie.id}`}</p>
          <h2 className="font-semibold text-slate-900 truncate pr-20">{movie.title}</h2>
            <dl className="mt-2 flex flex-wrap text-sm leading-6 font-medium">
            <div className="absolute top-0 right-0 flex items-center space-x-1">
              <dt className="text-sky-500">
                <span className="sr-only">Star rating</span>
                <svg width="16" height="20" fill="currentColor">
                  <path d="M7.05 3.691c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.372 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.539 1.118l-2.8-2.034a1 1 0 00-1.176 0l-2.8 2.034c-.783.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.363-1.118L.98 9.483c-.784-.57-.381-1.81.587-1.81H5.03a1 1 0 00.95-.69L7.05 3.69z" />
                </svg>
              </dt>
              <dd>{movie.average}</dd>
            </div>
            <div>
              <p className="px-1.5 ring-1 ring-slate-200 rounded">{movie.language}</p>
            </div>
            <div className="ml-2">
              <p>{movie.releaseDate}</p>
            </div>
            
            <div>
                <svg width="2" height="2" fill="currentColor" className="mx-2 text-slate-300" aria-hidden="true">
                  <circle cx="1" cy="1" r="1" />
                </svg>
                {""}
            </div>
            <div className="flex-none w-full mt-2 font-normal">
              <p className="text-slate-300">popularity</p>
              <p className="text-slate-400">{movie.popularity}</p>
            </div>
            </dl>
        </div>
      </article>
    
    ))}
    
    </ul>
    
  )
}
export default Lists;
