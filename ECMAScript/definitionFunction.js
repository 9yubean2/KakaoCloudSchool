function add(x,y) {
    return x+y;
}

var inst = new add();
console.log(inst); //add {}

function createUser(name, role){
    return {name,role};
}

var crt = new createUser();
console.log(crt); //{ name: undefined, role: undefined }


//생성자함수
function Circle(radius){
    this.radius = radius;
    this.getDiameter = function() {
        return 2 * this.radius
    }
}

const circle = Circle(5);
console.log(radius); //5 //일반 함수에서 this => window를 가리키니까 radius찾을 수 있음
console.log(circle); //undefined //그냥 일반 함수인데 return 값이 없으니까..