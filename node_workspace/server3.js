const http = require ("http");
const url = require("url");
const fs = require("fs");

//url에 따라서 다르게 동작하는 걸 라우팅한다고 한다
var server = http.createServer((req,res)=>{
    var pathName = url.parse(req.url).pathname;
    if(pathName=="/"){
        res.statusCode=200;
        res.setHeader("Content-type","text/html");
        res.end("<h1>Hello Node.js</h1>");
    }
    else if(pathName == "/hello")//GET방식일 때
    {
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정
        res.setHeader("Content-type","text/html");
        res.end(`<h1>Hello ${query.name}!!!!</h1>`);
    }
    else if(pathName == "/add")//GET방식일 때
    {
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정

        res.setHeader("Content-type","text/html");
        res.end(`<h1>${parseInt(query.x)+parseInt(query.y)}</h1>`);
    }
    else if(pathName == "/gugu")//GET방식일 때
    {
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정
        
        res.setHeader("Content-type","text/html");
        let result="";
        for(i=1;i<=9;i++){
            result += `<h1> ${parseInt(query.dan)} x ${i} = ${parseInt(query.dan)*i} </h1>`;
        }
        res.end(result);
    }
    else if(pathName == "/rect")//GET방식일 때
    {
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정
        res.setHeader("Content-type","text/html");
        res.end(`<h1>rect ${parseInt(query.width)*parseInt(query.height)}</h1>`);
    }
    else{
        res.statusCode=200;
        res.setHeader("Content-type","text/html");
        res.end("<h1>Wrong URL</h1>");
    }
    
})
server.listen(3000,"127.0.0.1",()=>{
    console.log("Server Start at http://127.0.0.1:3000");
});

/*
문제1: http://127.0.0.1:3000/hello?name=Jane HelloJane!!!!
문제2: http://127.0.0.1:3000/add?x=1-&y=7 17
문제3: http://127.0.0.1:3000/gugu?dan=4 4단 출력
문제 4: http://127.0.0.1:3000/rect?width=5&height=7 사각형 면적 35
*/