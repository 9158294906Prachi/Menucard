package menucard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menucard.dto.Customer;

@WebServlet("/saveOrder")
public class Receipt extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int total=Integer.parseInt(req.getParameter("total"));
		HttpSession httpSession = req.getSession();
		Customer customer=(Customer) httpSession.getAttribute("session2");
		req.setAttribute("name", customer.getName());
		req.setAttribute("total", total);
		req.getRequestDispatcher("orderReceipt.jsp").forward(req, resp);
	}

}
