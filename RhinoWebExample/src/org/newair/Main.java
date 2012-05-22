package org.newair;

import java.lang.reflect.InvocationTargetException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;




public class Main {

	/**
	 * @param args
	 */
	
	
	
	private static String[] cmd = {"std = new Student(\"Ishara\",100); std.setAge(11000);"};
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
		// TODO Auto-generated method stub

		Context cx = Context.enter();
		
		try{
		Scriptable scope = cx.initStandardObjects();
		ScriptableObject.defineClass(scope, Student.class);
		
	/*	
		Object[] arg = {new String("amila"), new Integer(23)};
		
		Scriptable student =   cx.newObject(scope,"Student",arg); 
		scope.put("Student",scope,student);*/
		
		
		String s= "";
		
		for(int i=0; i < cmd.length;i++){
			
			
			s += cmd[i];
			
		}
	
		
		//evaluating a script
		
		
		Object result = cx.evaluateString(scope, s, "<cmd>",1, null);
		
		System.out.println(cx.toString(result));
		
		}finally{Context.exit();}
		
		
		
		
		
		
		
		
	}

}
