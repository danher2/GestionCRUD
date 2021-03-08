package pildoras.es.controlador;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
