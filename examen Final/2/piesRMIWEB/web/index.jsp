<%-- 
    Document   : index
    Created on : 04/06/2015, 12:19:45 PM
    Author     : anthonywainer
--%>


<%@page import="practicarmi.Interface"%>
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
        <h2>Convertidor de Metros a Pies</h2>
<form method="post" action="index.jsp">
Ingresar metros:  <br><br>
<input type="number" name="a" size="20" placeholder="ingrese dato a convertir:"><br><br>
<input type="submit" value="Convertir">
<br><br>



</form>        
        <%
        String a = "0";
        if (request.getMethod() == "POST") {
            a = request.getParameter("a");
         }
   
        
        Interface i= (Interface)Naming.lookup("//localhost:9050/servi1");
        out.print("<h2> RESPUESTA EN PIES: </h2> ");
        out.print("METRO: "+ a + " convertido a PIES =  ");
        out.print(i.pies(Integer.parseInt(a)));


        
        %>
    </body>
</html>
