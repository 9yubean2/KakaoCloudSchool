var x = 100; //global variable
var y = 200; //global variable
//outer function
function outer(){
    let x = 0;//function-level scope(local variable)
    //inner function
    function inner() {
        let x = 10;//function-level scope(local variable)
        console.log(y);//200
        //scope chain: local -> global 까지 모든 scope는 chain으로 연결되어있음
        // global variable 사용 지양해야하는 이유:
        //scope chain의 최상단에 위치하기 때문에 탐색 속도가 느려질 수 밖에 없다.
    }
}