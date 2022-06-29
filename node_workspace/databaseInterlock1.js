//mysql promise 기반의 mysql
//mysql - 트랜잭션 처리 시 콜백 과도하게 사용
//npm install mysql
var mysql = require("mysql");

var pool = mysql.createPool({
    connectionLimit:10,
    host:'localhost',
    user:'root',
    password:'1407',
    database:'mydb',
    port:3306
});
//Insert
var title = 'title7';
var writer = 'writer7';
var contents = 'contnents7';
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
})

/*방법2
sql = `insert into board(title, writer, contents, wdate, hit) values(?,?,?,now(),0) `;
params = ["새로운제목","작성자","새로운내용"];
pool.getConnection((err,connection)=>{
    connection.query(sql,params,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
        if(err){
            console.log(err);
        }
        connection.release();
    })
})
*/

pool.getConnection( (err,connection)=>{
    if(err){
        console.log(err);
        return;
    }
    console.log("Connection Success!!!!!");
    //sql = "select * from board";
    sql =  `select a.id, a.writer, a.title, a.contents, date_format(a.wdate, '%Y-%m-%d') as wdate from board a`;
    connection.query(sql,(err,rows)=>{
        //쿼리가 실행된 결과를 가져온다
        if(err){
            console.log(err);
            connection.release();
            return;
        }
        //rows parameter에 수행된 결과가 전달된다
        for(let row of rows){
            console.log(row);
        }
        connection.release();//연결해제
    })
});

//mysql8이상 부터
//alter user 'root'@'localhost' identified withmysql_native_password by '1234';