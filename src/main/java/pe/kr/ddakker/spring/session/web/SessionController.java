package pe.kr.ddakker.spring.session.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SessionController {

    @RequestMapping("/")
    public String index(HttpSession session, Model model) {
        Map<String, Object> sessionMap = new HashMap<>();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            sessionMap.put(key, session.getAttribute(key));
        }
        model.addAttribute("sessionMap", sessionMap);
        return "index";
    }

    @RequestMapping("/set")
    @ResponseBody
    public void set(HttpServletResponse res, HttpSession session, @RequestParam("key") String key, @RequestParam("value") String value) throws IOException {
        session.setAttribute(key, value);
        res.sendRedirect("/");
    }

    @RequestMapping("/invalidate")
    public void invalidate(HttpServletResponse res, HttpSession session) throws IOException {
        session.invalidate();

        res.sendRedirect("/");
    }
}