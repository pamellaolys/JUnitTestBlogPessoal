package br.com.generation.blogpessoal.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/soma/{num1}/{num2}")
	public int getBySoma (@PathVariable int num1 , @PathVariable int num2) {
		return num1+num2 ;
}
	@GetMapping("/sub/{num1}/{num2}")
	public int getBySub (@PathVariable int num1 , @PathVariable int num2) {
		return num1-num2 ;
}
	@GetMapping("/mult/{num1}/{num2}")
	public int getByMult (@PathVariable int num1 , @PathVariable int num2) {
		return num1*num2 ;
}
	@GetMapping("/div/{num1}/{num2}")
	public int getByDiv (@PathVariable int num1 , @PathVariable int num2) {
		return num1/num2 ;
	}
}
		