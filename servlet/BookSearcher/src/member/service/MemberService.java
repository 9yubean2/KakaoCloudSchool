package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {
    //로그인 처리하는 business mehtod
    public Member login(Member member) {

        //로그인이 되는지 확인하는 로직(DB 처리)
        //DB 처리를 위한 DAO 객체 필요
        MemberDAO dao = null;

        try {

            dao = new MemberDAO();
            member = dao.select(member);

        } catch (Exception e) {
            System.out.println(e);
        }

        return member;
    }
}
