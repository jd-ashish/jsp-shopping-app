/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author Dell1
 */
public class Products {

    int id , user_id , brand , cateory , sub_category , sub_sub_category , status;
    String name,details,unit , thumbnail , main_image , created_at , updated_at;

    public Products(int brand, int cateory, int sub_category, int sub_sub_category, String name, String unit, String thumbnail, String main_image,String details) {
        this.brand = brand;
        this.cateory = cateory;
        this.sub_category = sub_category;
        this.sub_sub_category = sub_sub_category;
        this.name = name;
        this.unit = unit;
        this.thumbnail = thumbnail;
        this.main_image = main_image;
        this.details = details;
    }
    public Products(int id , int brand, int cateory, int sub_category, int sub_sub_category, String name, String unit, String thumbnail, String main_image,String details) {
        this.id = id;
        this.brand = brand;
        this.cateory = cateory;
        this.sub_category = sub_category;
        this.sub_sub_category = sub_sub_category;
        this.name = name;
        this.unit = unit;
        this.thumbnail = thumbnail;
        this.main_image = main_image;
        this.details = details;
    }

    
    public Products(int id, int user_id, int brand, int cateory, int sub_category, int sub_sub_category, int status, String name, String unit, String thumbnail, String main_image,String details, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.brand = brand;
        this.cateory = cateory;
        this.sub_category = sub_category;
        this.sub_sub_category = sub_sub_category;
        this.status = status;
        this.name = name;
        this.unit = unit;
        this.thumbnail = thumbnail;
        this.main_image = main_image;
        this.details = details;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getCateory() {
        return cateory;
    }

    public void setCateory(int cateory) {
        this.cateory = cateory;
    }

    public int getSub_category() {
        return sub_category;
    }

    public void setSub_category(int sub_category) {
        this.sub_category = sub_category;
    }

    public int getSub_sub_category() {
        return sub_sub_category;
    }

    public void setSub_sub_category(int sub_sub_category) {
        this.sub_sub_category = sub_sub_category;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
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
