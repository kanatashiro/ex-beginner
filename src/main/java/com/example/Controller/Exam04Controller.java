package com.example.Controller;






import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;


@Controller
@RequestMapping("/exam04")

public class Exam04Controller {
	
@ModelAttribute
public UserForm setupForm() {
	return new UserForm();
}
	
@RequestMapping(" ")
public String index(Model model) {
	return "exam04";	
}


@RequestMapping("/result")
public String result(@Validated UserForm userForm,BindingResult result,  RedirectAttributes redirectAttributes,Model model) {
	if(result.hasErrors()) {
		return index(model);
	}
	User user = new User();
	BeanUtils.copyProperties(userForm, user);
//	user.setName(userForm.getName());
//	user.setAge(userForm.getAge());
//	user.setComment(userForm.getComment());
	redirectAttributes.addFlashAttribute("user",user);
	
	return "redirect:/exam04/answer";
}
@RequestMapping("/answer")
public String answer() {
	
	return "exam04-result";
}


}



