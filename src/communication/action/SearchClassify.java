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

/**
 * Servlet implementation class SearchClassify
 */
@WebServlet("/SearchClassify")
public class SearchClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClassify() {
        super();
        // TODO Auto-generated constructor stub
    }

 // i miss u
   // i n 55!w !
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classify> list = new ArrayList<Classify>();
		
		User user = (User)request.getSession().getAttribute("user");
		
		System.out.println("userid"+user.getId());
		list = new ClassifyDaoImpl().findClassifyByUser(user);
		
		System.out.println("classify.size"+list.size());
		
		request.getSession().setAttribute("classify", list);
		
		response.sendRedirect("./page/SelectClassify.jsp");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
