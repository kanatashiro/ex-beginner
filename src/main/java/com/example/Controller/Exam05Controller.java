package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;



@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	@Autowired
	private MemberRepository repository;
	
	@RequestMapping(" ")
	public String index() {
		
		return "exam05";
	}
	
	@RequestMapping("/result")
	private String result(String name,Model model) {
		List<Member> memberList=repository.findByName(name);
		model.addAttribute("memberList",memberList);
		System.out.println(memberList);
		return "exam05-result";
	
		
	}
	

	}
	

