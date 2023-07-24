package by.springcourse.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

/**
 * @author Alexey Bobrykov
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {

//        System.out.println("Hello " + name + " " + surname);
        String toView = "Hello " + name + " " + surname;
        model.addAttribute("message", toView);

        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) String a,
                             @RequestParam(value = "b", required = false) String b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        String res;
        if (a != null && b != null && action != null) {
            res = String.valueOf(calc(a, b, action));
        } else {
            res = "No result";
        }

        model.addAttribute("result", action + " " + a + " and " + b + ": " + res);
        return "first/calculator";
    }

    public double calc(String num_a, String num_b, String action) {
        int a = Integer.parseInt(num_a);
        int b = Integer.parseInt(num_b);
        double result;
        switch (action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
