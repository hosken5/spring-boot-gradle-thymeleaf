package hello.controller;

import hello.domain.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {
    Logger logger = LoggerFactory.getLogger(GreetingController.class) ;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/")
    @ResponseBody
    public Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        logger.info("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}