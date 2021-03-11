package pildoras.es.dao;

import java.util.List;

import pildoras.es.controlador.entity.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente elcliente);

	public Cliente getCliente(int id);

}
