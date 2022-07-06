//생성자함수로 사용하려고
//함수 선언문
function Person(myName) {
    //생성자함수로 만들어질 instance가 가지는
    //property를 설정
    this.myName = myName;
}
//creattionPage 
//1. built-in 객체(생성자 함수 포함) 생성
//2. 실행환경에 맞는 global 객체 생성

//executionPage : window라는 전역 객체의 property에 Person이라는 변수가 추가되는데 
//이 Person이라는 변수는 Person이라는 함수를 reference하고 있음
//let,const(global execution context에 붙음) 제외한 var나 다른 것들은 전부 window 전역객체에 붙음

//Person이라는 변수에 함수객체가 담기는데 Person함수 객체에는
//property 6개 가지는데 (arguments,caller,name ...)
//이 중에 [[Prototype]], prototype이 있어
//이중에 prototype은 Person.prototype이 같이 동시에 생기는데
//이 걸 prototype (객체)라고 하고 이 안에도 내부슬롯  [[Prototype]]이게 있어

const person = new Person('Anne');
//이렇게 하면 new keyword를 통해 새로운 instance(객체)가 생기는데
//이 instance의 property에 name이 생기고 Anne이라는 값이 들어감
//이 instance에도 [[Prototype]]가 있어
//이 instance의 property인 [[Prototype]]은 
//만들어진 생성자함수의 prototype이 가리키는 Person.prototype이걸 가리킨다.

//Prototype chain : 객체의 property를 찾는 메커니즘

function Circle(radius) {
    this.radius = radius;
    this.getDiameter=function(){
        return 2 * this.raadius;
    }
}
const circle1 = new Circle(5);
const circle2 = new Circle(10);

//메모리 주소가 같니?
console.log(circle1.getDiameter === circle2.getDiameter)//false
//같은 함순데...다른 주소에 저장해....메모리 낭비야....
//같이 공유하려면 prototype 객체에 저장하면 Prototype chain에 의해 접근할 수 있어
//그렇게 하면 내려 받아 쓸 수 있는데 이걸 "프로토타입 기반의 상속"이라고 말하지
function Circle2(radius) {
    this.radius = radius;
    Circle2.prototype.getDiameter =function(){
        return 2 * this.raadius;
    }
    Circle2.prototype.name = 'Circle2 inheritance';
}
const circle2_1 = new Circle2(5);
const circle2_2 = new Circle2(10);
console.log(circle2_1.getDiameter === circle2_2.getDiameter);//true
console.log(circle2_1.name ,circle2_2.name); //Circle inheritance Circle inheritance

//circle2_1.name = '바보';//이건 circle2_1에 property 추가하는거지 기존 상속받는 name의 value를 바꾸는게 아니라

Circle2.prototype.name='Circle2 상속받는 변수 바꾸기';
console.log(circle2_1.name ,circle2_2.name); //Circle2 상속받는 변수 바꾸기 Circle2 상속받는 변수 바꾸기

circle2_1.__proto__.name = '__proto__로 접근하기~~';
console.log(circle2_1.name ,circle2_2.name);//__proto__로 접근하기~~ __proto__로 접근하기~~