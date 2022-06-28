const express = require("express");
var app = express();
app.get("/userinfo",(req,res)=>{
    console.log(req.query);
    var name = req.query.name;
    var age = req.query.age;
    // test in ) http://localhost:3000/userinfo?name=A&age=25
    res.end(`<h1>${name} is ${age}</h1>`);
});

app.get("/array",(req,res)=>{
    var arr = req.query.arr;
    var result = "";
    for(i in arr){
        result += `${arr[i]}<br/>`
    }
    res.end(`<h1>${result}</h1>`);
})

app.post("/test",(request,response)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>POST Test</h1>`);
})
app.use((request,response)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>Hi Express</h1>`);
});
app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})