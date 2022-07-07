//'use strict'
// function foo(){
//     x = 10; 
// }
// foo();
// console.log(x); //ReferenceError: x is not defined

// (function(){
//     //non-strict mode
//     var let = 10;
//     //innerFUnction(nestedFunction)
//     function foo(){
//         'use strict';
//         let = 20; 
//         //SyntaxError: Unexpected strict mode reserved word
//     }
//     foo();
// }());

'use strict';
var obj = {};
delete obj; //SyntaxError: Delete of an unqualified identifier 