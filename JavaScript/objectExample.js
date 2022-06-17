let person = {"name":"A","age":23,"phone":"010-0000-0000"};
console.log(Object.entries(person));
for(const [key, value] of Object.entries(person)){
    console.log(`${key}:${value}`);
};
let students = [
    {"name":"A","kor":75,"eng":80,"math":100},
    {"name":"B","kor":84,"eng":30,"math":80},
    {"name":"C","kor":95,"eng":60,"math":70},
    {"name":"D","kor":50,"eng":100,"math":90}
];

console.log(`객체의 개수 : ${students.length}`);
console.log(students[0].name);
console.log(students[0]["name"]);
console.log(students[0]["kor"]);

//데이터 추가하기
students.push({"name":"D","kor":77});

for(i in students){
    console.log(students[i].name,students[i]["kor"],students[i].eng);
};

for(item of students){
    console.log(item.name,item.kor,item["eng"],item["math"]);
};

let myProduct = {
    "product_name":"laptop",
    "product_info":[
        {"company":"A","model":"modelAAA","price":2000000},
        {"company":"B","model":"modelBBB","price":1800000},
        {"company":"C","model":"modelCCC","price":2500000}
    ]
};
console.log(myProduct.product_name);
for(item of myProduct.product_info) {
    console.log(item.company, item.model, item.price);
}

let s = JSON.stringify(person); //JSON -> String으로 전환
console.log(s);
console.log(s.name); //result: undefined
console.log(person);
let person2 = JSON.parse(s); //String -> JSON으로 전환
console.log(person2.name);