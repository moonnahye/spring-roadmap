package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelVeiw;

import java.util.Map;

public interface ControllerV3 {

    ModelVeiw process(Map<String, String> paramMap);

}
