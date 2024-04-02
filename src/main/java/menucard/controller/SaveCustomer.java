package menucard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menucard.dao.CustomerDao;
import menucard.dto.Customer;
import menucard.dto.Menucard;

@WebServlet("/user")
public class SaveCustomer extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");

		Customer customer = new Customer();
		customer.setName(name);
		customer.setPhone(phone);
		customer.setEmail(email);

		CustomerDao dao = new CustomerDao();

		if ((dao.saveCustomer(customer)) == 1) {
			req.setAttribute("msg", "Successfully resister! Please login");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Account already exist! Please sign in or resister with another email and phone number.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}

}
