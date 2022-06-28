const express = require("express");
var app = express();
app.use(express.urlencoded({extended:true}));

//특정 url - 어떤 action이 짝이 될 것인가 - 라우터
app.get("/a",(req,res,next)=>{
    res.send("This is a"); //writeHead + write + end = send 스스로 들어오는 데이터에 맞춰서 적절하게 가공 후 전송
});

app.get("/b",(req,res,next)=>{
    res.send("This is b");
});

app.get("/a/:x",(req,res,next)=>{
    var x = req.params.x;
    res.send("value that receive is " + x)
});

app.get("/add/:x/:y",(req,res,next)=>{
    var x = parseInt(req.params.x);
    var y = parseInt(req.params.y);
    res.send(`${x} + ${y} = ${x+y}`);
});

//http://127.0.0.1:3000/person/Tom/11/010-0000-0000
app.get("/person/:name/:age/:mobile",(req,res,next)=>{
    var name = req.params.name;
    var age = req.params.age;
    var mobile = req.params.mobile;
    res.send(`${name} is ${age} and mobile ie ${mobile}`);
});

http://127.0.0.1:3000/person?name=Tom&age=11&mobile=010-9999-9999
app.get("/person",(req,res,next)=>{
    var name = req.query.name;
    var age = req.query.age;
    var mobile = req.query.mobile;
    res.send(`${name} is ${age} and mobile ie ${mobile}`);
});
app.post("/person",(req,res,next)=>{
    var name = req.body.name;
    var age = req.body.age;
    var mobile = req.body.mobile;
    res.send(`${name} is ${age} and mobile ie ${mobile}`);
});
app.use((req,res)=>{
    res.writeHead(200,{'Content-Type':'text/html'});
    res.end(`<h1>Hi Express</h1>`);
});

app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})