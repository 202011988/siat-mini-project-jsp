package controller.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet(value = "/deleteCart.do")
public class CartRemoveController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 장바구니 삭제
        // 입력 정보: Cart

        CartService cartService = new CartService();

        // ??? ????? ??? ????.
        // ????? ?? ?? ?? ?? ???? ? ??.

        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream(),
                StandardCharsets.UTF_8));
        String line = reader.readLine();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(line, Map.class);
        List<String> carts = (List<String>) data.get("products");


        if (carts == null || carts.isEmpty()) {
            return;
        }

        cartService.removeAll(carts.stream().map(Integer::parseInt).collect(Collectors.toList()));

//        System.out.println(Arrays.asList(products));

//        List<Integer> cartIds = new ArrayList<>();
//
//        if (carts != null) {
//            for (String cart : carts) {
//                cartIds.add(Integer.parseInt(cart));
//            }
//        } else {
//            // TODO ERROR
//            return;
//        }
//
//        cartService.removeAll(cartIds);
    }
}
