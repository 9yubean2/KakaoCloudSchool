// let num = 0 ;
// const increase = function() {
//     return ++num;
// }


// const increase = function() {
//     let num = 0 ;
//     return ++num;
// }



const increase = (function (){
    let num = 0;
    return function(){
        return ++num;
    }
}());


console.log(increase());//1
console.log(increase());//2
console.log(increase());//3

const counter = (function(){
    let num = 0;
    return {
        increase(){
            return ++num;
        },
        decrease(){
            return --num;
        }
    }
}());
console.log(counter.increase());//1
console.log(counter.increase());//2
console.log(counter.increase());//3

console.log(counter.decrease());//2
console.log(counter.decrease());//1
console.log(counter.decrease());//0