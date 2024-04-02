package menucard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menucard.dao.CustomerDao;
import menucard.dto.Menucard;

@WebServlet("/remove")
public class RemoveMenu extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		CustomerDao dao = new CustomerDao();
		
		HttpSession httpSession = req.getSession();
		List<Menucard> list=(List<Menucard>) httpSession.getAttribute("session");
		
		list.remove(dao.fetchMenuById(id));		
		
		if (list.isEmpty()==false) {

			req.setAttribute("list", list);
			
			req.getRequestDispatcher("selectedmenu.jsp").forward(req, resp);
		} else {
			List<Menucard> list1 = dao.displayMenu();

			req.setAttribute("list", list1);
			req.getRequestDispatcher("menulist.jsp").forward(req, resp);
		}
	}

}
