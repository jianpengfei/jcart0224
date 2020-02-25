package io.jpf.jcartadministrationback.dto.out;

public class OrderHistoryListOutDTO {

    private Long order_history_id;
    private Long timestamp;
    private Byte orderStarts;
    private String comment;
    private Boolean customerNotified;

    public Long getOrder_history_id() {
        return order_history_id;
    }

    public void setOrder_history_id(Long order_history_id) {
        this.order_history_id = order_history_id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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
