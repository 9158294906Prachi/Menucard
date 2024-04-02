package menucard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menucard.dao.CustomerDao;
import menucard.dto.Menucard;

@WebServlet("/addmenus")
public class saveMenuCard extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menuname= req.getParameter("menuname");
		double price= Double.parseDouble(req.getParameter("price"));
		
		Menucard menucard= new Menucard();
		menucard.setName(menuname);
		menucard.setPrice(price);
		
		CustomerDao dao= new CustomerDao();
		
		if ((dao.saveMenucard(menucard))==1) {
			req.setAttribute("msg", "Successfully saved");
			
			List<Menucard> list= dao.displayMenu();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("showmenu.jsp").forward(req, resp);
		} else {			
			req.setAttribute("msg", "Something went wrong! Save again");
			req.getRequestDispatcher("menu.jsp").forward(req, resp);
		}
	}
	
	
}
