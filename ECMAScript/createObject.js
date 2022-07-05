var intro = {
    'name': 'Dia',
    'printName': function myPrint(){
        console.log(`My name is ${this.name}.`);
    }
};
//obj.printName(); //My name is Dia.
console.log(typeof intro); //object