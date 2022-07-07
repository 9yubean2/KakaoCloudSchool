//객체 생성하는 방법
//객체를 생성할 때 객체의 상위 prototype 객체를 직접 지정
const obj = Object.create(null);
console.log(obj.__proto__); //undefined

//그럼 이런 경우를 위해 어떻게 하면 좋은가요?
//Object가 가지고 있는 method를 이용하는게 좋아요!
console.log(Object.getPrototypeOf(obj)); //null

//크게 상관은 없음...근데 이런 경우가 있다....정도로만 생각