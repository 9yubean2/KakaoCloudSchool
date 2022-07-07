var foo = function() {};
console.log(foo.__proto__=== Function.prototype); //true
console.log(foo.prototype.__proto__===Object.prototype); //true
console.log(Object.prototype.__proto__);//null
console.log(foo.constructor === Function); //true