package com.productpackage;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Servlet implementation class ProductDAO
 */
public class ProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		  // reading form values
		  int cost = Integer.parseInt(request.getParameter("cost"));
		  String name = request.getParameter("proname");
		  // put values in Object
		  Product p1 = new Product();
		  p1.setCost(cost);
		  p1.setName(name);

		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  int i = (Integer) session.save(p1);
		  session.getTransaction().commit();

		  session.close();

		  PrintWriter out = response.getWriter();
		  if (i > 0)
		   out.println("Record inserted");
		  else
		   out.println("Record not inserted");

		 }

	}
