let x = 1;
let y = 2;
const obj = {x,y}; //확장표현방식
console.log(obj);//{ x: 1, y: 2 }

// let myObj = {
//     name : 'Dia',
//     printName : function(){
//         console.log(this.name);
//     }
// };

let myObj = {
    name : 'Dia',
    printName(){
        console.log(this.name); //얘만 method라고 부름
    }
};
myObj.printName(); //Dia
//console.log(myObj); //{ name: 'Dia', printName: [Function: printName] }
