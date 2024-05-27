package controller.order;

import entity.Order;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.OrderService;

@WebServlet(value = "/orderDetail.do")
public class OrderDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 주문 내역 상세 정보
        // 입력 정보: Order Id

        OrderService orderService = new OrderService();
        String orderId = req.getParameter("orderId");

        if (orderId.isEmpty()) {
            // TODO ERROR
            return;
        }

        Order order = orderService.findById(Integer.parseInt(orderId));

        req.setAttribute("order", order);
        req.setAttribute("total", order.getProduct().getPrice() * order.getQuantity());

        req.getRequestDispatcher("views/order-details.jsp").forward(req, resp);
    }
}
