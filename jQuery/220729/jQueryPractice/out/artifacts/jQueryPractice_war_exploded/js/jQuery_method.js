function myFunc() {
    let result = $("option:selected").text();
    alert(result);
    //$("#result").text($("option:selected").text());
    $("#result").html(`<h2>${result}</h2>`);

}

function printRegion(){

    /*
    let result = "";

    $("input[type=checkbox]:checked + span").each(function(){
        result+=$(this).text()+" ";
    });

    $("#result").html(`<h2>${result}</h2>`);
    */

    let result = "";

    $("input[type=checkbox]:checked + span").each(function(idx, item){
        //idx: index를 의미하고 0부터 1씩 증가
        //item: 현재 수행시키려는 문서 객체를 저장(document object)
        result+=$(item).text()+" ";
    });

    $("#result").html(`<h2>${result}</h2>`);
}

function myfunc(){
    //css style 변경 -> repaint가 발생하고 결과적으로 느려짐
    // $("#MyDiv").css("color","red");
    // $("#MyDiv").css("background-color","yellow");
    // $("#MyDiv").addClass("myClass");
    //
    // alert($("input[type=text]").attr("size"));
    // $("input[type=text]").attr("size",30); //size속성의 값을 변경

    // $("#MyDiv").remove();

    let li = $("<li></li>").text('강감찬');
    $("li:eq(2)").before(li);
    //$("#list:last").append(`<li>강감찬</li>`);

}
// $(()=>{
//     $("li").click(function(){
//         alert($(this).text());
//     });
// })

// $(function(){
//     $("li").click(function(){
//         alert($(this).text());
//     });
// })

// $(document).ready(()=>{
//     $("li").click(function() {
//         alert($(this).text());
//     })
// });

window.onload=()=>{
    $("li").on("click",function() {
        //alert('소리없는 아우성');
        alert($(this).text());
    });
};

