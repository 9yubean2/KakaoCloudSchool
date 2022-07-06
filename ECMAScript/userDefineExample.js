//생성자 함수의 이름 식별자는 PascalCase
function Person(){

}
const person = Person();
console.log(person); //undefined

const person2 = new Person();
console.log(person2); //Person {}

var person3 = {};
console.log(person3); //{}
