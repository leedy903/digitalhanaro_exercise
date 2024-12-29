package org.conan.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Log4j
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String home(Locale locale, Model model) {
        log.info("Welcome home! The client locale is {}." + locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formatedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formatedDate);

        return "hello";
    }

}

