function Person(name){
    this.name = name;
    //instance method
    this.callme= function(){
        console.log('Hello instance method');
    };
}

//prototype method
Person.prototype.sayHello = function(){
    console.log('Hello prototype method');
}

//static method
//Person  생성자 함수에 property로 등록
//따라서 인스턴스 객체는 staticmethod 사용 불가
Person.staticMethod = function(){
    console.log('Hello static method');
}
const person = new Person('Ann');


