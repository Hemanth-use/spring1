package hero.service.admin;
import hero.entity.admin.Orders_Admin;

import java.util.List;

public interface OrderService {
    List<Orders_Admin> getAllOrders();

    Orders_Admin getOrderById(Long id);

    Orders_Admin saveOrder(Orders_Admin order);

    Orders_Admin createOrder(Orders_Admin order);

    Orders_Admin updateOrder(Long id, Orders_Admin order);

    void deleteOrder(Long id);
}

