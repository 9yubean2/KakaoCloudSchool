<%@ page import="board.vo.Board" %>
<%@ page import="board.vo.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<%
    request.setCharacterEncoding("UTF-8");

    Board result = (Board)request.getAttribute("boardView");
    ArrayList<Comment> commentList = (ArrayList<Comment>) request.getAttribute("commentList");

    int id = result.getBoardId();

    String title = result.getBoardTitle();
    String writer = result.getMemberId();
    int likes = result.getLikes();
    int hits = result.getHits();
    int comments = result.getCommentCount();
    String contents = result.getBoardContents();

%>
<body>
<a href="/board/board">Back</a>
<button onclick="location.href='/board/board'"></button>
<div>
    <h2><%=title%></h2>
    <h5><%=writer%></h5>
</div>

<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <h6 class="nav-link active">Likes <%= likes%></h6>
            </li>
            <li class="nav-item">
                <h6 class="nav-link active">Hits <%= hits%></h6>
            </li>
            <li class="nav-item">
                <h6 class="nav-link active">comments <%=comments%></h6>
            </li>
        </ul>
    </div>
</nav>
<p><%=contents%></p>
<h4>commmets</h4>
<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>

            <th scope="col">ID</th>
            <th scope="col">commentContents</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Comment comment:commentList){
        %>
        <tr>
            <td><%= comment.getMemberId()%></td>
            <td><%= comment.getCommentContents()%></td>
        </tr>
        <%} %>
        </tbody>
    </table>
</div>
<form action="/board/comment" method="post">
    <div class="mb-3">
        <label for="comment">Comment:</label>
        <textarea class="form-control" rows="5" id="comment" name="comment" placeholder="Enter comment"></textarea>
    </div>
    <div class="mb-3">
        <input type="hidden" value="<%=id%>" id ="boardId" name="boardId"/>
        <input type="submit" value="comment" class="btn btn-success"/>
    </div>
</form>
</body>
</html>
