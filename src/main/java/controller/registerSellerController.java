package controller;

import entity.Seller;
import service.SellerService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerSeller.do")
public class registerSellerController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/views/errors/error.jsp";

        String registrationNuberString = req.getParameter("registrationNuber");
        String password = req.getParameter("password");
        String sellerName = req.getParameter("sellerName");
        String storeName = req.getParameter("storeName");

        Seller newSeller = null;
        SellerService sellerService = new SellerService();

        boolean insertResult = false;

        try {

            int registrationNumber = Integer.parseInt(registrationNuberString);

            newSeller = Seller.builder()
                    .registrationNumber(registrationNumber)
                    .password(password)
                    .sellerName(sellerName)
                    .storeName(storeName)
                    .build();

            sellerService.save(newSeller);

            resp.sendRedirect("/login.jsp");

        } catch (Exception e) {
            req.setAttribute("error", "회원가입 실패");
            req.getRequestDispatcher(url).forward(req, resp);
        }

    }
}
