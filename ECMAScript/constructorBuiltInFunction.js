// console.log(Object===window.Object); //true
// console.log(Object.__proto__);

// function Person(name){
//     this.name = name;
//     this.getName = function(){
//         //instance 메소드
//         //instance마다 생성
//     }
// }
// //prototype 메소드 선언
// Person.prototype.sayHello = function(){
//     console.log(`Hi ${this.name}`);
// }

// //instance를 생성
// const me = new Person('Anne');
// me.sayHello(); //Hi Anne
// //overriding
// me.sayHello = function(){
//     console.log(`Hello~ ${this.name}`);
// }

// me.sayHello(); //Hello~ Anne

//만약 overriding이 발생하면 
//이 발생된 overriding에 의해서 숨겨진 prototype 메소드를 
//property shadowing되었다고 말해요!

function Person(name) {
    this.name = name;
}

// Person.prototype = {
//     sayHello(){
//         console.log('Hi!');
//     },
//     constructor: Person
// }
const me = new Person('Anne');
const parent = {
    sayHello(){
        console.log('Hi!');
    }
}
Object.setPrototypeOf(me, parent);
console.log(me.__proto__ === Person.prototype); //false

