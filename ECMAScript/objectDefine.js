const person = {
    age : 20
};

Object.defineProperty(person,'name',{
    value : 'Dia',
    writable : false,
    enumerable : false,
    configurable : true
});

console.log(person);
console.log(Object.getOwnPropertyDescriptor(person,'name'));
person.name = 'Anne';
console.log(person);

console.log(Object.keys(person));

for(let index in person){
    console.log(`key: ${index}`);
    console.log(`person[index] value: ${person[index]}`);
}

for(let value of Object.values(person)){
    console.log(`value: ${value}`);
}

