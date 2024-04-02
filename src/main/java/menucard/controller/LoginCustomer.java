package menucard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menucard.dao.CustomerDao;
import menucard.dto.Customer;
import menucard.dto.Menucard;

@WebServlet("/log")
public class LoginCustomer extends HttpServlet {
	CustomerDao dao = new CustomerDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

//		CustomerDao dao = new CustomerDao();
		List<Menucard> sessionlist =new ArrayList<Menucard>();
		Customer customer= (dao.customerLog(email));
		
		//Session created
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("session", sessionlist);
		httpSession.setAttribute("session2", customer);

		if (customer != null) {
			req.setAttribute("msg", "Successfully login!\n\nPlease select your menu!");

			List<Menucard> list = dao.displayMenu();

			req.setAttribute("list", list);
			req.getRequestDispatcher("menulist.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Something went wrong! Save again");
			req.getRequestDispatcher("menu.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Menucard> list = dao.displayMenu();

		req.setAttribute("list", list);
		req.getRequestDispatcher("menulist.jsp").forward(req, resp);
	}
}
