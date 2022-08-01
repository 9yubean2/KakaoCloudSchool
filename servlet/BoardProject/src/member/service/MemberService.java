package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

import java.sql.SQLException;

public class MemberService {
    public Member login (Member member) throws Exception {

        Member result = null;

        MemberDAO dao = new MemberDAO();

        result = dao.selectMember(member);

        return result;
    }

    public int signup (Member member) throws Exception {

        int result = 0;

        MemberDAO dao = new MemberDAO();

        result = dao.insertMember(member);

        return result;
    }
}
