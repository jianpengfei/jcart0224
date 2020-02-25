package io.jpf.jcartadministrationback.dto.in;

public class ReturnHistoryCreateInDTO {

    private Integer returnId;
    private Byte returnStarts;
    private String comment;
    private Boolean customerNotified;

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Byte getReturnStarts() {
        return returnStarts;
    }

    public void setReturnStarts(Byte returnStarts) {
        this.returnStarts = returnStarts;
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
