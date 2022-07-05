var x = 1;
function foo(){
    var x = 10; //local
    bar();
}

function bar() {
    console.log(x);
}

foo();