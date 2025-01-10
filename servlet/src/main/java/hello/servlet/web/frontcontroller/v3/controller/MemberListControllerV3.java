package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelVeiw;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelVeiw process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelVeiw mv = new ModelVeiw("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
