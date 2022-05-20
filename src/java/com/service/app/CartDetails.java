/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.app;

import Dao.CartDao;
import Dao.ProductsDao;
import Dao.ProductsDetailsDao;
import Helper.Constent;
import Helper.GenBase64;
import Helper.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Cart;
import modal.Products;
import modal.ProductsStock;

/**
 *
 * @author Dell1
 */
public class CartDetails {

    public static HashMap<String, String> getCartDetails(int totalCart, HttpServletRequest request, HttpServletResponse response, CartDao cartDao) {
        String details = "";
        ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();
        ProductsDao productsDao = new ProductsDao();

        HashMap<String, String> map = new HashMap<>();
        map.put("total", String.valueOf(totalCart));
        details += "<table class=\"timetable_sub\">\n"
                + "                    <thead>\n"
                + "                        <tr>\n"
                + "                            <th>SL No.</th>	\n"
                + "                            <th>Product</th>\n"
                + "                            <th>Quality</th>\n"
                + "                            <th>Product Name</th>\n"
                + "\n"
                + "                            <th>Price</th>\n"
                + "                            <th>Remove</th>\n"
                + "                        </tr>\n"
                + "                    </thead>\n"
                + "                    <tbody>\n";
        if (cartDao.getCart(request).size() == 0) {
            details += "                        <tr class=\"rem1\" >\n"
                    + "                            <td class=\"invert\" colspan='6'>No data found!</td>\n"
                    + "                        </tr>\n";
        }
        int cnt = 0;
        String cart_total = "<ul>\n";
        double total_amount = 0;
        ArrayList<String> arrayListCartIds = new ArrayList<>();
        for (Cart carts : cartDao.getCart(request)) {
            arrayListCartIds.add(String.valueOf(carts.getId()));
            ProductsStock productsStocks = productsDetailsDao.getProductsStocks(carts.getStock_id()).get(0);
            Products productses = productsDao.getProductsById("", productsStocks.getProduct_id()).get(0);
            cart_total += "                        <li>" + productses.getName().substring(0, (productses.getName().length() >= 30) ? 30 : productses.getName().length()) + " <i>-</i> <span>" + Utils.CurrencyFormaString(String.valueOf(productsStocks.getOffer_price() * carts.getQty())) + " </span></li>\n";
            total_amount += Double.valueOf(String.valueOf(productsStocks.getOffer_price() * carts.getQty()));

            //get product details start query
            String id = Utils.reverse(GenBase64.enCode(String.valueOf(productses.getId())));
            String name = Utils.reverse(GenBase64.enCode(productses.getName()));

            String query = "id=" + id + "&name=" + name;

            //end query
            
            details += "                        <tr class=\"rem1\">\n"
                    + "                            <td class=\"invert\">" + (++cnt) + "</td>\n"
                    + "                            <td class=\"invert-image\" style=\"width: 50px;\"><a href='"+Constent.getProductsDetailsUrl(request)+"?"+query+"'><img widith='20' src=\"img/products/" + productses.getThumbnail() + "\" alt=\" \" class=\"img-responsive\"></a></td>\n"
                    + "                            <td class=\"invert\">\n"
                    + "                                <div class=\"quantity\"> \n"
                    + "                                    <div class=\"quantity-select\">                           \n"
                    + "                                        <div class=\"entry value-minus\" onclick='update_cart(" + carts.getId() + ",\"-\")'>&nbsp;</div>\n"
                    + "                                        <div class=\"entry value\"><span>" + carts.getQty() + "</span></div>\n"
                    + "                                        <div class=\"entry value-plus active\" onclick='update_cart(" + carts.getId() + ",\"+\")'>&nbsp;</div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </td>\n"
                    + "                            <td class=\"invert\"><a href='"+Constent.getProductsDetailsUrl(request)+"?"+query+"'>" + ((productses.getName().length() <= 50) ? productses.getName() : productses.getName().substring(0, 50) + "...") + "</a></td>\n"
                    + "\n"
                    + "                            <td class=\"invert\">" + Utils.CurrencyFormaString(String.valueOf(productsStocks.getOffer_price())) + "</td>\n"
                    + "                            <td class=\"invert\">\n"
                    + "                                <div class=\"rem\">\n"
                    + "                                    <div class=\"close1 remove_cart\" cart_id='" + carts.getId() + "' onclick='remove_cart(" + carts.getId() + ")'> </div>\n"
                    + "                                </div>\n"
                    + "\n"
                    + "                            </td>\n"
                    + "                        </tr>\n";

        }

        details += "\n"
                + "                    </tbody></table>";
        map.put("details", details);

        cart_total += "                        <li><b>Total</b> <i>-</i> <span><b>" + total_amount + " <input type=\"hidden\" name=\"sub_total\" value='" + total_amount + "'></b></span></li>\n";
        cart_total += "                    </ul>";
        map.put("cart_total", cart_total);
        map.put("cartIds", new Gson().toJson(arrayListCartIds));
        return map;

    }

}
