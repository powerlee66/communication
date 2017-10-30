package communication.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import communication.bean.Card;
import communication.bean.Classify;
import communication.bean.Collection;
import communication.dao.impl.CollectionDaoImpl;

/**
 * Servlet implementation class AddCollectionFinal
 */
@WebServlet("/AddCollectionFinal")
public class AddCollectionFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollectionFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		int classifyid = new Integer(request.getParameter("classifyid"));
		
		int cardid = (Integer)request.getSession().getAttribute("cardid");
		
		System.out.println("cardid:"+cardid+"//classifyid"+classifyid);
	
		Collection collection = new Collection();
		
		Card card = new Card();
		
		card.setId(cardid);
		
		Classify classify = new Classify();
		
		classify.setId(classifyid);
		
		collection.setCard(card);
		
		collection.setClassify(classify);
		
		Boolean a = new CollectionDaoImpl().add(collection);
		
		if (a) {
			response.sendRedirect("./page/Home.jsp");
		}else {
			response.sendRedirect("./page/SearchResult.jsp");
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
