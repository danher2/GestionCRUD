package pildoras.es.controlador;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;




@Controller // le decimos que es nuestro controlador
@RequestMapping("/cliente") // con que url vamos a acceder? registrar las url con el mapeo correspondiente 
public class Controlador {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	@RequestMapping("/lista")
	public String listaClientes (Model elModelo) {
		
	//obtener los clientes desde el DAO
		List<Cliente> losclientes = clienteDAO.getClientes();
		
		
		//Agregar clientes al modelo
		
		elModelo.addAttribute("clientes", losclientes);
		
		
		return "lista-clientes";  //nos devuelve el jsp
		
		
	}
	
	@RequestMapping("/muestraFormularioAgregar") //mapeo al formulario para insertar registros, sigo teniendo duda?
	public String MuestraFormularioAgregar(Model elmodelo) {
		
		//creamos un objeto vacio
		Cliente elcliente =  new Cliente();
		
		// este seria para agregar los atribnutos del objeto al cliente
		elmodelo.addAttribute("cliente", elcliente);
		
		return "muestraFormularioAgregar"; //regresa el formulario
	}
	
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elcliente ) {
		
		// inserta cliente en la BBDD
		clienteDAO.insertarCliente(elcliente);
		
		
		
		return "redirect:/cliente/lista"; // redirecciona a la lista de cliente
	}
	
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam ("clienteId") int id, Model elModelo) {
		
		//obtener el cliente
		Cliente elcliente = clienteDAO.getCliente(id);
		
		//Establecer el cliente como atributo del modelo
		elModelo.addAttribute("cliente", elcliente);
		
		//enviar al formulario
		
			
		return "muestraFormularioAgregar"; //este que ?
		
		
	}
	
}
