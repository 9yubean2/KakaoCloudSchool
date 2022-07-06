var obj = {
    name:'Anne'
}
console.dir(obj); //Object

//함수 선언문 객체
function square(number){
    return number * number;
}

console.dir(square); //ƒ square(number)

// function foo(f) {
//     return f();
// }

// function bar() {
//     return 'caller:' + bar.caller;//여기 bar는 함수 이름
// }

// console.log(bar()); //caller : null
// console.log(foo(bar)); /* caller:function foo(f) x{
//                                     return f();
//                                  }*/
