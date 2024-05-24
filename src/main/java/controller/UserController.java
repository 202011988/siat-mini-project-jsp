package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

@WebServlet(value = "/user")
public class UserController extends HttpServlet {

    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        userService = new UserService();

        userService.save(
                User.builder().user_id("user_id").password("password").address("seoul")
                        .username("user1").build());

//        PrintWriter out = resp.getWriter();
//        for (int id : userService.getUserList()) {
//            out.println(id);
//        }

        userService.off();
    }
}
