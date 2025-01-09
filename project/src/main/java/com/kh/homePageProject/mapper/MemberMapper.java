package com.kh.homePageProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.homePageProject.model.MemberVO;
import com.kh.homePageProject.model.ZipCodeVO;

@Mapper
public interface MemberMapper {
	  // 모든 회원 조회
    List<MemberVO> selectAllMembers();
    
    // 회원 조회 (ID로)
    MemberVO selectMemberById(String id);
    
    // 회원 ID 존재 여부 체크
    int selectMemberCountById(String id);
    
    // 회원 등록
    void insertMember(MemberVO member);
    
    // 회원 삭제
    void deleteMember(String id);
    
    // 우편번호 조회
    List<ZipCodeVO> selectZipCode(String dong);
    
    // 회원 정보 업데이트
    void updateMember(MemberVO member);
    
    // 돈 차감
    void minusMoney(Map<String, Object> params);
    
    // 회원 ID 찾기 (이름, 이메일, 전화번호로)
    MemberVO findMemberById(String name, String email, String phone);
    
    // 비밀번호 찾기 (ID, 이메일, 전화번호로)
    MemberVO findMemberByPass(String id, String email, String phone);
    
    // 돈 추가
    void addMoney(Map<String, Object> params);
}
