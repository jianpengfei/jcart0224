package io.jpf.jcartadministrationback.dto.in;

public class OrderHistoryCreateInDTO {

    private Long order_history_id;
    private Byte orderStarts;
    private String comment;
    private Boolean customerNotified;

    public Long getOrder_history_id() {
        return order_history_id;
    }

    public void setOrder_history_id(Long order_history_id) {
        this.order_history_id = order_history_id;
    }

    public Byte getOrderStarts() {
        return orderStarts;
    }

    public void setOrderStarts(Byte orderStarts) {
        this.orderStarts = orderStarts;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getCustomerNotified() {
        return customerNotified;
    }

    public void setCustomerNotified(Boolean customerNotified) {
        this.customerNotified = customerNotified;
    }
}
