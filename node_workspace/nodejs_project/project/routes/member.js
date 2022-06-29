var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/ss', function(req, res, next) {
  req.session["userid"]="testid";
  req.session["username"]="testname";
  res.redirect("/member/get");
});

router.get('/get', function(req, res, next) {
    res.send(`${req.session["userid"]},${req.session["usernmae"]}`);
  });

module.exports = router;

