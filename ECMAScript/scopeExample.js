var x = 'global';

function foo(){
    var x = 'local';
    console.log(x);
}
foo(); //local
console.log(x); //global