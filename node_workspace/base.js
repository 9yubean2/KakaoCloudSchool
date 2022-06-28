const http = require ("http");
const url = require("url");
const fs = require("fs");

var server = http.createServer((req,res)=>{
    var pathName = url.parse(req.url).pathname;
    res.statusCode=200;
    res.setHeader("Content-type","text/html");
    res.end("<h1>Hello Node.js</h1>");
})
server.listen(3000,"127.0.0.1",()=>{
    console.log("Server Start at http://127.0.0.1:3000");
});