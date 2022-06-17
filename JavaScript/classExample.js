class User {
    constructor(name="",age=0){
        this.name = name;
        this.age = age;
    }
    sayHi() {
        //alert(this.name);
        console.log(this.name, this.age);
    }
}
//how to use
let user = new User("John");
user.sayHi();
user.age = 12;
console.log(user.age);

user = new User();
console.log(user);