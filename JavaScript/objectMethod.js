let person ={
    "name":"A", "age":23,"phone":"010-0000-0000",
    display:function(){
        console.log(this.name, this.age, this.phone);
        //console.log(name, age, phone);--this생략불가능
    },
    //화살표 함수 사실살 사용 불가능
    /*
    displayArrow:()=>{
        console.log(this.name, this.age, this.phone);
    }*/
    setValue:function(name="B",age=25,phone=""){
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}
person.display();
person.setValue();
person.display();
person.setValue("C",22,"010-1111-1111");
person.display();

console.log(person)