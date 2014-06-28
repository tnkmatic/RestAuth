<%-- 
    Document   : login
    Created on : 2014/03/29, 12:14:24
    Author     : Eiichi Tanaka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJB Security Sample (P299)</title>
    </head>
    <body>
        <h1>ログインページ</h1>
        
        <form method="post" action="j_security_check">
            <table border="0">
                <tr>
                    <th align="right">ユーザ名：</th>
                    <td><input type="text" name="j_username" size="15" /></td>
                </tr>
                <tr>
                    <th align="right">パスワード：</th>
                    <td><input type="password" name="j_password" size="15" /></td>
                </tr>
                <tr>
                    <td rowspan="2">
                        <input type="submit" value="ログイン" />
                        <input type="reset"  value="取り消し" />
                    </td>
                    
                </tr>
            </table>
            
        </form>
        
    </body>
</html>
