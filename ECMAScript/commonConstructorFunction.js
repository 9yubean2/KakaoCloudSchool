function Person() {
    //this
    //this라는 keyword는 생성자 함수일 경우도 있고
    //일반 함수인 경우에도 있어요!
    //생성자 함수에서의 this는 추후 만들어질 instance를 가리키는 reference
    //일반함수에서의 this는 window를 가리킴
    console.log(this);
}

Person(); //Object [global] //window
new Person(); //Person {} //생성된 instance


function Person(name){
    this.name = name;
    this.getName = function(){
        return `I'm ${this.name}`;
    }
    //return {}; 생성자로 하려면 return 구문 없어야해요
    return 100;
}
const person1 = new Person('Lee');
const person2 = new Person('Dia');
console.log(person1.getName());//I'm Lee
console.log(person2.getName());//I'm Dia


// function foo() { }
// foo.myName = 'Anne';
// foo.getName = function(){
//     console.log(this);
// }
// console.log(foo)

// foo(); //함수호출
// new foo(); //생성자함수 호출
// foo.getName(); //method 호출