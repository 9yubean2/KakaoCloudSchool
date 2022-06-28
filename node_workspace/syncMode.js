var fs = require("fs");
try
{
    var data = fs.readFileSync("./myModule1.js");
    console.log(data);
} 
catch(e)
{
    console.log(e);
}

console.log("======End======");