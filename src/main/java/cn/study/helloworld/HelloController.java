package cn.study.helloworld;

import cn.study.dao.table.entity.User;
import cn.study.dao.table.entity.UserExample;
import cn.study.dao.table.mapper.UserMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by jamci on 2/2/18.
 */
@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/index/hello")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","hello World");
        modelAndView.setViewName("index");
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        List<User> users =  userMapper.selectByExample(userExample);
        if (!users.isEmpty())
            modelAndView.addObject("userName",users.get(0).getUserName());
        return modelAndView;
    }
}