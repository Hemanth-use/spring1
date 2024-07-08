package hero.service.admin;

import hero.repository.admin.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hero.entity.admin.Orders_Admin;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrderService {

    @Autowired
    private OrderRepository ordersRepository;

    @Override
    public List<Orders_Admin> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders_Admin getOrderById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public Orders_Admin saveOrder(Orders_Admin order) {
        return null;
    }

    @Override
    public Orders_Admin createOrder(Orders_Admin order) {
        return ordersRepository.save(order);
    }

    @Override
    public Orders_Admin updateOrder(Long id, Orders_Admin order) {
        if (ordersRepository.existsById(id)) {
            order.setId(id);
            return ordersRepository.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}

