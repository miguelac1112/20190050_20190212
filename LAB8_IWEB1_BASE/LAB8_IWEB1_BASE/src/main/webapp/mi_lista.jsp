<%@ page import="java.Beans.Banda" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listabandas" scope="request" type="java.util.ArrayList<java.Beans.Banda>" />
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de favortitos"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="favorita"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones</h1>
        </div>
    </div>
    <form method="POST" action="<%=request.getContextPath()%>/P4Servlet?a=guardar">
        <div class="mb-3">
            <label for="jobId" class="form-label">Job ID</label>
            <input type="text" class="form-control" name="lista_personalizada" id="lista_personalizada
">
        </div>
        <a href="<%=request.getContextPath()%>/P4Servlet" class="btn btn-danger">Regresar</a>
        <button type="submit" class="btn btn-primary">Ingresar cancion a la lista</button>
    </form>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>

