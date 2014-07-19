<%-- 
    Document   : index
    Created on : 2014/02/11, 10:01:34
    Author     : Eiichi Tanaka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var="path" value="client" />

<script type="text/javascript" src="../jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="getAllBooks.js"></script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JAX-RS Client Menu</title>
    </head>
    <body>
        <h1>JAX-RS(Jersey) 認証サンプル</h1>
        <table border="1">
            <th>No</th>
            <th>タイトル</th>
            <tr>
                <td>1</td>
                <td>
                    <form method="GET">
                        <input type="button" id="getbooks" value="全件検索" />
                    </form>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>
                    <input type="text" id="isbn" />
                    <input type="button" id="getbook" value="リソースキー(ISBN)指定検索" />
                </td>
            </tr>
            <%--            
            <tr>
                <td>3</td>
                <td>
                    <a href="<%= request.getContextPath() %>/${path}/createNewBook.html">
                    本の登録(AJAX-JSON)</a>
                </td>
            </tr>
            <tr>
                <td>4</td>
                <td>
                    <a href="<%= request.getContextPath() %>/${path}/crateNewBookByForm503.jsp">
                    本の登録(POSTボディ-application/x-www-form-urlencoded)</a>
                </td>
            </tr>
            <tr>
                <td>5</td>
                <td>
                    <a href="<%= request.getContextPath() %>/${path}/updateBook503.jsp">
                    本の更新</a>
                </td>
            </tr>
            <tr>
                <td>6</td>
                <td>
                    <a href="<%= request.getContextPath() %>/${path}/deleteBook503.jsp">
                    本の削除</a>
                </td>
            </tr>
            --%>
        </table>
        <div id="result"></div>
    </body>
</html>