<%-- 
    Document   : index
    Created on : 04/06/2015, 12:19:45 PM
    Author     : anthonywainer
--%>


<%@page import="distrirmi.Interface"%>
<%@page import="java.rmi.Naming"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mozanderos en Acción</h1>
        <%
        Interface i= (Interface)Naming.lookup("//localhost:9050/servi1");
        
        out.print(i.saludo("Hola guiguito", "ter dejo resultados de suma, resta y multiplición: <br>"));
        out.print(i.suma(789.25,896.32));
        out.print("<br>");
        out.print(i.resta(789.25,896.32));
        out.print("<br>");
        out.print(i.multiplicacion(4.2,2.0));
        out.print("<br>");
        out.print(i.division(4.2,2.1));

        
        %>
    </body>
</html>
