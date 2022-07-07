// var obj = {}//전역 코드

// function myFunc() {
//     console.log('Hello');//함수 코드
//     //nested function(inner function)
//     function sayHello(){//식별자 찾는거 까지 함수코드
//         console.log('하이')//sayHello의 함수코드
//     }
// }

// myFunc();//전역 코드

// function foo(){
//     const x = 1;
//     const y = 2;
//     //closure가 아니에요
//     function bar () {
//         const z = 3;
//         console.log(z);
//     }
//     return bar;
// }
// const bar = foo();
// bar();

function foo(){
    const x = 1;
    const y = 2;
    //closure가 아니에요
    function bar () {
        console.log(x);
    }
    bar();
}
const bar = foo();
bar();