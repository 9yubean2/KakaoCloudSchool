const express = require("express");
const fs = require("fs");
const ejs = require("ejs");
var app = express();
var router = express.Router();

router.get("/",(req,res)=>{
    res.redirect("/board/list"); //다른 url로 redirect
});

router.get("/list",(req,res)=>{
    fs.readFile("./view/board_list.ejs","utf-8",(error,data)=>{
        if (error){
            console.log("file not found");
            res.send("<h1>file not found</h1>");
            return
        }
        res.send(ejs.render(data));
    })
});

router.get("/view/:name/:age/:mobile",(req,res,next)=>{
    fs.readFile("./view/board_view.ejs","utf-8",(error,data)=>{
        //res.statusCode=200;
        //res.setHeader("Content-type","text/html");
        //=======44line에 end로 하면 필요!=========
        
        if (error){
            console.log("file not found");
            res.send("<h1>file not found</h1>");
            return
        }
        res.send(ejs.render(data,
            {name:req.params.name,
            age:req.params.age,
            mobile:req.params.mobile}
        ));
    })
});



module.exports = router