//함수선언문
function foo() {};

//함수 표현식
var bar = function () {};

//객체의 property로 함수가 할당
const barX = {
    x: function() {}
}

new foo(); //가능! foo 함수 객체가 내부 메소드 [[Constructor]]를 가지고 있기 때문에
new bar(); //가능!
new barX.x(); //가능!

//arrowFunction
const arrow = () => {};

//ES6 Method
const obj = {
    x() {
        
    }
}

//new arrow(); //불가능! TypeError: arrow is not a constructor
new obj.x(); //불가능! TypeError: obj.x is not a constructor

