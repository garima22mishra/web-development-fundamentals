package com.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnp.dao.CouponDao;
import com.cnp.dao.ProductDao;
import com.cnp.model.Coupon;
import com.cnp.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDao productDao = new ProductDao();
	CouponDao couponDao = new CouponDao();
	
    public ProductController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String code = request.getParameter("code");
		
		Coupon coupon = couponDao.findByCode(code);
		
		Product product = new Product();
		
		product.setName(name);
		product.setDescription(description);
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<b Product Created/>");
		out.println("<br/><a href='/CouponAndProduct'>Home</a>");
	}

}
