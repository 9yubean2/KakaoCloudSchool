var express = require('express');
var router = express.Router();
var mysql = require("mysql");
var pool = mysql.createPool({
    connectionLimit:10,
    host:'localhost',
    user:'root',
    password:'1407',
    database:'mydb',
    port:3306
});
/* GET home page. */
router.get('/ss', function(req, res, next) {
  req.session["userid"]="testid";
  req.session["username"]="testname";
  res.redirect("/member/get");
});

router.get('/get', function(req, res, next) {
    res.send(`${req.session["userid"]},${req.session["usernmae"]}`);
});

router.get('/login',(req,res)=>{
    res.render('./member/member_login');
});

router.post('/login',(req,res)=>{
    var userid = req.body.userid;
    var password = req.body.password;
    console.log(userid);
    console.log(password);
    var sql = "select userid, password, email, username from member where userid = '"+ userid + "'";
    console.log(sql);
    pool.getConnection((err,connection)=>{
        connection.query(sql,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
            if(err){
                console.log(err);
            }
            console.log(rows);
            if(rows.length == 0)
                res.send({"result":"3"});//아이디 존재 안함
            else{
                if(rows[0]["password"] == password){
                    req.session['userid']=rows[0]["userid"];
                    req.session['username']=rows[0]["username"];
                    req.session['email']=rows[0]["email"];

                    res.send({"result":"1"});//success
                }
                else
                    res.send({"result":"2"});//fail
    }
            connection.release();
        })
    });
    
})

router.get("/logout",(req,res)=>{
    req.session.destroy();//세션삭제
    res.redirect("/");
});

router.get("/register",(req,res)=>{
    res.render('./member/member_register');
});

router.post("/register",(req,res)=>{
    var userid = req.body.userid;
    var password = req.body.password;
    var username = req.body.username;
    var email = req.body.email;
    var phone = req.body.phone;
    
    sql = `insert into member(userid, password, username, email, phone, wdate) values ('${userid}', '${password}', '${username}', '${email}', '${phone}',now())`;

    console.log(sql);

    pool.getConnection((err,connection)=>{
        connection.query(sql,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
            if(err){
                console.log(err);
                res.send({"result":"fail"});
            }
            res.send({"result":"success"});
            connection.release();
        })
    });
    //TODO: insert DB
    
});

router.post("/check",(req,res)=>{
    var userid = req.body.userid;
    console.log(userid);
    var sql = "select userid, password, email, username from member where userid = '"+ userid + "'";

    console.log(sql);

    pool.getConnection((err,connection)=>{
        connection.query(sql,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
            if(err){
                console.log(err);
            }
            console.log(rows);
            if(rows.length == 0)
                res.send({"result":"ok"});//사용가능한 아이디
            else
                res.send({"result":"no"}); //이미 존재하는 아이디
            
            
            connection.release();
        })
    });
    //TODO: insert DB
    
});
module.exports = router;

