package assignment2_server_14068171.server;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


/*
https://www.baeldung.com/spring-boot-custom-error-page
Spring Boot: Customize Whitelabel Error Page

 */

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String error(Model model, HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        model.addAttribute("errorCode", "404 Not Found");

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                model.addAttribute("errorCode", "400 Bad Request");
            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("errorCode", "404 Not Found");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("errorCode", "500 Internal Server Error");
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
