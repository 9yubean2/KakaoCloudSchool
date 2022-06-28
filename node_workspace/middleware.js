const express = require("express");
const { resetWarningCache } = require("prop-types");

var app = express();
//본래의 callback함수에는 세번째 인자로 next를 둔다.
//next를 호출하면 현재의 함수로부터 그 다음 위치에 있는 함수를 자동으로 호출
//next를 호출하지 않으면 해당 함수에서 작동을 멈춤
app.use((req,res,next)=>{
    req.name = "Anne";
    res.name = "Bred";
    console.log("First MiddleWare");
    next();
});
app.use((req,res,next)=>{
    req.mobile = "010-0000-0000";
    res.mobile = "010-9999-9999";
    console.log("Second MiddleWare");
    next();
});
app.use((req,res,next)=>{
    console.log("Third MiddleWare");
    res.writeHead(200,{'Content-Type':'text/html'});
    res.write("<h1>"+req.name+"</h1>");//end함수가 호출되어야 전송이 종료
    res.write("<h1>"+res.name+"</h1>");
    res.write("<h1>"+req.mobile+"</h1>");
    res.write("<h1>"+res.mobile+"</h1>");
    res.end("<h1>Express MiddleWare</h1>");
});
app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})