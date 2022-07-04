// var x = 1; //전역 변수

// if (true){
//     var x = 100; //같은 레벨의 변수
// }

// console.log(x);

// var i = 100;
// for (var i = 0; i<5;i++){
//     console.log(i);
// }
// console.log(i);


// var  x = 1;
// function myFunc() {
//     var x = 100; //scope가 다르니까 위에 x랑 다른 x
//     console.log(x);
// }
// myFunc(); //100
// console.log(x); //1

// var  x = 1;
// function myFunc() {
//     console.log(x);//undefined
//     var x = 100; 
// }
// myFunc(); //undefined
// console.log(x); //1

// let x = 1;
// let x = 100;

// let score = 100;
// {
//     let score = 10;
//     let myVar = 1;
// }

// console.log(myVar); //ReferenceError: myVar is not defined

// console.log(myVar);
// let myVar = 100; //Error: Cannot access 'myVar' before initialization

let myVar2 = 1; //global variable
{
    console.log(myVar2); //Cannot access 'myVar2' before initialization
    let myVar2 = 100;

}