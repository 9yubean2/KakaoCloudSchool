const http = require ("http");
const url = require("url");
const fs = require("fs");
const ejs = require("ejs");

var server = http.createServer((req,res)=>{
    var pathName = url.parse(req.url).pathname;
    fs.readFile("./html/test.html","utf-8",(error,data)=>{
        res.statusCode=200;
        res.setHeader("Content-type","text/html");
        res.end(ejs.render(data,{
            title:"Lets Learn EJS Engine",
            contents:"JSON to HTML",
            fruits:["사과","배","망고","바나나"],
            products:[{name:"laptop",price:20000000},
            {name:"airconditional",price:30000000},
            {name:"refrigilator",price:40000000},
            {name:"iphone",price:18000000},]
        }));
    })
    
})
server.listen(3000,"127.0.0.1",()=>{
    console.log("Server Start at http://127.0.0.1:3000");
});