package Servlets;

import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CancionServlet", value = "/listaCanciones")
public class CancionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CancionDao cancionDao = new CancionDao();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CancionDao cancionDao = new CancionDao();

        switch (action){
            case "buscar" -> {
                String textoBuscar = request.getParameter("textoBuscar");
                request.setAttribute("textoBuscar",textoBuscar);
                request.setAttribute("listaCanciones", cancionDao.CancionesPorBanda(textoBuscar));

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobs/lista.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
