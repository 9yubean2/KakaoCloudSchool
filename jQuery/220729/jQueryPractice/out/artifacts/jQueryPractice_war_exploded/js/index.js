function myFunc(){
    //alert("button is Tapped!");
    //jQuery
    //1.내가 원하는 Element를 찾아서 jQuery객체로 변환
    //html element를 referencing하는 jQuery객체를 생성
    //selector 이용

    //1.  universial selector(전체 선택자)
    //$("*").css("color","red");

    //2. tag selector
    //alert($("div").text());


    //3. id selector
    //$("#myLi").remove();

    //4.class selector
    //$(".haha").css("background-color","yellow");
    //block level element vs. inline element

    //5. 구조 선택자
    //$("ul.myclass > li").css("color","red");
    //$("div li").css("color","blue");
    //기호로  + 바로 다음에 나오는 형제 ~ 다음에 형제 싹다
    // $("#seoul + li").css("color","red");
    // $("#seoul ~ li").css("color","yellow");
    // $("ul.myclass > li:first + li").css("color","purple");
    // $("ul.myclass > li:nth-child(3)").remove();

    //6. 속성 선택자
    //alert($("[size=30]").val());
    $("[size=30]").val("ChangeValue");
}