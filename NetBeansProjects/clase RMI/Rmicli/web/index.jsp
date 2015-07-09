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
<form method="post" action="index.jsp">
Ingrese datos a calcular:  <br><br>
<label>a:</label>
<input type="text" name="a" size="20" placeholder="ingrese a:"><br><br>
<label>b:</label>
<input type="text" name="b" size="20" placeholder="ingrese b:"><br><br>
<input type="submit" value="enviar datos">
<br><br>



</form>        
        <%
        String a = "0";
        String b = "0";
        if (request.getMethod() == "POST") {
                 a = request.getParameter("a");
                 b = request.getParameter("b");
         }
   
        
        Interface i= (Interface)Naming.lookup("//localhost:9050/servi1");
        out.print(i.saludo("<h2>", " te dejo resultados de suma, resta, multiplición y división: </h2> "));
        out.print("1. suma: "+ a +" + " + b +" =  ");
        out.print(i.suma(Double.parseDouble(a),Double.parseDouble(b)));
        out.print("<br> 2. Resta: "+ a +" - " + b +" =  ");
        out.print(i.resta(Double.parseDouble(a),Double.parseDouble(b)));
        out.print("<br> 3. Multiplicación: "+ a +" * " + b +" =  ");
        out.print(i.multiplicacion(Double.parseDouble(a),Double.parseDouble(b)));
        out.print("<br> 4. División: "+ a +" / " + b +" =  ");
        out.print(i.division(Double.parseDouble(a),Double.parseDouble(b)));

        
        %>
    </body>
</html>
