// function add(x,y){
//     return x+y;
// }
// //console.log(add(3,5));

// // var func = function sub(x,y){
// //     return x-y;
// // }
// //어차피 함수 이름 사용 못하니까 이름 없이 사용(annoymous function)
// var func = function (x,y){
//     return x-y;
// }
// //console.log(sub(10,2)); //error : not defined
// console.log(func(10,2));

// var multiple = new Function('x','y','return x*y');

// var div = (x,y) => x/y;
// console.log(div(10,2));

// //함수 선언문
// //runtime이전에 foo라는 변수가 만들어지고 
// //변수랑 다르게 undefined가 아니라 빈 객체가 만들어져서 assign됨
// function foo() {
//     console.log('Function foo');
// }
// foo();//식별자가지고 호출

// //함수 표현식
// (function bar() {
//     console.log('Function bar');
// })
// //bar(); //error : not defined


foo(); //가능
add(); //불가능 add is not a function
//선언문 
function foo() {
    console.log('Function foo');
}
//표현식
var add = function bar(x,y){
    console.log('Function bar');
}

