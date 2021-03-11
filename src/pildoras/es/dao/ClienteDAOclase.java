package pildoras.es.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pildoras.es.controlador.entity.Cliente;


@Transactional // para hacer las transacciones y se ejecuten como una unidad
@Repository // para que Spring reconozxa esto como un bean
public class ClienteDAOclase implements ClienteDAO {
	
	
	@Autowired // ---> inyeccion de dependencias para utilizar el sessionFactory
	private SessionFactory sessionFactory;
	

	@Override
	public List<Cliente> getClientes() {
		
		
		//obtener la session
		Session misesion =sessionFactory.getCurrentSession(); // ya tenemos la sesion actual
		
		//Crear la consulta
		Query<Cliente> miquery = misesion.createQuery("from Cliente",Cliente.class);
		
		//ejecutar la query y devolver los resultado
		List<Cliente> clientes = miquery.getResultList();
		
		return clientes;
	}


	@Override
	public void insertarCliente(Cliente elcliente) {
		//obtener la session
				Session misesion =sessionFactory.getCurrentSession(); // ya tenemos la sesion actual
				
		// insertar por fin el maldito cliente
				//misesion.save(elcliente);
				misesion.saveOrUpdate(elcliente); // un mismo boton de formulario hace dos tareas
	}


	@Override
	public Cliente getCliente(int id) {
		
		//obtener la session 
		Session misesion =sessionFactory.getCurrentSession(); // ya tenemos la sesion actual
		
		//obtener la informacion del cliente seleccionado
		Cliente elcliente = misesion.get(Cliente.class, id);
		
		
		return elcliente;
	}

}
