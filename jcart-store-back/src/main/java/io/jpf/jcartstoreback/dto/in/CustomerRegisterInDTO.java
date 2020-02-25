package io.jpf.jcartstoreback.dto.in;

public class CustomerRegisterInDTO {

    private String userName;
    private String realName;
    private String email;
    private String mobile;
    private String password;
    private Boolean newsubscribed;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getNewsubscribed() {
        return newsubscribed;
    }

    public void setNewsubscribed(Boolean newsubscribed) {
        this.newsubscribed = newsubscribed;
    }
}
