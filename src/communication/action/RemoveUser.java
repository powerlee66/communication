package communication.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import communication.bean.Classify;
import communication.bean.User;
import communication.dao.impl.CardDaoImpl;
import communication.dao.impl.ClassifyDaoImpl;
import communication.dao.impl.CollectionDaoImpl;
import communication.serverDaoImpl.UserServerDaoImpl;

/**
 * Servlet implementation class RemoveUser
 */
@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUser() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		User user = (User) request.getSession().getAttribute("user");
		
		new CardDaoImpl().deleteCardByUser(user);
		
		List<Classify> list = new ClassifyDaoImpl().findClassifyByUser(user);
		
		for (Classify classify : list) {
			new CollectionDaoImpl().delete(classify.getId());
		}
		
		new ClassifyDaoImpl().deleteClassifyByUser(user);
		
		new UserServerDaoImpl().remove(user);
		
		response.sendRedirect("./page/Login.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
