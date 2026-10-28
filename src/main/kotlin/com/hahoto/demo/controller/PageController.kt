package com.hahoto.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController {

	@GetMapping("/")
	fun index(): String = "forward:/index.html"

	@GetMapping("/app")
	fun app(): String = "forward:app/index.html"
}
