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
        //구문의 콜백함수의 매개변수로 전달된다.
    },5000);
    //reject("데이터 수신 오류"),1000);

})
.then((value)=>{
    console.log(value);//resolve
})
.catch((error)=>{
    console.log(error);//reject(에러)
})
.finally(
    ()=>{console.log("Ending....")}//resolve던 reject던 상관없이 실행
);

console.log(promise)

