function search(){
    let keyword = $("#keyword").val();
    let requestURL = "http://localhost:8080/bookSearch/bSearch?keyword=" +keyword ;
    window.location.href = requestURL;
}