function add(x,y){
    //x,y 는 localVariable
    return x+y;
}
console.log(add(2)); 
//NaN (2 + undefined 연산 불가)
//호출은 가능

function arg(){
    //arguments [2,3,4]
    let sum = 0;
    for(var i = 0;i<arguments.length;i++){
        sum += arguments[i];
    }
    return sum;
}
console.log(arg(2)); //2
console.log(arg(2,3,4)); //9