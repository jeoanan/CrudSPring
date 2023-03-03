package dominio.com.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.com.controlador.entity.Cliente;

@Repository
public class ClienteDaoClase implements ClienteDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		//Obtener la sesion
		Session miSesion = sessionFactory.getCurrentSession();
		
		//Crear la consulta
		Query<Cliente> miConsulta= miSesion.createQuery("FROM Cliente", Cliente.class);
		
		List<Cliente> clientes = miConsulta.getResultList();
		
		//Ejecutar la query y devolver resultados
		return clientes;
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		//Obtener la sesion
		Session miSesion = sessionFactory.getCurrentSession();
		
		//Insertar el cliente
		//miSesion.save(elCliente);
		miSesion.saveOrUpdate(elCliente);
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {

		//Obtener la sesion
		Session miSesion = sessionFactory.getCurrentSession();
		
		//Obtener la informacion del cliente
		Cliente elCliente=miSesion.get(Cliente.class, id);
				
		return elCliente;
	}

	@Override
	@Transactional
	public void eliminarcliente(int id) {
		
		//Obtener la sesion
		Session miSesion = sessionFactory.getCurrentSession();
		
		//borrar el cliente de la base de datos
		Query consulta=miSesion.createQuery("DELETE FROM Cliente where id=:idCliente");	
		
		consulta.setParameter("idCliente", id);
		
		consulta.executeUpdate();
	}
	
	
	
	

}
