//npm install mysql2
var mysql = require("mysql2/promise");

var pool = mysql.createPool({
    connectionLimit:10,
    host:'localhost',
    user:'root',
    password:'1407',
    database:'mydb',
    port:3306
});
/*
 create table tb_file 
(  
		id bigint not null primary key auto_increment,
        board_id bigint,
		filename varchar(256),
		wdate datetime
);
*/

//async - 함수 앞에 붙이면 promise return
//await - promise가 끝날때까지 기다린다.
//함수앞에 async가 있어야 await 사용가능 함수 안에서만 사용가능
async function saveDB(title, contents, writer, filename){
    //await를 이용해서 사실 비동기지만 동기식으로 동작하는 것 처럼 코딩
    const connection = await pool.getConnection(async conn => conn);
    //연결이 끝나야 다음 문장으로 넘어온다
    try{
        await connection.beginTransaction(); //트랜잭션(Promise) 시작
        let sql = `insert into board(title,contents,writer, wdate, hit) values ('${title}', '${contents}', '${writer}', now(), 0)`;
        let params = [title, contents, writer];
        await connection.query(sql); //쿼리가 실행이 완료할 때 까지 대기
        console.log(sql);
        console.log("=======step1=====");
        //마지막으로 추가된 데이터의 id값을 알아와야 한다.
        sql = "select last_insert_id() as boardId";
        const [rows] = await connection.query(sql);
        id = rows[0]["boardId"];
        console.log(id);
        sql = `insert into tb_file(board_id, filename, wdate) values ( '${id}','${filename}',now())`;
        console.log(sql);
        await connection .query(sql);
        await connection.commit(); //트랜잭션이 확정된다.
    }
    catch(err){
        //중간 실패시 이곳으로 이동
        await connection.rollback(); //중간에 문제가 생기면 원상복구
    }
    finally{
        connection.release(); //문제가 있던 없던 열렸던 디비는 닫아야 한다.
    }
};

saveDB("transactionControl","tester","transaction","test.txt")
.then(()=>{
    console.log("Insert Complete");
})