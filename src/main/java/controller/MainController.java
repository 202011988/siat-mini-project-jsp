package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();


        if(session == null || (session.getAttribute("user") == null
                && session.getAttribute("seller") == null)) {
            resp.sendRedirect("/views/virtualestimate.jsp");
        }

        else if (session.getAttribute("seller") != null) {
            resp.sendRedirect("/views/seller.jsp");
        }

    }
}