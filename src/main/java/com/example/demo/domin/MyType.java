package com.example.demo.domin;

import com.example.demo.core.EnumShow;

public enum MyType  implements EnumShow{
	
	lijin(1,"男"),
	chen(0,"女"),
	mei(3,"德国");
	
	private int code;
	private String name;
	
	
	
	 public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	MyType(int code,String name) {
		this.code=code;
		this.name=name;
	}
	 
	 public static MyType getNameByCode(int stateCode){
	        for (MyType stateEnum: values()){
	            if(stateEnum.getCode()== stateCode){
	                return stateEnum;
	            }

	        }
	        return null;
	    }

}
