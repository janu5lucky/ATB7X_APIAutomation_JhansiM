package com.api.qa;

public class BuilderPattern_ex_01 {

	
	public BuilderPattern_ex_01 Step1() {
		System.out.println("Step1");
		return this;
	}
	public BuilderPattern_ex_01 Step2(String Name) {
		System.out.println("Step2");
		return this;
	}
	public BuilderPattern_ex_01 Step3() {
		System.out.println("Step3");
		return this;
	}
	
	public static void main(String[] args) {
		BuilderPattern_ex_01 bp = new BuilderPattern_ex_01();
		bp.Step1().Step2("Jhansi").Step3();
		
		// TODO Auto-generated method stub

	}

}
