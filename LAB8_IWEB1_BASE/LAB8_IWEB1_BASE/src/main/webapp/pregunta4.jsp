<%@ page import="java.Beans.Banda" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listabandas" scope="request" type="java.util.ArrayList<java.Beans.Banda>" />
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="lista pregunta 4"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="pregunta 4"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CANCION</th>
                            <th>BANDA</th>
                            <th>Favorita S2</th>
                            <th>mi_lista</th>
                        </tr>
                    </thead>

                    <tbody>
                    <% int i = 1;
                        for (Banda banda : listabandas) { %>
                    <tr>
                        <td><%=banda.getIdlider() %>
                        </td>
                        <td><%=banda.getNombre_banda() %>
                        </td>
                        <td><%=banda.getIdBanda() %>
                        </td>
                        <td>
                            <% if (banda.getFavorito == 1){

                            %>
                            <button href="<%=request.getContextPath()%>/P4Servlet?a=favorita&id=<%=banda.getIdlider() %>"
                                    type="button" class="btn btn-warning">favorito</button>
                            <% }
                            else{%>
                            <button href="<%=request.getContextPath()%>/P4Servlet?a=no_favorita&id=<%=banda.getIdlider() %>"
                                    type="button" class="btn btn-secondary">agregar</button>
                            <% } %>

                        </td>
                        <td><a href="<%=request.getContextPath()%>/P4Servlet?a=crear" class="btn btn-success ms-auto">mi_lista</a></td>

                    </tr>
                    <% i++;
                    } %>

                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
