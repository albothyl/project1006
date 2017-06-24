package com.project.kanban.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		log.info("come in initial controller");

		ModelAndView mav = new ModelAndView("/hello");
		mav.addObject("Title", "Kanban");
		mav.addObject("Content", "Hello Kanban");

		return mav;
	}
}
