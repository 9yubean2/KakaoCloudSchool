// function Base1(name){
//     this.name = name;
// }

// class Base2 {}

// let tmp = true;

// class Derived extends (tmp ? Base1 : Base2){

// }


// class Base{
//     constructor(name){
//         this.name = name;
//     }
//     sayHello(){
//         return 'Hello!';
//     }
// }

// class Derived extends Base {
//     sayHello(){
//         return 'Hello subclass!';
//     }
// }
// const derived = new Derived('홍길동');
// console.log(derived.sayHello()); //Hello subclass!

class Base{
    constructor(name){
        this.name = name;
    }
    sayHello(){
        return 'Hello!';
    }
}

class Derived extends Base {
    sayHello(){
        return super.sayHello() + this.name;
    }
}
const derived = new Derived('홍길동');
console.log(derived.sayHello()); //Hello!홍길동