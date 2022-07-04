const myArr = [1, 2, 3]; //배열

myArr.forEach(function(data, idx){
    console.log(data);
    console.log(idx);
})

console.log(score) //undefined
var score;

var x = 1;
var y = 2;

var x = 100; //var keyword로 변수의 중복선언이 가능
//가능. 정확히는 중복은 아니고 var keyword가 없는 것 처럼 동작
var y;//가능. 초기화 구문이 없으면 무시
console.log(x);//100
console.log(y);//2
