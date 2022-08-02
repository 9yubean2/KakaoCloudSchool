function getData(){
   //서버 프로그램을 호출해서 결과를 받아와서 화면 처리
   //비동기 방식으로 처리
   //Ajax를 이용해서 처리
    $("tbody").empty();
   let targetDate = $("#searchDate").val().replace(/-/g,'');

   $.ajax({
      async:true,//Ajax는 기본이 비동기 방식
      url:'https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
      type:"GET",
      dataType:'json', //파싱 필요 없다
      data:{ key:'ac733e4361119585d5f69a529226d016', targetDt:`${targetDate}`}
      //timeout: 3000
   }).done(
       function(result){
           // console.log(result);
           // movieName = result['boxOfficeResult']['dailyBoxOfficeList'][0]['movieNm'];
           let list = result['boxOfficeResult']['dailyBoxOfficeList'];

           list.forEach((item)=>{
               $.ajax({
                   async:false,//Ajax는 기본이 비동기 방식
                   url:'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json',
                   type:"GET",
                   dataType:'json', //파싱 필요 없다
                   data:{ key:'ac733e4361119585d5f69a529226d016', movieCd:`${item['movieCd']}`}
                   //timeout: 5000
               }).done(
                   function(result){
                       let actorlist = result['movieInfoResult']['movieInfo']['actors'];
                       //console.log(actorlist);
                       let actors = '';
                       for( i=0;i<3;i++){
                           //console.log(actorlist[i].peopleNm);
                           actors += actorlist[i].peopleNm;
                           actors+= ' ';
                       }
                       $.ajax({
                           async:false,
                           type:"GET",
                           dataType:'json', //파싱 필요 없다
                           // timeout: 3000,
                           url: 'https://dapi.kakao.com/v2/search/image',
                           data: { query : `${item['movieNm']}포스터`},
                           headers : {Authorization: 'KakaoAK aa16998fa801571a3a5f17d1ee323ab3'}



                       })
                           .done(
                           function(result){
                               console.log(result);
                               img_url =  result.documents[0].image_url;
                               $("tbody")
                                   .append(`<tr><td>${item['rank']}</td><td><img src="${img_url}" width="150"/></td><td>${item['movieNm']}</td><td>${actors}</td><td>${item['openDt']}</td><td><input type="button" id="btnDelete" onclick="deleteMovie()" value="삭제"/></td></tr>`);
                           }
                       ).fail(
                           function() {
                               alert('Error');
                           }
                       )
                       // $("tbody")
                       //     .append(`<tr><td>${item['rank']}</td><td><img src="" width="50"/></td><td>${item['movieNm']}</td><td>${actors}</td><td>${item['openDt']}</td></tr>`);
                   }

               ).fail(
                   function() {
                       alert('Error');
                   }
               );
           });

       }
   ).fail(
       function() {
           alert('Error');
       }
   );
}

// function loadPoster(movieNm){
//     let img_url = '';
//     $.ajax({
//         type:"GET",
//         dataType:'json', //파싱 필요 없다
//         // timeout: 3000,
//         url: 'https://dapi.kakao.com/v2/search/image',
//         data: { query : `${movieNm}`},
//         headers : {Authorization: 'KakaoAK aa16998fa801571a3a5f17d1ee323ab3'}
//     }).done(
//         function(result){
//             return result.documents[0].image_url;
//         }
//     ).fail(
//         function() {
//             alert('Error');
//         }
//     );
//
// }
$(function(){
    $("#MyTable").on("click", "#btnDelete", function() {
        $(this).closest("tr").remove();
    });
})


