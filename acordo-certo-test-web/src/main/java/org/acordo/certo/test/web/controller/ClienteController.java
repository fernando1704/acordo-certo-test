package org.acordo.certo.test.web.controller;

import javax.validation.Valid;

import org.acordo.certo.test.domain.entity.Cliente;
import org.acordo.certo.test.domain.model.AjaxResponseBody;
import org.acordo.certo.test.domain.repository.ClienteRepository;
import org.acordocerto.test.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteServiceImpl clienteServiceImpl;

	@GetMapping(value = "/")
	public ModelAndView adicionar() {
		ModelAndView mv = new ModelAndView("clientes/adicionar");
		mv.addObject("cliente", new Cliente());
		return mv;
	}

	@PostMapping(value = "/clientes/adicionar")
	@ResponseBody
	public ResponseEntity<?> adicionar(@Valid Cliente cliente, Errors errors) {

		AjaxResponseBody ajaxResult = new AjaxResponseBody();
		
		System.out.println(cliente.getNome());

		if (errors.hasErrors()) {
			
			String mensagemErro = "Erro ao salvar o cliente, os seguintes erros foram encontrados: ";
			for(ObjectError error : errors.getAllErrors()) {
				mensagemErro = mensagemErro.concat(error.getDefaultMessage()+", ");
			}
			
			ajaxResult.setMsg(mensagemErro);
			ajaxResult.setResultado("0");
			return ResponseEntity.ok(ajaxResult);
		}

		clienteServiceImpl.saveCliente(cliente);
		ajaxResult.setMsg("Cliente criado com sucesso");
		ajaxResult.setResultado("1");
		return ResponseEntity.ok(ajaxResult);
	}
}
