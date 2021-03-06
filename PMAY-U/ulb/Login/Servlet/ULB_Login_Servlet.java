package ulb.Login.Servlet;

import java.io.IOException;

import ulb.Login.connection.*;

import java.sql.*;

import java.io.*;

import javax.servlet.http.HttpSession;
import javax.servlet.*;

import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ULB_Login_Servlet
 */
@WebServlet("/ULB_Login_Servlet")
public class ULB_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULB_Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html");
	    String ULB_USER_NAME = request.getParameter("userNameULB");
	    String ULB_PASS = request.getParameter("userPassULB");
	    
	    ULB_Login obj = new ULB_Login ();
	    
	    ResultSet RS = null;
	    
	    RS = obj.ulbLogin(ULB_USER_NAME, ULB_PASS);
	    
	    HttpSession session = request.getSession(true);
	    
	    
	    try {
            if (!RS.next()){
                RS.beforeFirst();
                response.sendRedirect("###");
            }else {
                
                
               
                session.setAttribute("ULB_Sign",RS.getString(1));
                session.setAttribute("ULB_Name",RS.getString(2));
                session.setAttribute("ULB_State", RS.getString(3));
                session.setAttribute("ULB_District",RS.getString(4));
                session.setAttribute("ULB_Email",RS.getString(5));
                response.sendRedirect("http://localhost:8080/PMAY/PMAY-U/ImplementationAgency/ULB_LoggedIn.jsp");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
