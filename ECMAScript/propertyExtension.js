//'use strict'; //유연성 감소 정형성 상승
const person = {
    name : 'Lee'
};

//객체가 확장이 가능한지  (property 추가가능?)
console.log( Object.isExtensible(person)); //true
person.age = 25;
console.log(person); //{ name: 'Lee', age: 25 }

Object.preventExtensions(person); //확장 금지

person.address = 'Seoul'; //TypeError: Cannot add property address, object is not extensible
console.log(person);//{ name: 'Lee', age: 25 }

Object.seal(person); //삭제까지 금지

delete person.name;
console.log(person);//{ name: 'Lee', age: 25 }

Object.freeze(person); //변경까지 금지

person.name = 'dia';
console.log(person);//{ name: 'Lee', age: 25 }
