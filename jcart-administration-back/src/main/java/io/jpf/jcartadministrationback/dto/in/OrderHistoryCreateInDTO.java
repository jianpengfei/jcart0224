package io.jpf.jcartadministrationback.dto.in;

public class OrderHistoryCreateInDTO {

    private Long orderHistoryId;
    private Byte orderStarts;
    private String comment;
    private Boolean customerNotified;

    public Long getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(Long orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
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
