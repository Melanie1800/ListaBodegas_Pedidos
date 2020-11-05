package Servlets;

import Daos.BodegasDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BoegasServlet", urlPatterns = {"/Bodegas"})
public class BoegasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0bjeto dao
        BodegasDao bodegasDao= new BodegasDao();
        request.setAttribute("listaBodegas",bodegasDao.listaBodegas());

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("listaBodegas.jsp");
        requestDispatcher.forward(request,response);


    }
}
