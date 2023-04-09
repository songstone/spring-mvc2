package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("OK");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                               @RequestParam("age") Integer memberAge) throws IOException {
        log.info("username = {}, age = {}", memberName, memberAge);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(String username, Integer age) throws IOException {
        log.info("username = {}, age = {}", username, age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                 @RequestParam(defaultValue = "-1") Integer age) throws IOException {
        log.info("username = {}, age = {}", username, age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) throws IOException {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) throws IOException {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v12")
    public String modelAttributeV2(HelloData helloData) throws IOException {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "OK";
    }
}
