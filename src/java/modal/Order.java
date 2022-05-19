/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author Dell1
 */
public class Order {

    int id ,user_id ;
    double sub_total;
    String address , order_type , order_status, delivery_status, payment_method, payment_staus, created_at, updated_at;

    public Order(double sub_total, String address, String order_type, String order_status, String delivery_status, String payment_method, String payment_staus) {
        
        this.sub_total = sub_total;
        this.address = address;
        this.order_type = order_type;
        this.order_status = order_status;
        this.delivery_status = delivery_status;
        this.payment_method = payment_method;
        this.payment_staus = payment_staus;
    }

    
    public Order(int id, int user_id , double sub_total, String address, String order_type, String order_status, String delivery_status, String payment_method, String payment_staus, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.sub_total = sub_total;
        this.address = address;
        this.order_type = order_type;
        this.order_status = order_status;
        this.delivery_status = delivery_status;
        this.payment_method = payment_method;
        this.payment_staus = payment_staus;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_staus() {
        return payment_staus;
    }

    public void setPayment_staus(String payment_staus) {
        this.payment_staus = payment_staus;
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
