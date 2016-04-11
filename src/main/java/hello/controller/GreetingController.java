package hello.controller;

import hello.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {
    Logger logger = LoggerFactory.getLogger(GreetingController.class) ;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/")
  //  @ResponseBody
    public String  greeting(
            Post post,
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        logger.info("==== in greeting ====");
        return "index" ;
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","飞飞—");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        return "result";
    }

}