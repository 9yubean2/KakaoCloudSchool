const http = require ("http");
const url = require("url");
const fs = require("fs");
const jade = require("jade");

var server = http.createServer((req,res)=>{
    var pathName = url.parse(req.url).pathname;
    fs.readFile("./html/test.jade","utf-8",(error,data)=>{
        var fn = jade.compile(data);
        res.statusCode=200;
        res.setHeader("Content-type","text/html");
        res.end(fn({
            title:"Lets Learn JADE Engine",
            contents:"JSON to HTML"
        }));
    })
    
})
server.listen(3000,"127.0.0.1",()=>{
    console.log("Server Start at http://127.0.0.1:3000");
});