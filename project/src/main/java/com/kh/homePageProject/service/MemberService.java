package com.kh.homePageProject.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MemberMapper 인터페이스 import 추가
import com.kh.homePageProject.mapper.MemberMapper;

import com.kh.homePageProject.model.MemberVO;
import com.kh.homePageProject.model.ZipCodeVO;
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    // 모든 회원 조회
    public List<MemberVO> getAllMembers() {
        return memberMapper.selectAllMembers();
    }

    // 회원 조회 (ID로)
    public MemberVO getMemberById(String id) {
        return memberMapper.selectMemberById(id);
    }

    // 회원 ID 존재 여부 체크
    public boolean checkMemberExistById(String id) {
        return memberMapper.selectMemberCountById(id) > 0;
    }

    // 회원 등록
    public void addMember(MemberVO member) {
        memberMapper.insertMember(member);
    }

    // 회원 삭제
    public void deleteMember(String id) {
        memberMapper.deleteMember(id);
    }

    // 우편번호 조회
    public List<ZipCodeVO> getZipCodes(String dong) {
        return memberMapper.selectZipCode(dong);
    }

    // 회원 정보 업데이트
    public void updateMember(MemberVO member) {
        memberMapper.updateMember(member);
    }

    // 돈 차감
    public void minusMoney(String id, int money) {
        memberMapper.minusMoney(Map.of("id", id, "money", money));
    }

    // 회원 ID 찾기 (이름, 이메일, 전화번호로)
    public MemberVO findMemberById(String name, String email, String phone) {
        return memberMapper.findMemberById(name, email, phone);
    }

    // 비밀번호 찾기 (ID, 이메일, 전화번호로)
    public MemberVO findMemberByPass(String id, String email, String phone) {
        return memberMapper.findMemberByPass(id, email, phone);
    }

    // 돈 추가
    public void addMoney(String id, int money) {
        memberMapper.addMoney(Map.of("id", id, "money", money));
    }
}