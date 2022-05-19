/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import modal.KeyValues;

/**
 *
 * @author Dell1
 */
public class Utils {

    public static String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme() + "://";
        String serverName = request.getServerName();
        String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        String contextPath = request.getContextPath();
        return scheme + serverName + serverPort + contextPath;
    }

    public static String getMD5(String str) {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            md5 = sb.toString();
        } catch (NoSuchAlgorithmException e) {

        }
        return md5;
    }

    public static Cookie getCookies(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }

        return null;
    }

    public static String getBread(String name, ArrayList<KeyValues> map) {
        String str = "<div class=\"pagetitle\">\n"
                + "    <h1>" + name + "</h1>\n"
                + "    <nav>\n"
                + "        <ol class=\"breadcrumb\">\n";
        for (KeyValues string : map) {
            String active = (string.getValue().equals("active"))? "active":"";
            String link = (string.getValue().equals("active"))? "#":(string.getValue().equals(""))? "#":string.getValue();
            str += "<li class='breadcrumb-item "+active+"'><a href='"+link+"'>" + string.getKey() + "</a></li>\n";
        }

//                + "            <li class=\"breadcrumb-item active\">Dashboard</li>\n";
        str += "        </ol>\n"
                + "    </nav>\n"
                + "</div><!-- End Page Title -->";

        return str;
    }
    
    public static String CurrencyFormaString(String str){
        return Constent.CURRENCY_ICON_STRING+" "+str;
    }
    public static String[] StrinArrayToArray(String str){
        String s = str.replaceAll("\"", "").replace("]", "").replace("[", "");
        String[] strArray = s.split(",");
        return strArray;
    }
}
