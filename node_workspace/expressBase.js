const express = require("express");
var app = express();

app.use((req,res)=>{
    res.writeHead(200,{'Content-Type':'text/html'});
    res.end(`<h1>Hi Express</h1>`);
});
app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})