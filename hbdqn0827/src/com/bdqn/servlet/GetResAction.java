package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.hibernate.res.HosResObject;
import com.bdqn.hibernate.service.HouseService;

public class GetResAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetResAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		String sid = request.getParameter("sid");
		String htid = request.getParameter("htid");
		String bprice = request.getParameter("bprice");
		String eprice = request.getParameter("eprice");
		String orderby = request.getParameter("orderby");
		String uname = new String(request.getParameter("uname").getBytes("ISO-8859-1"),"UTF-8");
		HouseService hs = new HouseService();
		List<HosResObject> data = hs.findByParam(did, sid, htid, bprice, eprice, orderby, uname);
		HttpSession session = request.getSession();
		session.setAttribute("infos",data);
		response.sendRedirect("res.jsp");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
