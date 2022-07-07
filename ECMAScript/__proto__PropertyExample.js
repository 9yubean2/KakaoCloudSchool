// const obj = {}; //객체 literal로 만든 객체
// const parent ={x:1};
// obj.__proto__ = parent; //obj가 parent를 상속받게 함
// console.log(obj.x);//1

const obj = {}; //객체 literal로 만든 객체
console.log(obj.__proto__.constructor.name); //Object