/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Dell1
 */

public class CommonFileUpload {
    String DEFAULI_UPLOAD_PATH;
    HttpServletRequest request;

    public CommonFileUpload(String DEFAULI_UPLOAD_PATH, HttpServletRequest request) {
        this.DEFAULI_UPLOAD_PATH = DEFAULI_UPLOAD_PATH;
        this.request = request;
    }

    
    
    
    public ArrayList<String> use(){
        ArrayList<String> list = new ArrayList<>();
        try {
            File uploadsPath = new File(this.DEFAULI_UPLOAD_PATH);
            if (!uploadsPath.exists()) {
                //create upload folder if not exist.
                uploadsPath.mkdir();
            }
            
            for (Part part : request.getParts()) {
                String fileName = getFileName(part);
                
                if (fileName != null) {
                    int index = fileName.lastIndexOf('.');
                    String extension = fileName.substring(index + 1);
                    int i2 = (int) new Date().getTime();
                    String fn = (String.valueOf(i2) + "." + extension).replace("-", "");
                    list.add(fn);
                    part.write(this.DEFAULI_UPLOAD_PATH + File.separator + fn);
                }
            }
            
        } catch (IOException | ServletException e) {
            
            list.add("Error while uploading files! ");
        }
        return list;
    }
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }
}
