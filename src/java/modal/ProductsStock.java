/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author Dell1
 */
public class ProductsStock {
        
    int id, user_id, product_id, total_stock, total_price, offer_price, status;
    String sku , created_at, updated_at;

    public ProductsStock(int id ,int product_id, int total_stock, int total_price, int offer_price, String sku) {
        this.id = id;
        this.product_id = product_id;
        this.total_stock = total_stock;
        this.total_price = total_price;
        this.offer_price = offer_price;
        this.sku = sku;
    }
    public ProductsStock(int product_id, int total_stock, int total_price, int offer_price, String sku) {
        this.product_id = product_id;
        this.total_stock = total_stock;
        this.total_price = total_price;
        this.offer_price = offer_price;
        this.sku = sku;
    }

    public ProductsStock(int id, int user_id, int product_id, int total_stock, int total_price, int offer_price, int status, String sku, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.total_stock = total_stock;
        this.total_price = total_price;
        this.offer_price = offer_price;
        this.status = status;
        this.sku = sku;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getTotal_stock() {
        return total_stock;
    }

    public void setTotal_stock(int total_stock) {
        this.total_stock = total_stock;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(int offer_price) {
        this.offer_price = offer_price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    

}
