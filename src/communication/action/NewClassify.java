package communication.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import communication.bean.Classify;
import communication.bean.User;
import communication.dao.impl.ClassifyDaoImpl;

/**
 * Servlet implementation class NewClassify
 */
@WebServlet("/NewClassify")
public class NewClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewClassify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("name");
		
		User user = (User) request.getSession().getAttribute("user");
		
		Classify classify = new Classify();
		
		classify.setName(name);
		
		classify.setNum(0);
		
		classify.setUser(user);
		
		boolean a = new ClassifyDaoImpl().addClassify(classify);
		
		if (a) {
			
			System.out.println("classify  if");
			response.sendRedirect("./SearchClassify");
		}else {
			System.out.println("classify  else");
			response.sendRedirect("./page/NewClassify.jsp");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
