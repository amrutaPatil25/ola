package ola.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ola.com.conn.ConnetionTest;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Connection con = ConnetionTest.getConnection();
		try {
			PreparedStatement st = con.prepareStatement("select name,password from user");
			String nm= request.getParameter("name");
			String pass = request.getParameter("pass");
			ResultSet rs=st.executeQuery();
			
			if(nm.equals(rs.getString(1))&& pass.equals(rs.getString(2)))
			{
				RequestDispatcher rd = request.getRequestDispatcher("route.jsp");
				rd.forward(request, response);
				//
				//out.print("Select Route....");
				
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
				out.print("invalid username/password.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
