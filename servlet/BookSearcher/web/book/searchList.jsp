<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="book.vo.Book" %>

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
    <script src="./book/js/bookSearch.js"></script>
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

<link href="./book/css/dashboard.css" rel="stylesheet">
</head>

<%
    ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("bookList");
%>
<body>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">USER NAME</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <input class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="Search" aria-label="Search" name="keyword" id="keyword">
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" id="btnSearch" href="javascript:search()">SEARCH</a>
        </div>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3 sidebar-sticky">
                <ul class="nav flex-column">
                </ul>
                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
                    <a class="link-secondary" href="#" aria-label="Add a new report">
                        <span data-feather="plus-circle" class="align-text-bottom"></span>
                    </a>
                </h6>
                <ul class="nav flex-column mb-2">
                </ul>
            </div>
        </nav>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            </div>
            <h2>Search Result</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">ISBN</th>
                        <th scope="col">Cover</th>
                        <th scope="col">Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Price</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>

    <%
        for(Book book:bookList){
            //Book book = bookList.get(i);
    %>
    <tr>

        <td><%= book.getBisbn() %></td>
        <td><img src="<%= book.getBimgurl() %>"/></td>
        <td><%=book.getBtitle() %></td>
        <td><%= book.getBauthor() %></td>
        <td><%= book.getBprice() %></td>
        <td>
            <input type="submit" value="DELETE" onclick="location.href='<%=request.getContextPath() %>/bDelete?bisbn=<%=book.getBisbn()%>'">
        </td>

    </tr>
    <%} %>
</table>
            </div>
        </main>
    </div>
</div>
</body>
</html>

