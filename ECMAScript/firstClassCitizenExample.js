//잘 만든 함수가 존재!
//그런데 이 함수의 기능을 변경(추가)
//1. 원래 있던 함수를 수정
//2. 함수를 하나 더 만들어요

// function repeat(n){
//     for(var i=0; i<n; i++){
//         console.log(i);
//     }
// }

// function repeat1(n){
//     for(var i=0; i<n; i++){
//         if (i%2 == 1){
//             console.log(i);
//         }
//     }
// }

// repeat(5);

//3. 함수를 추상화 시켜서 인자로 받아서 사용!
function repeat(n,f){
    for(var i=0; i<n; i++){
        f(i);
    }
}

let logAll = function(i){
    console.log(i);
}

let logOdd = function(i){
    if (i%2==1){
        console.log(i);
    }
}
repeat(5, logAll);
repeat(5, logOdd);