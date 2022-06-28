const fs = require("fs");
const http = require ("http");
const url = require ("url"); 
const queryString = require ("querystring"); //현재는 폐기된 라이브러리 
//post로 온 데이터 처리
//http://127.0.0.1:3000/?name=Tom&age=25
var server = http.createServer((req,res)=>{
    var pathName = url.parse(req.url).pathname;
    if(req.method == "GET" && pathName == "/")//GET방식일 때
    {
        console.log(req);
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정
        console.log(query);
        console.log(query.name, query.age);
        console.log(query["name"], query["age"]);
        var data = fs.readFileSync("./html/index.html","utf-8");

        res.statusCode = 200;
        res.setHeader("Content-type","text/html");
        res.end(data);
    }
    else if(req.method == "POST"&& pathName == "/"){
        // req.on("data",(data)=>{
        //     var result = queryString.parse(data.toString());
        //     console.log(result.username, result.userage);
        //     res.statusCode = 200;
        //     res.setHeader("Content-type","text/html");
        //     res.end("<h1>"+data+"</h1>");
        // });
        let body = "";
        req.on("data",(data)=>{
            body+=data;
        });
        req.on("end", ()=>{
            let postData = new URLSearchParams(body);
            console.log(postData);
            console.log(postData.get("username"),postData.get("userage"));
            res.setHeader("Content-type","text/html");
            res.end(`<h1>${postData.get("username")},${postData.get("userage")}</h1>`);
        })
        
    }
});
server.listen(3000,"127.0.0.1",()=>{
    console.log("Server Start at http://127.0.0.1:3000");
});
