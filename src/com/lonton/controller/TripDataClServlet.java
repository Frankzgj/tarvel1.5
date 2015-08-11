package com.lonton.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.lonton.bean.TripData;
import com.lonton.mapper.ITripMapper;
import com.lonton.service.DatabaseService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TripDataClServlet
 */
@WebServlet("/TripDataClServlet")
public class TripDataClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		String parentTargetId = request.getParameter("parentTargetId");
		System.out.println("ok");
		DatabaseService dbs = new DatabaseService();
		ITripMapper userOperation = dbs.databaseService();
		JSONArray target = null;
		//异步请求
		if (request.getHeader("x-requested-with") != null
			&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			if(parentTargetId != null){
				
				ArrayList<TripData> datas = userOperation.getTripDataByParent_targetId(Integer.parseInt(parentTargetId));
			    target = JSONArray.fromObject(datas);
			    System.out.println(target.toString());
			    
			}
		      PrintWriter out = response.getWriter();  
		      out.write(target.toString()); 
		      out.flush();
		      out.close();
		
	    }else{    //传统的同步请求
			if(parentTargetId != null){
				
				ArrayList<TripData> datas = userOperation.getTripDataByParent_targetId(Integer.parseInt(parentTargetId));
			    target = JSONArray.fromObject(datas);
			  	}
			
			PrintWriter out = response.getWriter();  
	        out.write(target.toString()); 
	        out.flush();
	        out.close();
		}
		System.out.println(target.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
