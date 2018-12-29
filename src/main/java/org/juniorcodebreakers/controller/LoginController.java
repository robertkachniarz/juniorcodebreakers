package org.juniorcodebreakers.controller;

import org.juniorcodebreakers.model.User;
import org.juniorcodebreakers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView entryPage(ModelAndView modelAndView){
        modelAndView.setViewName("users/entrypage");
        return modelAndView;
    }

    @RequestMapping(value={"/users/login"}, method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("users/login");
        return modelAndView;
    }

    @RequestMapping(value="/myaccount", method = RequestMethod.GET)
    public ModelAndView userHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject(user);
        modelAndView.addObject("role", user.getRoles().stream().findFirst().get().getRole());
        modelAndView.setViewName("users/menuhtml/myaccount");
        return modelAndView;
    }


}

