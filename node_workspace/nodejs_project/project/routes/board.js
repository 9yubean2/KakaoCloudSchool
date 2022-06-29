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
router.get('/', function(req, res, next) {
  
  //TODO select table
  pool.getConnection( (err,connection)=>{
    if(err){
        console.log(err);
        return;
    }
    console.log("Connection Success!!!!!");
    //sql = "select * from board";
    sql =  `select a.id, a.writer, a.title, a.contents, a.hit, date_format(a.wdate, '%Y-%m-%d') as wdate from board a`;
    connection.query(sql,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
        if(err){
            console.log(err);
            connection.release();
            return;
        }
        // //rows parameter에 수행된 결과가 전달된다
        // for(let row of rows){
        //     console.log(row);
        // }
        res.render('./board/board_list',{boardList:rows});
        connection.release();//연결해제
    })
    });
    
});

router.get("/view/:id",(req,res)=>{
    //res.send(boardData[parseInt(req.params["id"])]);
    var id = parseInt(req.params.id);
    console.log(id);
    sql =  `select a.id, a.writer, a.title, a.contents, a.hit, date_format(a.wdate, '%Y-%m-%d') as wdate from board a where id = ${id}`;
    pool.getConnection( (err,connection)=>{
        if(err){
            console.log(err);
            return;
        }
        console.log("Connection Success!!!!!");
        //sql = "select * from board";
        
        connection.query(sql,(err,rows)=>{
            //쿼리가 실행된 결과를 가져온다
            if(err){
                console.log(err);
                connection.release();
                return;
            }
            console.log(rows);
            res.render('./board/board_view',{boardItem:rows});
            connection.release();//연결해제
        })
        });

    //res.render("./board/board_view.ejs",{boardItem:boardData[id]});
});



router.get('/write', function(req, res, next) {
    res.render('./board/board_write');
});

router.post("/save",(req,res)=>{
    var title = req.body.title;
    var writer = req.body.writer;
    var contents = req.body.contents;
    
    sql = `insert into board(title, writer, contents, wdate, hit) values('${title}','${writer}','${contents}',now(),0) `;

    console.log(sql);

    pool.getConnection((err,connection)=>{
        connection.query(sql,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
            if(err){
                console.log(err);
            }
            connection.release();
        })
    });
    //TODO: insert DB
    res.redirect("/board");
})
module.exports = router;

// async function selectDB(sql, params)
// {
//     let promise = new Promise((resolve,reject)=>{
//         pool.getConnection((err,conn)=>{
//             conn.query(sql,params,(err,rows)=>{
//                 if(err)
//                     reject(err);
//                 else
//                     resolve(rows);
//                 conn.release();
//             });
//         });
//     });
// }

// async function insertDB(sql, params)
// {
//     let promise = new Promise((resolve,reject)=>{
//         pool.getConnection((err,conn)=>{
//             conn.query(sql,params,(err,rows)=>{
//                 if(err)
//                     reject(err);
//                 else
//                     resolve(rows);
//                 conn.release();
//             });
//         });
//     });
// }