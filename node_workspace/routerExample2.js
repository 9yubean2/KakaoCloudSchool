const express = require("express");
var app = express();
app.use(express.urlencoded({extended:true}));

var boardRouter = express.Router(); //라우터 객체를 만든다

boardRouter.get("/list",(req,res)=>{
    res.send("/board/list");
});

boardRouter.get("/write",(req,res)=>{
    res.send("/board/write");
});

boardRouter.get("/view",(req,res)=>{
    res.send("/board/view");
});
app.use("/board",boardRouter); //url이 /board로 시작하는건 모두 boardRouter 에게 보낸다.
//boardRouter의 url은 자동으로 /board로 부터 시작되서
//board/list, board/write, board/view 형태로 된다.
app.use((req,res)=>{
    res.writeHead(200,{'Content-Type':'text/html'});
    res.end(`<h1>Hi Express</h1>`);
});
app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})