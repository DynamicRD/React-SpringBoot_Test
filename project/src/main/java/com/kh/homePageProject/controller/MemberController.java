package com.kh.homePageProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.homePageProject.model.MemberVO;
import com.kh.homePageProject.model.ZipCodeVO;
import com.kh.homePageProject.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 모든 회원 조회
	@GetMapping
	public List<MemberVO> getAllMembers() {
		return memberService.getAllMembers();
	}

	// 회원 조회 (ID로)
	@GetMapping("/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return memberService.getMemberById(id);
	}

	// 회원 등록
	@PostMapping
	public void addMember(@RequestBody MemberVO member) {
		memberService.addMember(member);
	}

	// 회원 삭제
	@DeleteMapping("/{id}")
	public void deleteMember(@PathVariable String id) {
		memberService.deleteMember(id);
	}

	// 우편번호 조회
	@GetMapping("/zipcode/{dong}")
	public List<ZipCodeVO> getZipCodes(@PathVariable String dong) {
		return memberService.getZipCodes(dong);
	}

	// 회원 정보 업데이트
	@PutMapping("/{id}")
	public void updateMember(@PathVariable String id, @RequestBody MemberVO member) {
		member.setId(id);
		memberService.updateMember(member);
	}

	// 돈 차감
	@PutMapping("/{id}/minus-money")
	public void minusMoney(@PathVariable String id, @RequestParam int money) {
		memberService.minusMoney(id, money);
	}

	// 돈 추가
	@PutMapping("/{id}/add-money")
	public void addMoney(@PathVariable String id, @RequestParam int money) {
		memberService.addMoney(id, money);
	}

	// 회원 ID 찾기
	@PostMapping("/find-id")
	public MemberVO findMemberById(@RequestBody MemberVO member) {
		return memberService.findMemberById(member.getName(), member.getEmail(), member.getPhone());
	}

	// 비밀번호 찾기
	@PostMapping("/find-pass")
	public MemberVO findMemberByPass(@RequestBody MemberVO member) {
		return memberService.findMemberByPass(member.getId(), member.getEmail(), member.getPhone());
	}
}