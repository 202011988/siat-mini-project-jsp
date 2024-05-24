package controller;

import entity.Cart;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Seller;
import entity.User;
import service.SellerService;
import service.UserService;

@WebServlet(value = "/login.do")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        boolean isSeller = false;
        String sellerTemp = req.getParameter("seller");
        if (sellerTemp != null && sellerTemp.equals("on")) {
            isSeller = true;
        }

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        if (isSeller) {

            SellerService sellerService = new SellerService();
            System.out.println("판매자");
            Seller seller = null;
            seller = sellerService.findSellerByRegistrationNumberAndPassword(id, pw);

            if (seller != null) {
                HttpSession session = req.getSession();
                session.setAttribute("seller", seller.getRegistrationNumber());

                resp.sendRedirect("/views/seller.jsp");
            } else {
                req.setAttribute("error", "해당하는 판매자를 찾을 수 없음");
                req.getRequestDispatcher("/views/errors/error.jsp").forward(req, resp);
            }

        } else {

            UserService userService = new UserService();
            System.out.println("user");
            User user = null;
            user = userService.findUserByUsernameAndPassword(id, pw);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user.getUsername());
                resp.sendRedirect("/views/virtualestimate.jsp");
            } else {
                req.setAttribute("error", "해당하는 계정을 찾을 수 없음");
                req.getRequestDispatcher("/views/errors/error.jsp").forward(req, resp);
            }
        }
    }
}


