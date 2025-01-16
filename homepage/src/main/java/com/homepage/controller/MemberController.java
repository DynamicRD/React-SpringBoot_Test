package com.homepage.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.homepage.domain.Member;
import com.homepage.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
@MapperScan(basePackages = "com.homepage.mapper")
public class MemberController {
	// 서비스를 이용해서 접근
	@Autowired
	private MemberService service;

	@RequestMapping(value="/loginCheck",method = RequestMethod.POST)
	public String loginCheck(Model model,String id,String password) throws Exception{
		Member member = new Member();
		member.setId(id);
		member.setPass(password);
		
		
		return null;
	}
	
	
	
	//게시판 입력 폼 요청(views/board/register.jsp)
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public void registerForm(Member member, Model model) throws Exception {
			log.info("registerForm");
		}

		//게시판 입력내용 저장 성공메세지를 (/WEB-INF/views/boardsuccess.jsp)
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String register(Member member, Model model) throws Exception {
			//자식의 객체를 불러서 사용한다(다형성)
			service.register(member);
			model.addAttribute("msg", "등록이 완료되었습니다.");
			return "board/success";
		}

		//게시판 전체리스트를 요청하고 -> 전체리스트를 가져와서 -> (/WEB-INF/views/boardlist.jsp) 화면에 전달한다 
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public void list(Model model) throws Exception {
			log.info("list");
			model.addAttribute("list", service.list());
		}

		//게시글 상세내용 글 요청 -> 한개 게시판 정보를 가져와서 -> (/WEB-INF/views/boardread.jsp) 화면에 전달한다 
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void read(Member member, Model model) throws Exception {
			model.addAttribute(service.read(member));
		}
		
		//게시글 삭제요청 -> 게시글 삭제진행 -> 결과화면 성공메시지를 (/WEB-INF/views/boardsuccess.jsp)
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		public String remove(Member member, Model model) throws Exception {
			service.remove(member);
			model.addAttribute("msg", "삭제가 완료되었습니다.");
			return "board/success";
		}

		//게시글 수정하기 위한 화면요청 -> 해당된게시글들 가져와서 -> (/WEB-INF/views/boardmodify.jsp) 화면에 전달한다
		@RequestMapping(value = "/modify", method = RequestMethod.GET)
		public void modifyForm(Member member, Model model) throws Exception {
			model.addAttribute(service.read(member));
		}

		//게시글 수정내용을 DB저장요청 -> 수정된 게시글 수정완료
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String modify(Member member, Model model) throws Exception {
			service.modify(member);
			model.addAttribute("msg", "수정이 완료되었습니다.");
			return "board/success";
		}

}
