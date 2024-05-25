package controller.order;


import com.mysql.cj.Session;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;

@WebServlet(value = "/orders.do")
public class OrderListSelectController extends HttpServlet {
    // 주문 목록
    // 입력 정보: user (Session : userId)
    private OrderService orderService;

    public OrderListSelectController() {
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("user");
//        String userId = req.getParameter("userId");

        // filter로 구현
//        if (userId.isEmpty()) {
//            // TODO ERROR
//            return;
//        }

        List<Order> orders = orderService.findAllByUserId(userId);

        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/views/order-list.jsp").forward(req, resp);

        PrintWriter writer = resp.getWriter();
        orders.forEach(writer::println);
//        req.setAttribute("orders", orders);
//        req.getRequestDispatcher("/views/order-list.jsp").forward(req, resp);
//        req.setAttribute(orders);
    }
}
