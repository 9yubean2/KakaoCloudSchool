// let myVar = 1.0;
// console.log(myVar === 1); //true
// console.log(3/2); //1.5

// let str = '이것은\n 소리없는\n 아우성';
// let backtickStr = `이것은
// 소리없는
// 아우성`;
// console.log(str); 
// //이것은
// //소리없는
// //아우성

// console.log(backtickStr);
// // 이것은
// // 소리없는
// // 아우성
// let name = 'Anne';
// console.log(`I'm ${name}.`); //I'm Anne.

// const mySymbol = Symbol();
// const mySymbol1 = Symbol('소리없는 아우성');
// const mySymbol2 = Symbol('소리없는 아우성'); //인자는 symbol값에 영향을 주지 않음
// console.log("=================="); //symbol

// console.log(typeof mySymbol); //symbol
// console.log(mySymbol); //Symbol() 알 수가 없다..!!
// console.log(mySymbol1===mySymbol2);//false
// console.log(mySymbol1.description);//소리없는 아우성

// if(mySymbol1) {
//     //존재 여부에 대해 true/false 판별은 가능
//     console.log("Exist!!");//Exist!!
// }

// const s1 = Symbol.for('mySymbol');
// const s2 = Symbol.for('mySymbol');
// console.log(s1===s2); //true
// console.log(Symbol.keyFor(s2)); //mySymbol

// const Direction = {
//     //key:value
//     'UP':Symbol(),
//     'Down':Symbol(),
//     'Left':Symbol(),
//     'Right':Symbol()
// }
// let myDirection = Direction.Down;

// if (myDirection == Direction.Down){
//     console.log('Down'); //Down
// }

////////////////////////Type Conversion(형변환)
//console.log(1+2); //3
// console.log(1+'2'); //12 //묵시적 형변환
// console.log(1+true); //2 //묵시적 형변환
// console.log(1+null); //1 //묵시적 형변환 null = 0
// console.log(1+undefined); //NaN

// console.log(typeof null);//object


console.log(typeof String(1)); //string
console.log(typeof String(NaN)); //string

//primitive -> Object?
//해당값을 가지는 object를 임시로 만듦
console.log(typeof (1).toString()); //string









