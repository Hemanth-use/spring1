package hero.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hero.entity.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "admin_orders")
public class Orders_Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String orderNumber;

        public Orders_Admin() {
        }

        @Override
        public String toString() {
                return "Orders_Admin{" +
                        "id=" + id +
                        ", orderNumber='" + orderNumber + '\'' +
                        ", user=" + user +
                        ", orderDate=" + orderDate +
                        ", totalPrice=" + totalPrice +
                        ", status='" + status + '\'' +
                        ", order=" + order +
                        ", shippingAddress='" + shippingAddress + '\'' +
                        ", paymentMethod='" + paymentMethod + '\'' +
                        ", taxAmount=" + taxAmount +
                        ", shippingFee=" + shippingFee +
                        '}';
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getOrderNumber() {
                return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Date getOrderDate() {
                return orderDate;
        }

        public void setOrderDate(Date orderDate) {
                this.orderDate = orderDate;
        }

        public BigDecimal getTotalPrice() {
                return totalPrice;
        }

        public void setTotalPrice(BigDecimal totalPrice) {
                this.totalPrice = totalPrice;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public Orders_Admin getOrder() {
                return order;
        }

        public void setOrder(Orders_Admin order) {
                this.order = order;
        }

        public String getShippingAddress() {
                return shippingAddress;
        }

        public void setShippingAddress(String shippingAddress) {
                this.shippingAddress = shippingAddress;
        }

        public String getPaymentMethod() {
                return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
        }

        public BigDecimal getTaxAmount() {
                return taxAmount;
        }

        public void setTaxAmount(BigDecimal taxAmount) {
                this.taxAmount = taxAmount;
        }

        public BigDecimal getShippingFee() {
                return shippingFee;
        }

        public void setShippingFee(BigDecimal shippingFee) {
                this.shippingFee = shippingFee;
        }

        @ManyToOne(optional = false)
        private User user;

        public Orders_Admin(Long id, String orderNumber, User user, Date orderDate,
                            BigDecimal totalPrice, String status, Orders_Admin order,
                            String shippingAddress, String paymentMethod, BigDecimal taxAmount,
                            BigDecimal shippingFee) {
                this.id = id;
                this.orderNumber = orderNumber;
                this.user = user;
                this.orderDate = orderDate;
                this.totalPrice = totalPrice;
                this.status = status;
                this.order = order;
                this.shippingAddress = shippingAddress;
                this.paymentMethod = paymentMethod;
                this.taxAmount = taxAmount;
                this.shippingFee = shippingFee;
        }

        @Column(nullable = false)
        private Date orderDate;

        @Column(nullable = false)
        private BigDecimal totalPrice;

        @Column(nullable = false)
        private String status;

        @ManyToOne
        @JoinColumn(name = "order_id", nullable = false)
        @JsonIgnore
        private Orders_Admin order;

        @Column(nullable = false)
        private String shippingAddress;

        @Column(nullable = false)
        private String paymentMethod;

        @Column(nullable = false)
        private BigDecimal taxAmount;

        @Column(nullable = false)
        private BigDecimal shippingFee;


}

