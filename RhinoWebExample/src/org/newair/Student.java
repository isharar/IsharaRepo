package org.newair;

import org.mozilla.javascript.ScriptableObject;




public class Student extends ScriptableObject{

	private String name;
	private int age;
	
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return "Student";
	}

	public void jsConstructor(String name,int age){
		//this is the constructor which is mapped when javascript object is created
		
		this.name = name;
		this.age = age;
		
		
	}
	
	public int jsGet_reduceAge(){
	// age is a dynamic property	
		return --age;
				
	}
	
	public int jsFunction_setAge(int age){
		//this is a function
		this.age = age;
		
		return age;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
