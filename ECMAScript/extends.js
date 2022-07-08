// //상위 super class
// class foo {

// }

// //하위 sub class
// class bar extends foo {

// }

// const obj = new bar();

//superclass
class Animal {
    constructor(age,weight){
        this.age = age;
        this.weight = weight;
    }
    eat(){
        return 'eating';
    }
    movw(){
        return 'moving';
    }
}

class Bird extends Animal{
    constructor(age,weight,kk) {
        //상위 클래스의 constructor
        super(age,weight) //!=super keyword //여기서 객체 생성
        this.kk = kk;
    }
    fly(){
        return 'flying';
    }
}

const bird = new Bird(10,20,100);
console.log(bird);//Bird { age: 10, weight: 20, kk: 100 }
console.log(bird instanceof Bird); //true : A instanceof B = A가 B의 인스턴스?
console.log(bird instanceof Animal); //true

function Base(name){
    this.name = name;
}
class Derived extends Base {

}