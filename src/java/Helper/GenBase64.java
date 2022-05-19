/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.util.Base64;

/**
 *
 * @author Dell1
 */
public class GenBase64 {
    
    public static String enCode(String str){
        Base64.Encoder encoder = Base64.getUrlEncoder();  
        // Encoding URL  
        String eStr = encoder.encodeToString(str.getBytes()); 
        return eStr;
    }
    public static String deCode(String str){
        Base64.Decoder decoder = Base64.getUrlDecoder();  
        // Decoding URl  
        String dStr = new String(decoder.decode(str));  
        return dStr;
    }
}
