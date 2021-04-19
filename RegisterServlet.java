package ola.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.conn.ConnetionTest;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		Connection con = ConnetionTest.getConnection();
		int i=1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?,?)");
			pst.setInt(1, i++);
			pst.setString(2, request.getParameter("name"));
			pst.setString(3, request.getParameter("password"));
			pst.setString(4, request.getParameter("mobNo"));
			pst.setString(5, request.getParameter("email"));
			pst.executeUpdate();
			PrintWriter out = response.getWriter();
			out.print("You are Successfully Registered.....");
			response.sendRedirect( "http://localhost:8080/OlaDemo/Login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
