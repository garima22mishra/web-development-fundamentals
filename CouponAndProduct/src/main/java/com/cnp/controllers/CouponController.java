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
import com.cnp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CouponDao dao = new CouponDao();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action !=null && action.equals("create")) {
			createCoupon(request, response);
		} else if (action !=null && action.equals("find")) {
			findCoupon(request, response);
		}else {
			createCoupon(request, response);
		}
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");

		Coupon coupon = new Coupon();
		coupon.setCode(code);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);

		dao.save(coupon);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<b Coupon Created/>");
		out.println("<br/><a href='/CouponAndProduct'>Home</a>");
	}
	
	private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		Coupon coupon = dao.findByCode(code);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(coupon);
		out.println("<br/><a href='/CouponAndProduct'>Home</a>");
	}
}
