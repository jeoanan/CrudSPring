package dominio.com.dao;

import java.util.List;

import dominio.com.controlador.entity.Cliente;

public interface ClienteDao {
	
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente elCliente);

	public Cliente getCliente(int id);

	public void eliminarcliente(int id);

}
