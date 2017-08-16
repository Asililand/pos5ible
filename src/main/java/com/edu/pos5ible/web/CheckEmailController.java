package com.edu.pos5ible.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.pos5ible.util.JsonResult;

@Controller
@RequestMapping("/e")
public class CheckEmailController extends BaseController{

	@ResponseBody
	@RequestMapping("/ce")
	public Object checkEmail(String name, String email, HttpServletResponse response) {
		if (checkEmailService.checkEmail(name, email)) {
			try {
				response.sendRedirect("/util/checkEmail/checkEmailSuccess.html");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(e.getMessage());
			}
		}
		try {
			response.sendRedirect("/util/checkEmail/checkEmailDefeat.html");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e.getMessage());
		}
	}
}
