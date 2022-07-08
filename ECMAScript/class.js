//보통은 class name을 가지고 동작하지만 
//JS에서는 해당 class객체를 reference하는 Person이라는 식별자로 동작
//class define
class Person {
    //constructor
    constructor(name){
        //instance의 초기화
        //instance의 property를 설정
        this.name = name;
    }
    //prototype method
    sayHello() {
        console.log("Hello prototype");
    }
    //static method
    static sayHi(){
        console.log("Hello static");
    }
}

const me = new Person('Dia');


// //많이 쓰이진 않아요^^...
// // -익명 class 표현식
// //class는 함수 즉 일급 객체이기 때문에 변수에 assign해서 사용 가능(익명함수와 유사)
// const Person  = class {}

// // -기명 class 표현식
// const Person2 = class MyClass { };