package communication.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import communication.bean.Classify;
import communication.bean.User;
import communication.dao.impl.ClassifyDaoImpl;
import communication.serverDaoImpl.UserServerDaoImpl;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String name = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		System.out.println(name+"$$"+password);
		
		User user = new User();
		
		user.setName(name);
		
		user.setPassword(password);
		
		user = new UserServerDaoImpl().login(user);
		
		
		
		if (user!=null) {
			System.out.println("µÇÂ½³É¹¦");
			
			request.getSession().setAttribute("user", user);
			List<Classify> list = new ArrayList<Classify>();
			
			list = new ClassifyDaoImpl().findClassifyByUser(user);
			
			System.out.println("classify.size"+list.size());
			
			request.getSession().setAttribute("classify", list);
			
			response.sendRedirect("./page/Home.jsp");
		}else {
			response.sendRedirect("./page/Login.jsp");
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
