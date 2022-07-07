var obj = new Object();
var str = 'Hello' //primitive value, type:string
'Hello'.toUpperCase()//객체화(wrapper 객체 생성 후 소멸)
var strObj = new String('홍길동');
console.log(typeof strObj);//object
console.dir(strObj); //유사배열객체