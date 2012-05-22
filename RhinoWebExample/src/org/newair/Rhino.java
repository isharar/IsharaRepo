package org.newair;


import java.lang.reflect.InvocationTargetException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;




public class Rhino implements Runnable{

	private String code ;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
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
		
		
		Object[] arg = {new String("amila"), new Integer(23)};
		
		Scriptable student =   cx.newObject(scope,"Student",arg); 
		scope.put("Student",scope,student);
		
		
		String s= "";
		
		for(int i=0; i < cmd.length;i++){
			
			
			s += cmd[i];
			
		}

		
		//evaluating a script
		
		
		Object result = cx.evaluateString(scope, s, "<cmd>",1, null);
		
		System.out.println(cx.toString(result));
		
		}finally{Context.exit();}
		
	}
	
	public void setcode(String code){
		
		this.code = code;
		
	}
	
	
	public String getcode(){
		
		return code;
		
	}
	
	
	
}


