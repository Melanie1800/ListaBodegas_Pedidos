<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.BBodegas" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList <BBodegas> listaBodegas= (ArrayList<BBodegas>) request.getAttribute("listaBodegas");


%>

<html>
<head>
    <title>Lista Bodegas</title>
</head>
<body>
    <h1>Lista de Bodegas</h1>
    <table>
        <tr>
            <th> Nombre</th>
            <th>Distrito</th>
            <th>Dirección</th>
            <th>Valoración </th>
        </tr>
        <% for( BBodegas bodega:listaBodegas){%>
        <tr>
            <th><%= bodega.getNombreBodega()%></th>
            <th><%= bodega.getDistrito()%></th>
            <th><%= bodega.getDireccion()%></th>
            <th><%= bodega.getValoracion() %></th>
        </tr>

    <%}%>


    </table>

</body>
</html>
