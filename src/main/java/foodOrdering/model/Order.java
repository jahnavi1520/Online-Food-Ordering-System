package main.java.foodOrdering.model;

    import java.time.LocalDateTime;

    public class Order {
        private String orderId;
        private LocalDateTime date;
        private double total;
        private OrderStatus status;

        public Order(String orderId, double total) {
            this.orderId = orderId;
            this.total = total;
            this.date = LocalDateTime.now();
            this.status = OrderStatus.PLACED;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public void setStatus(OrderStatus status) {
            this.status = status;
        }
    }

