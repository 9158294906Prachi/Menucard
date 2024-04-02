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

@WebServlet("/delete")
public class DeleteMenu extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		CustomerDao dao= new CustomerDao();
		try {
			int count=dao.deleteMenu(id);
			if (count!=0) {
				
				List<Menucard> list= dao.displayMenu();
				req.setAttribute("list", list);
				req.getRequestDispatcher("showmenu.jsp").forward(req, resp);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
