const cookieParser = require("cookie-parser");
const express = require("express");
var app = express();

app.use(express.urlencoded({extended:true}));
app.use(cookieParser());

//쿠키-사용자공간(클라이언트컴퓨터)에 정보를 저장
//세션-서버(서버컴퓨터에 로그인하면 계속 유지)-세션저장소(db랑 연결)
//response객체가 cookie라는 함수를 갖고 있고 이 함수를 통해 쿠키에 정보를 저장한다.
app.use("/setCookie",(req,res)=>{
    res.cookie("key1","test");//key는 String이지만 값은 String말고도 Object 저장 가능
    res.cookie("key2",{
        userid:"test1234",
        username:"Anne"
    });
    res.end();
    //res.redirect("/getCookie");
    //배열의 경우 index를 통해서 이 index가 무조건 숫자
    //map구조, json 구조는 값을 숫자 인덱스가 아니라 문자열 인덱스로 검색
});

app.use("/getCookie",(req,res)=>{
    //쿠키값을 읽을때는 클라이언트로부터 받아와야하므로 request 객체를 통해 읽는다.
    var key1 = req.cookies.key1;
    var key2 = req.cookies.key2;
    res.writeHead(200,{'Content-Type':'text/html'});
    res.write(key1);
    res.write(key2.userid+ " " + key2.username);
    res.end();
})


app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})