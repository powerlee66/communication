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
import communication.dao.impl.CardDaoImpl;
import communication.serverDaoImpl.SearchServerDaoImpl;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("search");
		List<Card>list = new ArrayList<Card>();
		if (search!="") {
			list = new SearchServerDaoImpl().searchCardByName(search);
		}else{
			list = new CardDaoImpl().find();
		}
		
		
		
		if (list.size()!=0) {
			request.getSession().setAttribute("search", list);
			
			//System.out.println(list.size());
			
			for (Card card : list) {
				
				System.out.println("list"+card.getName());
			
			}
			
			response.sendRedirect("./page/SearchResult.jsp");
		
		}else {
			response.sendRedirect("./page/Home.jsp");
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
