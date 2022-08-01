<%@ page import="member.vo.Member" %>
<%@ page import="board.vo.Board" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- http://localhost:8080/bookSearch/book/bookSearch.html -->
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/dashboard/">
    <link href="/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

    <!-- BootStrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <!-- jQuery CDN-->
    <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
    <script src="./js/bookSearch.js"></script>
</head>
<style>
    .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
    }
</style>

<link href="./css/dashboard.css" rel="stylesheet">
</head>
<body>
<%
//    request.setCharacterEncoding("UTF-8");
//    Member result = (Member) request.getAttribute("loginUser");
//    String id = result.getMemberId();
//
//    ArrayList<Board> boardList = (ArrayList<Board>) request.getAttribute("boardList");
%>

<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
            <span class="fs-4">New Contents</span>
        </a>
    </header>
    <form action="/board/write" method="post">
        <div class="mb-3 mt-3">
            <label for="title" class="form-label">Title:</label>
            <input type="title" class="form-control" id="title" placeholder="Enter title" name="title">

        </div>

        <div class="mb-3">
            <label for="contents">Contents:</label>
            <textarea class="form-control" rows="5" id="contents" name="contents" placeholder="Enter contents"></textarea>
        </div>
        <div class="mb-3">
            <input type="submit" value="write" class="btn btn-success"/>
        </div>
    </form>

</div>


</body>
</html>