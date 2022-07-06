// function foo(...rest){
//     console.log(arguments);
//     console.log(rest);
//     return rest.pop();
// }

// var result = foo(1,2,3,4,5);
// //[Arguments] { '0': 1, '1': 2, '2': 3, '3': 4, '4': 5 }
// //rest [ 1, 2, 3, 4, 5 ]
// console.log(result) //5

let foo = (...rest) => {
    console.log(arguments) //뭔 이상한게 나오넹..해당 파일에 대한 뭐시기가 나와
    console.log(`rest : ${rest}`); //rest : 1,2,3,4,5
    return rest.pop();
		
}

console.log(foo(1,2,3,4,5))//5