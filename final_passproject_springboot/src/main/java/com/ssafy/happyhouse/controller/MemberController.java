package com.ssafy.happyhouse.controller;

import java.io.Console;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.model.service.MemberService;

//@Controller
//@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	ServletContext servletContext;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인");
		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response, @RequestParam String userid, @RequestParam String userpwd)
			throws SQLException {
		System.out.println("로그인 기능");

//			MemberDto memberDto = userService.login(map);
		try {
			Member memberDto = memberService.login(map);
			//System.out.println(memberDto.toString());
			if (memberDto != null) {
				session.setAttribute("userinfo", memberDto);

				Cookie cookie = new Cookie("ssafy_id", memberDto.getId());
				cookie.setPath("/");
				if ("saveok".equals(map.get("idsave"))) {
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);// 40년간 저장.
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);

			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/memberinfo", method = RequestMethod.GET)
	public String list(HttpSession session) {
		System.out.println("회원정보");

		Member member = (Member) session.getAttribute("userinfo");
		Member m = memberService.searchId(member.getId());
//		System.out.println(m.toString());
		if (m != null) {
			return "member/memberInfo";
		}

		return "index";
	}

	@RequestMapping(value = "/modifymem", method = RequestMethod.GET)
	public String moveupdateform() {
		System.out.println("수정");
		return "member/modifyMember";
	}

	@RequestMapping(value = "/insertMemberform", method = RequestMethod.GET)
	public String moveinserform() {
		return "member/insertMember";
	}

	@RequestMapping(value = "/modifyMember.do", method = RequestMethod.POST)
	public String update(@RequestParam String modify_username, @RequestParam String modify_userpwd,
			@RequestParam String modify_emailid, @RequestParam String modify_tel1, @RequestParam String modify_tel2,
			@RequestParam String modify_tel3, @RequestParam String modify_address,
			@RequestParam String modify_address_detail, HttpSession session) {
		Member member = (Member) session.getAttribute("userinfo");
		System.out.println(member.getId().toString() + "수정가즈아");
		String phone = modify_tel1.concat("-").concat(modify_tel2).concat("-").concat(modify_tel3);
		String full_addr = modify_address.concat(modify_address_detail);

		Member m = new Member(member.getId(),modify_userpwd, modify_username, modify_emailid, phone, full_addr);
		System.out.println(m.toString());
		memberService.update(m);

		return "index";
	}
	
	@RequestMapping(value = "/removeMemberform.do", method = RequestMethod.GET)
	public String remove(HttpSession session) {
		System.out.println("삭제");
		Member member = (Member) session.getAttribute("userinfo");
//		System.out.println(m.toString());
		
		memberService.remove(member.getId());

		return "index";
	}

	@RequestMapping(value = "/insertMember.do", method = RequestMethod.POST)
	public String insertMember(@RequestParam String username, @RequestParam String userid, @RequestParam String userpwd,
			@RequestParam String emailid, @RequestParam String tel1, @RequestParam String tel2,
			@RequestParam String tel3, @RequestParam String address, @RequestParam String address_detail,
			@RequestParam String interestarea) {

		String phone = tel1.concat("-").concat(tel2).concat("-").concat(tel3);
		String full_addr = address.concat(address_detail);

		Member m = new Member(username, userid, userpwd, emailid, phone, full_addr);
		memberService.insertMember(m);

		return "index";
	}
}
