package communication.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import communication.bean.Card;
import communication.bean.Classify;
import communication.bean.Collection;
import communication.bean.User;
import communication.dao.impl.ClassifyDaoImpl;
import communication.dao.impl.CollectionDaoImpl;
import communication.serverDaoImpl.SearchServerDaoImpl;
import communication.serverDaoImpl.UpdateServerDaoImpl;

/**
 * Servlet implementation class AddCollection
 */
@WebServlet("/AddCollection")
public class AddCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = new Integer(request.getParameter("cardid"));
		
		
		request.getSession().setAttribute("cardid", id);
		
		response.sendRedirect("./SearchClassify");
		
//		
//		Card card = new Card();
//		
//		card.setId(id);
//		
//		User user = (User)request.getSession().getAttribute("user");
//		
//		Classify classify = new Classify();
//		
//		List<Classify> list = new ArrayList<Classify>();
//		
//		list = new ClassifyDaoImpl().findClassifyByUser(user);
//		 
//		if (list.size()==0) {
//			classify.setUser(user);
//			
//			new ClassifyDaoImpl().addClassify(classify);
//		}
//		
//		int classifyid = new ClassifyDaoImpl().findClassifyByUser(user).get(0).getId();
//		
//		classify.setId(classifyid);
//		
//		Collection collection = new Collection();
//		
//		collection.setClassify(classify);
//		
//		collection.setCard(card);
//		
//		boolean a = new CollectionDaoImpl().add(collection);
//		
//		if (a) {
//			response.sendRedirect("./page/SearchResult.jsp");
//		}else {
//			response.sendRedirect("./page/SearchResult.jsp");
//		}
//		
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
