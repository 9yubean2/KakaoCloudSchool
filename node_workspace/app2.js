const express = require("express");
var app = express();
app.get("/test",(req,res)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>Get Test</h1>`);
})

app.post("/test",(req,res)=>{
    response.writeHead(200,{'Content-Type':'text/html'});
    response.end(`<h1>POST Test</h1>`);
})
app.use("/",(req,res)=>{
    console.log(req);
    var agent = req.header("User-Agent");
    console.log(agent);
    //match(/패턴/) - 정규식
    if(agent.toLowerCase().match(/chrome/))
        res.send("agent is Chrome");
    else
        res.send("agent is Not Chrome");
});
app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})