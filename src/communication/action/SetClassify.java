package communication.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.startup.HomesUserDatabase;

import communication.bean.Classify;
import communication.bean.User;
import communication.dao.impl.ClassifyDaoImpl;

/**
 * Servlet implementation class SetClassify
 */
@WebServlet("/SetClassify")
public class SetClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetClassify() {
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
		
		Classify classify = (Classify) request.getSession().getAttribute("classifydetail");
		
		classify.setName(name);
		
		User user = (User)request.getSession().getAttribute("user");
		
		System.out.println(classify.getName());
		
		new ClassifyDaoImpl().updateClassify(classify);
		
		List<Classify> list = new ArrayList<Classify>();
		
		list = new ClassifyDaoImpl().findClassifyByUser(user);
		
		System.out.println("classify.size"+list.size());
		
		request.getSession().setAttribute("classify", list);
		
		response.sendRedirect("./page/Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
