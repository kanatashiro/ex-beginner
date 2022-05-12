package com.example.Controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

@Autowired
private ServletContext application;

@RequestMapping(" ")
public String index() {
	return "exam03";
	
}
	
@RequestMapping("/result")
public String result(int num1,int num2,int num3) {
	application.setAttribute("num1", num1);
	application.setAttribute("num2", num2);
	application.setAttribute("num3", num3);
	int zeinuki=num1+num2+num3;
	application.setAttribute("zeinuki", zeinuki);
	double zeikomi=(num1+num2+num3)*1.10;
	application.setAttribute("zeikomi",(int)zeikomi);

	return "exam03-result";
}


	
	
}
