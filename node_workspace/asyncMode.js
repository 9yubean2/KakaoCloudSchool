var fs = require("fs");

//async
fs.readFileSync("./myModule1.js","utf-8",(error,data)=>{
    if(error)
    {
        console.log(error);
        return;
    }    
    console.log(data);
});
    
console.log("======End======");