package hero.controller.admin;

import hero.service.admin.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hero.entity.admin.Orders_Admin;
import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class OrdersController {

    @Autowired
    private OrderService ordersService;

    @GetMapping
    public List<Orders_Admin> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders_Admin getOrderById(@PathVariable Long id) {
        return ordersService.getOrderById(id);
    }

    @PostMapping
    public Orders_Admin createOrder(@RequestBody Orders_Admin order) {

        return ordersService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Orders_Admin updateOrder(@PathVariable Long id, @RequestBody Orders_Admin order) {
        return ordersService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrder(id);
    }
}

