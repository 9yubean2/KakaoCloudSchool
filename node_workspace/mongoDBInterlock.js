var mongoose = require("mongoose")

var promise = mongoose.connect('mongodb://127.0.0.1/mydb');
var db = mongoose.connection;

db.once('error',console.error.bind(console,'connection error:'));
db.once('open',()=>{
    console.log("Connection Success!!!!");
    //doRead(); //비동기라서 콜백함수에서 호출해야한다.
    doView("홍길동");
});

function doRead(){
    db.collection("person").find({}).toArray((err,results)=>{
        if(err) throw err;
        console.log(results);
    })
}

function doView(name){
    console.log("Find~~");
    db.collection("person").findOne({name:name},(err,results)=>{
        if(err) throw err;
        console.log(results);
    })
}
