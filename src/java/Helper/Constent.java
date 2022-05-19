/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dell1
 */
public class Constent {

    public static final String APP_NAME = "Shopping";
    public static final String LOGIN_COOKIE_NAME = "shoppinglogin";
    public static final String CURRENCY_ICON_STRING = "&#8377;";
    public static final String CURRENCY_CODE_STRING = "INR";
    
    //local url
    public static final String PRODUCTS_UPLOAD_PATH_FILES = "C:/Users/Dell1/Documents/NetBeansProjects/Shopping/web/img/products";
    
    //Cnstent economicaly or frecenqtly used
    public static final String PENDING = "pending";
    public static final String SUCCESS = "success";
    public static final String ORDER_ID = "order_ids";
    public static final String COD = "cod";
    //All link of this webiste
    public static final String getBrandUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/admin-brands-index";
    }
    public static final String getCategoryUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/admin/category";
    }
    public static final String getSubCategoryUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/admin/sub-category";
    }
    public static final String getSubSubCategoryUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/admin/sub-sub-category";
    }
    public static final String getAdminProductUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/admin/products";
    }
    public static final String getLogoutUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/logout";
    }
    public static final String getAdminUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/admin";
    }
    public static final String getCartUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/cart";
    }
    public static final String getPaymentUrl(HttpServletRequest request) {
        return Utils.getBaseUrl(request) + "/payment";
    }
}
