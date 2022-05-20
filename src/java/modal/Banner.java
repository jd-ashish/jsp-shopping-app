/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author Dell1
 */
public class Banner {

    int id, status;

    String file, positions, title, description, offer, link, created_at, updated_at;

    public Banner(int status, String file, String positions, String title, String description, String offer, String link) {
        this.status = status;
        this.file = file;
        this.positions = positions;
        this.title = title;
        this.description = description;
        this.offer = offer;
        this.link = link;
    }

    
    public Banner(int id, int status, String file, String positions, String title, String description, String offer, String link, String created_at, String updated_at) {
        this.id = id;
        this.status = status;
        this.file = file;
        this.positions = positions;
        this.title = title;
        this.description = description;
        this.offer = offer;
        this.link = link;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
