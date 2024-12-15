package org.study.learnspring.request;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/basic")
public class RequestController {

    @GetMapping("/model/{id}")
    public String model(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("requestedAt", new Date().getTime());
        return "basic";
    }

    @GetMapping("/model-view/{id}")
    public ModelAndView modelAndView(@PathVariable String id, ModelAndView mv) {
        mv.addObject("id", id);
        mv.addObject("requestedAt", new Date().getTime());
        mv.setViewName("basic");
        return mv;
    }

    /**
     * @ModdelAttribute
     * - request paramters (form data, request body, query paramters)
     * - path variables
     * - headers
     */
    @GetMapping("/model-attribute/{id}")
    public String modelAndView(@ModelAttribute BasicRequest basicRequest, Model model) {
        model.addAttribute("id", basicRequest.getId());
        model.addAttribute("requestedAt", basicRequest.getRequestedAt());
        return "basic";
    }
}
