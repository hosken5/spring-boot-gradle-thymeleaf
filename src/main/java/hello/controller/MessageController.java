package hello.controller;

import hello.domain.Greeting;
import hello.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongpf on 16/4/13.
 */
@Controller
public class MessageController {


    @RequestMapping("/websocket")
    public String websocket(){
        return "/websocket/websockettest";
    }


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting(0,"Hello, " + message.getName() + "!");
    }

}
