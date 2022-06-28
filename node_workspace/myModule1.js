//방법1
function abs(number){
    if(number > 0)
        return number;
    else
        return -number;
}

//외부로 내보낼 때 export.키 = 함수명
exports.abs = abs;

//방법2
exports.isLeap = function(s){
    if(s%4==0 && s%100!=0||s%400==0)
        return true;
    else
        return false;
}

//외부에서 접근 불가능
function hello() {
    return "Hello nodejs";
}