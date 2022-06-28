var express = require('express');
var router = express.Router();

var boardData = [
    {id:0, title:"title1", writer:"writer1", contents:"contents1", wdate:"2022-06-28"},
    {id:1, title:"title2", writer:"writer2", contents:"contents2", wdate:"2022-06-28"},
    {id:2, title:"title3", writer:"writer3", contents:"contents3", wdate:"2022-06-28"},
    {id:3, title:"title4", writer:"writer4", contents:"contents4", wdate:"2022-06-28"},
    {id:4, title:"title5", writer:"writer5", contents:"contents5", wdate:"2022-06-28"}
]
/* GET home page. */
router.get('/', function(req, res, next) {
    //ejs파일의 경로가 views로 확정, 확장자 ejs로 확정 => 생략
    //res.render('index', { title: 'Express' });
    //res.render('list', { title: 'Board' });
    res.redirect("/board/list");
});


router.get("/list",(req,res)=>{
    //res.send(boardData);
    res.render("./board/board_list.ejs",{boardList:boardData});
});

router.get("/view/:id",(req,res)=>{
    //res.send(boardData[parseInt(req.params["id"])]);

    var id = parseInt(req.params.id);
    res.render("./board/board_view.ejs",{boardItem:boardData[id]});
});

router.get("/write",(req,res)=>{
    //res.send(boardData);
    res.render("./board/board_write.ejs");
});

router.post("/save",(req,res)=>{
    var title = req.body.title;
    var writer = req.body.writer;
    var contents = req.body.contents;
    var id = boardData.length;
    var wdate = "2022-06-28";

    boardData.push({id:id,title:title,writer:writer,contents:contents,wdate:wdate})
    res.redirect("/board/list");
})

module.exports = router;
