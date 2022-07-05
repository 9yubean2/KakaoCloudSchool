// var obj = {
//     myName : 'Dia'
// }
// obj.myAge = 20;
// obj["!myphone"] = '010-1234-1234';
// console.log(obj); //{ myNamn: 'Dia', myAge: 20, '!myphone': '010-1234-1234' }
// delete obj["!myphone"];
// console.log(obj); //{ myName: 'Dia', myAge: 20 }

var obj ={
    10: 100,
    let: '권장되지 않음',
    myName: 'Dia',
    '!myName': 'DiaLee',//namingRule에 안 맞으면 ''로 감싸줘야함
    myName: '9yubean' //key 중복되도 되는데 위에 property가 날아감
}
console.log(obj);
//{ '10': 100, let: '권장되지 않음', myName: '9yubean', '!myName': 'DiaLee' }
console.log(obj.myAddress); //undefined : 없어도 error 아님

