package com.openshift.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openshift.test.db.DBService;

/**
 * Servlet implementation class StudentSubmit
 */
public class StudentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSubmit() {
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
//		Map<String, String[]> parameters = request.getParameterMap();
		PrintWriter out = response.getWriter();
		String studentName = request.getParameter("sName");
		String studentSubject = request.getParameter("sSubject");
		boolean result = DBService.studentSave(studentName, studentSubject);
//      for logging
//		for(String key : parameters.keySet()){
//			out.println(key);
//		}
		if(result){
			out.println("save successful");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Success.html");
			dispatcher.forward(request, response);
			
		}else{
			out.println("Student object could not be saved");
		}
		
	}

}
