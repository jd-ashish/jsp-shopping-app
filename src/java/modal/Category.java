/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author Dell1
 */
public class Category {
    int id,user_id , status , brand_id;
    String name , img , created_at , updated_at;

    public Category(int brand_id ,String name, String img ) {
        this.brand_id = brand_id;
        this.name = name;
        this.img = img;
        
    }

    public Category(int id, int user_id, int status, int brand_id, String name, String img, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.brand_id = brand_id;
        this.name = name;
        this.img = img;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
