const express = require("express");
var app = express();
app.use(express.urlencoded({extended:true}));

//외부 모듈을 불러온다.
var board = require("./routes/board");

app.use('/board',board); //http://127.0.0.1:3000/board
app.use((req,res)=>{
    res.status(404).send(`<h1>ERROR</h1>`);
});

app.listen(3000,()=>{
    console.log("server start at http://127.0.0.1:3000");
})