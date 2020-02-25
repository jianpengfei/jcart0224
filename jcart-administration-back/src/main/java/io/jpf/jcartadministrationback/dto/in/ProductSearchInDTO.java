package io.jpf.jcartadministrationback.dto.in;

public class ProductSearchInDTO {

    private String productCode;
    private String productName;
    private Double price;
    private Integer storkQuantity;
    private Byte status;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStorkQuantity() {
        return storkQuantity;
    }

    public void setStorkQuantity(Integer storkQuantity) {
        this.storkQuantity = storkQuantity;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
