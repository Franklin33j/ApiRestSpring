package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Cuando entro a la ruta http://localhost:8080/ me redireccina a swagger este controlador*/

@RestController
@RequestMapping("/")
public class RedirectController {

	@GetMapping
	public void handleRequest(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui/");
    }
}
