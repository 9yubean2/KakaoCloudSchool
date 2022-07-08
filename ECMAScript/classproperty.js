/* 
//객체 literal 이용해서 객체 생성
const person = {
    firstName : '길동',
    lastName : '홍',
    //get을 이용하면 반드시 return 구문이 존재해야 함
    get fullName(){
        return `${this.lastName}${this.firstName} (getter)`
    },
    
    getName : function() {
        return `${this.lastName}${this.firstName} (method)`
    },
    
    set fullName(name){
        //destructuring
        [this.lastName, this.firstName] = name.split(' ')
    }
}

console.log(person.getName()); //홍길동
console.log(person.fullName); //홍길동

//person.lastName = '김'; //직접적 접근 지양
//person.firstName = '연아'; //직접적 접근 지양
person.fullName='김 연아'; //method 내부에서 유효성검사 가능
console.log(person.fullName);//김연아
*/

class Person {
    constructor(firstName,lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    get fullName(){
        return `${this.lastName}${this.firstName}`
    }
    
    set fullName(name){
        [this.lastName, this.firstName] = name.split(' ')
    }
}
//instance
const me = new Person('길동','홍');
//get
console.log(me.fullName); //홍길동
//set
me.fullName = '김 연아';
console.log(me.fullName); //김연아
