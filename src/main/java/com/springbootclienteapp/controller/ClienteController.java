package com.springbootclienteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootclienteapp.models.entity.Ciudad;
import com.springbootclienteapp.models.entity.Cliente;
import com.springbootclienteapp.service.ICiudadService;
import com.springbootclienteapp.service.IClienteService;

@Controller
@RequestMapping("/views/clientes") // folders to reach
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ICiudadService ciudadService;
	
	@GetMapping("/")	
	public String listarClientes(Model model) {
		
		List <Cliente> listadoClientes = (List<Cliente>) clienteService.listarTodos();
		model.addAttribute("clientes", listadoClientes);
		model.addAttribute("titulo", "Lista de Clientes");
		System.out.println(model);
		return "/views/clientes/listar";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		Cliente cliente = new Cliente(); // debería clienteService retornar un objeto nuevo !
		List <Ciudad> listCiudades = ciudadService.listaCiudades();		
		model.addAttribute("titulo", "Formulario: Nuevo Cliente");
		model.addAttribute("cliente", cliente);
		model.addAttribute("ciudades", listCiudades);
		return "/views/clientes/frmCrear";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Cliente cliente) {
		clienteService.guardar(cliente);
		System.out.println("El registro ha sido guardado con exito");
		return "redirect:/views/clientes/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idCliente, Model model) {
		Cliente cliente = clienteService.buscarPorId(idCliente);
		List <Ciudad> listCiudades = ciudadService.listaCiudades();		
		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("cliente", cliente);
		model.addAttribute("ciudades", listCiudades);
		return "/views/clientes/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idCliente) {
		Cliente cliente = clienteService.buscarPorId(idCliente);
		clienteService.eliminar(idCliente);
		System.out.println("El registro fue eliminado con exito");
		return "redirect:/views/clientes/";
	}
	
	
}
