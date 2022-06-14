package Servlets;
import Beans.Banda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FavoritaServlet",urlPatterns = {"/alexpipipipipipregunta3"})
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        Banda banda = new Banda();

        switch (action) {
            case "listar" -> {
                request.setAttribute("listabandas", banda.obtenerListaBandas());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista_favorita.jsp");
                requestDispatcher.forward(request, response);
            }
            case "favorito" -> {
                String id = request.getParameter("id");
                BandaDao.actualizar(id);
                response.sendRedirect(request.getContextPath() + "/FavoritaServlet");
            }
            case "no_favorito" -> {
                String id = request.getParameter("id");
                BandaDao.no_favorito(id);
                response.sendRedirect(request.getContextPath() + "/FavoritaServlet");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher view =request.getRequestDispatcher("lista_favorita.jsp");
        view.forward(request,response);
    }
}
