package assignment2_server_14068171.server;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 https://www.baeldung.com/spring-request-response-body
 */

@Controller
@RequestMapping(value = "/")
@SessionAttributes({"sessionName", "sessionId", "sessionGame"})
public class TestController {

    TTT ttt = new TTT();

    ClassSimple classSimple = new ClassSimple();



    // TESTING METHOD
    @RequestMapping({"", "/index"})
    public String index(Model model, ModelMap modelMap, HttpSession httpSession, HttpServletRequest httpServletRequest) {

        model.addAttribute("sessionName", "sessionName1");
        modelMap.addAttribute("sessionId", "sessionIdValue");

        model.addAttribute("normalName1", "normalValue1");

        model.asMap().get("normalName1");

        modelMap.addAttribute("mapAttributeName1", "mapAttributeValue1");

/*
        model.addAttribute("classSimple1", new ClassSimple());

        Object value = httpServletRequest.getSession().getAttribute("key");

           to use this session, modify parameters ->  public String index(Model model, HttpSession httpSession) {
           but MVC model only communicates with model, not session
        // https://www.thymeleaf.org/doc/articles/springmvcaccessdata.html


        httpSession.setAttribute("httpsessionName1", "httpsessionValue1");
        httpSession.setAttribute("sessionGame", new ClassSimple());
        System.out.println("httpSession.getId() = " + httpSession.getId()); // 1CBD818761412131F569EA9C3EBEDA26, return this key to client to use.


         */


//        return "redirect:/ttt";
//        return "redirect:/error";
        return "index";
    }


    @RequestMapping(value = "/ttt/3", method = RequestMethod.GET)
    @ResponseBody
    public TTT ttt3(ModelMap modelMap) {

        TTT ttt = (TTT) modelMap.get("sessionGame");

        ttt = new TTT();

        ttt.movePlayer(1, 2);
        ttt.movePlayer(2, 1);
        ttt.movePlayer(2, 3);
        ttt.movePlayer(3, 2);

        ttt.movePlayer(1, 1);
        ttt.movePlayer(3, 3);
        ttt.movePlayer(1, 3);
        ttt.movePlayer(3, 1);
        ttt.movePlayer(2, 2);

        ttt.printBoard();


        modelMap.addAttribute("sessionGame", ttt);
        modelMap.get("sessionGame");
//        return ttt;
        return (TTT) modelMap.get("sessionGame");
    }


    @RequestMapping(value = "/ttt/4", method = RequestMethod.GET)
    @ResponseBody
    public char[][] t4(ModelMap modelMap) {

        TTT ttt = (TTT) modelMap.get("sessionGame");

        ttt = new TTT();

        ttt.movePlayer(1, 2);
        ttt.movePlayer(2, 1);
        ttt.movePlayer(2, 3);
        ttt.movePlayer(3, 2);

        ttt.movePlayer(1, 1);
        ttt.movePlayer(3, 3);
        ttt.movePlayer(1, 3);
        ttt.movePlayer(3, 1);
        ttt.movePlayer(2, 2);

        ttt.printBoard();


        modelMap.addAttribute("sessionGame", ttt);
        modelMap.get("sessionGame");
//        return ttt;
        return (char[][]) ((TTT) modelMap.get("sessionGame")).getBoard();
    }


    @RequestMapping("/s1")
    public void s1(Model model) {
        model.addAttribute("sessionId", "sessionId1");

    }

    @RequestMapping("/s2")
    public void s2(Model model) {
        model.addAttribute("sessionId", "sessionId2");
    }


    int counter = 0;

    @RequestMapping("/s3")
    public String s3(Model model) {
        model.addAttribute("sessionId", ++counter);
        return "ttt";
    }


    @RequestMapping(value = "/p", method = RequestMethod.GET)
    @ResponseBody
    public void p(ModelAndView modelAndView, HttpSession httpSession, HttpServletRequest httpServletRequest, Model model, ModelMap modelMap) {
        TestController.printSession(httpSession, httpServletRequest, modelAndView, model, modelMap);
    }


    @RequestMapping(value = "/t", method = RequestMethod.GET)
    @ResponseBody
    public TTT t(ModelMap modelMap) {
        return (TTT) modelMap.get("sessionGame");
    }

















    @RequestMapping(value = "/0", method = RequestMethod.GET)
    public String t0( String sessionName) {
        return sessionName;
    }


    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public ClassSimple t1() {
        return classSimple;
    }


    // create a new game, user starts
    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public char[][] t2() {
        return ttt.getBoard();
    }

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public TTT t3() {


        ttt = new TTT();

        ttt.movePlayer(1, 2);
        ttt.movePlayer(2, 1);
        ttt.movePlayer(2, 3);
        ttt.movePlayer(3, 2);

        ttt.movePlayer(1, 1);
        ttt.movePlayer(3, 3);
        ttt.movePlayer(1, 3);
        ttt.movePlayer(3, 1);
        ttt.movePlayer(2, 2);

        ttt.printBoard();

        return ttt;
    }


    @RequestMapping(value = "/4", method = RequestMethod.POST)
    public TTT t4(@RequestBody JsonNode JsonNode) {

        return ttt;
    }



    // http://localhost:8080/5?sessionId=sthnadie
    @RequestMapping(value = "/5", method = RequestMethod.GET)
    public String t5(@RequestParam("sessionId") String sessionId) {
        return sessionId;
    }


    // path variable
    @RequestMapping(value = "/6/{id}", method = RequestMethod.GET)
    public String t6(@PathVariable String id) {
        return id;
    }

    // https://www.baeldung.com/spring-request-param
    @RequestMapping(value = "/7", method = RequestMethod.POST)
    public String test7(@RequestBody String string1, @RequestParam("param1") String param1, @RequestParam String param2) {

        return string1 + " AND " +  param1 + " AND " + param2;
    }

    @RequestMapping(value = "/8", method = RequestMethod.POST)
    public String test8(@RequestBody String body, @RequestParam("param") String param) {

        return body + " AND " +  param;
    }



    @RequestMapping(value = "/9", method = RequestMethod.GET)
    public void t9(HttpSession httpSession, HttpServletRequest httpServletRequest, ModelAndView modelAndView, Model model, ModelMap modelMap) {
        printSession(httpSession, httpServletRequest, modelAndView, model, modelMap);
    }



    // bad request test
    @RequestMapping(value = "/10/{param}", method = RequestMethod.GET)
    @ResponseBody
    public String t10(@PathVariable String param) {
        if(param.equals("0")){
            return "param=0";
        }
        return param;
    }


    @RequestMapping(value = "/11", method = RequestMethod.GET)
    public void t11() {

    }



    public static void printSession(HttpSession httpSession, HttpServletRequest httpServletRequest, ModelAndView modelAndView, Model model, ModelMap modelMap){
        System.out.println("httpSession.getId() = " + httpSession.getId());
        System.out.println("httpServletRequest.getSession().getId() = " + httpServletRequest.getSession().getId());
        System.out.println("modelAndView.getModel().get(\"sessionName\") = " + modelAndView.getModel().get("sessionName")); // null
        System.out.println("modelAndView.getModelMap().get(\"sessionName\") = " + modelAndView.getModelMap().get("sessionName")); // null
        System.out.println("modelMap.get(\"sessionName\") = " + modelMap.get("sessionName")); // sessionName1
        System.out.println("model.asMap().get(\"sessionName\") = " + model.asMap().get("sessionName")); // sessionName1
        System.out.println("model.asMap().get(\"normalName\") = " + model.asMap().get("normalName"));
        System.out.println("httpSession.getAttribute(\"httpsessionName1\") = " + httpSession.getAttribute("httpsessionName1"));
        System.out.println("httpServletRequest.getSession().getAttribute(\"httpsessionName1\") = " + httpServletRequest.getSession().getAttribute("httpsessionName1"));
        System.out.println("model.asMap().get(\"mapAttributeName1\"); = " + model.asMap().get("mapAttributeName1"));
        System.out.println("model.asMap().get(\"sessionId\") = " + model.asMap().get("sessionId"));


        System.out.println("modelMap.get(\"uninitializedSessionName\") = " + modelMap.get("uninitializedSessionName")); // null
    }
}
