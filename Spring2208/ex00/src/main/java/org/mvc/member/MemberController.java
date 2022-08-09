package org.mvc.member;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/member/loginForm")
	public String loginForm() {
		
		return "member/loginForm";
		//view
		//folder/filename까지만 명시해주면 된다.
	}
	
	
	@RequestMapping("/member/loginPro")
	public String loginPro(MemberDTO dto, Model model,String id, String pw,HttpServletRequest req) {
		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(req.getParameter("id"));
//		System.out.println(req.getParameter("pw"));
//		System.out.println(dto.getId());
//		System.out.println(dto.getPw());
		
		model.addAttribute("count",100);
		model.addAttribute("msg","hello world");
		model.addAttribute("time",new Date());
		
		model.addAttribute("dto",dto);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		
		model.addAttribute("list",list);
		
		return "member/loginPro";
	}

}