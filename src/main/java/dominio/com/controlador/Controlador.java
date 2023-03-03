package dominio.com.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dominio.com.controlador.entity.Cliente;
import dominio.com.dao.ClienteDao;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	ClienteDao clienteDao;
	
	@RequestMapping("/lista")
	public String vistaClientes(Model elModelo) {
		//Obtener los clientes desde el DAO
		List<Cliente> losClientes = clienteDao.getClientes();
		
		//Agregar los clientes al modelo
		elModelo.addAttribute("clientes",losClientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/form-agregar-cliente")
	public String agregarClientes(Model elModelo) {
		
		//Bind datos de los clientes
		Cliente elCliente = new Cliente();
		
		elModelo.addAttribute("cliente",elCliente);
		elModelo.addAttribute("valorButton","Insertar");
		
		return "formularioAgregarCliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		
		//Insertar cliente en BD
		clienteDao.insertarCliente(elCliente);
		
		
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/form-editar-cliente")
	public String editarCliente(@RequestParam("clienteId")int Id, Model elModelo) {
		
		//Obtener el cliente
		Cliente elCliente= clienteDao.getCliente(Id);
		
		//Establecer al cliente como atributo del modelo
		elModelo.addAttribute("cliente",elCliente);
		elModelo.addAttribute("valorButton","Modificar");
		
		//Enviar al formulario
		
		return "formularioAgregarCliente";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId")int Id) {
		
		//Eliminar el cliente
		clienteDao.eliminarcliente(Id);
		
		
		//Redireccionar a la lista de clientes	
		return "redirect:/cliente/lista";
	}
}
