package controller;

import entity.Seller;
import entity.User;
import service.SellerService;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerUser.do")
public class registerUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/views/errors/error.jsp";

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        String address = req.getParameter("address");

        User newUser = null;
        UserService userService = new UserService();

        try {


            newUser = User.builder()
                            .userId(userId)
                            .password(password)
                            .username(username)
                            .address(address)
                            .build();

            userService.save(newUser);

            resp.sendRedirect("/login.jsp");

        } catch (Exception e) {
            req.setAttribute("error", "회원가입 실패");
            req.getRequestDispatcher(url).forward(req, resp);
        }

    }
}
