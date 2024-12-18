package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@Autowired
	ProdService p1;
	
	@ResponseBody
	@GetMapping("/")
	public ArrayList<mobili> hello() {
		
		//p1.createMobile("poltrona", "Divani&Divani",180, "ciao1.jpeg");
		
		//p1.updatePrezzo("poltrona", 280);
		
		p1.updateUrl("poltrona", "ciacia.jpg");
		
		ArrayList<mobili> lista = p1.getAllProd();
		
		
		
		
		return lista;
		
		
		
	}
	

}
