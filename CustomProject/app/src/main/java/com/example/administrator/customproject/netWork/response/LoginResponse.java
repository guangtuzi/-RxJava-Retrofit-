package com.example.administrator.customproject.netWork.response;

/**
 * Created by Administrator on 2016/11/1.
 */

public class LoginResponse {
    private String token;
    private int userId;
    private String username;// 用户名
    private String name;// 姓名
    private String staffNo;// 工号
    // Restaurant相关数据
    private String restaurantName;
    private String headerPic;
    private String qrcodePic;
    private String content;
    private Long merchantId;
    private int foodVersion;
    private int restaurantId;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    public String getQrcodePic() {
        return qrcodePic;
    }

    public void setQrcodePic(String qrcodePic) {
        this.qrcodePic = qrcodePic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public int getFoodVersion() {
        return foodVersion;
    }

    public void setFoodVersion(int foodVersion) {
        this.foodVersion = foodVersion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
