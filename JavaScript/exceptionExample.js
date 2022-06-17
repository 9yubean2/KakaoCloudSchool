let json = "{badJSON}";
try{
    let user = JSON.parse(json);
    alert(user.name);
}
catch(e){
    console.log(e.message);
}
finally {
    console.log("Finally");
}