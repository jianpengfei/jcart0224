package io.jpf.jcartadministrationback.dto.out;

public class OrderProductShowOutDTO {

    private Integer productId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Integer unitRewardPoints;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitRewardPoints() {
        return unitRewardPoints;
    }

    public void setUnitRewardPoints(Integer unitRewardPoints) {
        this.unitRewardPoints = unitRewardPoints;
    }
}
