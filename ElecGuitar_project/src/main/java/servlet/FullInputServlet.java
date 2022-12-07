package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBExpert;
import dto.Purchase;
import dto.SeInfo;

/**
 * Servlet implementation class FullInputServlet
 */
@WebServlet("/guitarreg.do")
public class FullInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FullInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String ele_num = request.getParameter("ELENUM");
		String model = request.getParameter("MODEL");
		String pickup = request.getParameter("PICK");
		String neck = request.getParameter("NECK");
		String price = request.getParameter("PRICE");
		String mad_name = request.getParameter("MADNAME");
		String sell_numb = request.getParameter("SELLNUM");
		
		Purchase dto = new Purchase();
		SeInfo dto2 = new SeInfo();
		dto.setEle_num(ele_num);
		dto.setModel(model);
		dto.setPickup(pickup);
		dto.setNeck(neck);
		dto.setPrice(Integer.parseInt(price));
		dto.setMad_name(mad_name);
		dto.setSell_numb(sell_numb);
		DBExpert dao = new DBExpert();
		dao.getPutElec(dto,dto2);
		response.sendRedirect("guitarList.do");
	}

}
