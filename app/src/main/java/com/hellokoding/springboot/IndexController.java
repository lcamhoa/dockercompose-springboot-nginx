package com.hellokoding.springboot;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class IndexController {
	
    @GetMapping("/")
    public String index(@RequestHeader Map<String,String> httpHeader,
    		@ModelAttribute("model") ModelMap model) {
    	List<String> headers = httpHeader.entrySet()
    			.stream()
    			.map(e -> e.getKey() + "," + e.getValue())
    			.collect(Collectors.toList());
    	model.addAttribute("words", headers);
        return "index";
    }
}
