/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Dao.UserDao;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import modal.User;

/**
 *
 * @author Dell1
 */
public class Auth {
    HttpServletRequest request;
    UserDao userDao = new UserDao();

    public Auth(HttpServletRequest request) {
        this.request = request;
    }
    
    public User user(){
        Cookie cookie = Utils.getCookies(request, Constent.LOGIN_COOKIE_NAME);
        
        User user = null;
        if(cookie!=null){
            user =  userDao.getUser(cookie.getValue());
        }
        return user;
    }
}
