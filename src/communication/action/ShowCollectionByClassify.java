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
import communication.dao.impl.CardDaoImpl;
import communication.dao.impl.CollectionDaoImpl;

/**
 * Servlet implementation class ShowCollectionByClassify
 */
@WebServlet("/ShowCollectionByClassify")
public class ShowCollectionByClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCollectionByClassify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = new Integer(request.getParameter("id"));
		
		List<Card> list = new ArrayList<Card>();
		
		List<Collection> list2 = new ArrayList<Collection>();
		
		Classify classify = new Classify();
		
		classify.setId(id);
		
		
		
		list2 = new CollectionDaoImpl().findByclassifyName(classify);
		
		System.out.println("list2"+list2.size());
		
		for (Collection collection : list2) {
			Card card = new Card();
			
			card = new CardDaoImpl().findCardById(collection.getCard().getId());
			
			System.out.println(card.getEmail());
			
			list.add(card);
		}
		
		request.getSession().setAttribute("classifyid", id);
		
		request.getSession().setAttribute("cardlist", list);
		
		System.out.println(list.size());
		
		response.sendRedirect("./page/ShowCardByClassify.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
