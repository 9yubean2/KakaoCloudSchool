const express = require("express");
var app = express();
app.get("/test",(request,response)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>Get Test</h1>`);
})

app.post("/test",(request,response)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>POST Test</h1>`);
})

app.get("/data",(req,res)=>{
    res.send({name:"A",age:12,phone:"010-0000-0000"});
})

app.get("/msg",(req,res)=>{
    res.send("<h1>Message</h1>");
})

app.use((request,response)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>Hi Express</h1>`);
});
app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})