let promise = new Promise( function(resolve, reject){
    let data = {"name":"A", "age":23,"phone":"010-0000-0000"};
    
    //1초후에 작업이 성공했음을 알리는 명령어를 보낸다
    //setTimeout(()=>resolve(10),1000);
    //setTimeout(()=>resolve(data),1000);
    setTimeout(()=>{
        s=0;
        for (i=1;i<=100;i++){
            s+=i;
        }
        resolve(s);

    },5000);
    //reject("데이터 수신 오류"),1000);

})
.then((value)=>{
    console.log(value);
})
.catch((error)=>{
    console.log(error);
})
.finally(
    ()=>{console.log("Ending....")}
);

console.log(promise)

