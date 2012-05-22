package org.newair;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;



/**
 * Servlet implementation class Accept
 */

public class Accept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
String code =	request.getParameter("code");
		

PrintWriter pw = response.getWriter();
	
	
	
	/*Rhino rno = new Rhino();
	
	rno.setcode(try{
Scriptable scope = cx.initStandardObjects();
try {
	ScriptableObject.defineClass(scope, Student.class);
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InvocationTargetException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}code);
	
	Thread t = new Thread(rno);
	t.start();*/
	
	
	
	
String[] cmd = {code};

Context cx = Context.enter();

try{
Scriptable scope = cx.initStandardObjects();
try {
	ScriptableObject.defineClass(scope, Student.class);
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InvocationTargetException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


/*Object[] arg = {new String("amila"), new Integer(23)};

Scriptable student =   cx.newObject(scope,"Student",arg); 
scope.put("Student",scope,student);*/


String s= "";

for(int i=0; i < cmd.length;i++){
	
	
	s += cmd[i];
	
}


//evaluating a script


Object result = cx.evaluateString(scope, s, "<cmd>",1, null);

System.out.println(cx.toString(result));


pw.println("Output :"+cx.toString(result));



}finally{Context.exit();}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
