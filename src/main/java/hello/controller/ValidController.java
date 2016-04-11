package hello.controller;

import hello.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Validator;
import java.util.Set;

/**
 * Created by hongpf on 16/4/11.
 */
@Controller
public class ValidController {

    Logger logger = LoggerFactory.getLogger(ValidController.class) ;

    @Autowired
    Validator validator ;


    @RequestMapping("/valid")
    @ResponseBody
    public Object get(Post post){
        logger.info(post.getContent()+":"+post.getTitle());
        Set constraintViolations = validator.validate(post);
        logger.info(constraintViolations.toString());
        if(constraintViolations.size()>0){
            return  "错误:"+constraintViolations ;
        }else{
            return "正确!" ;
        }
    }
}
