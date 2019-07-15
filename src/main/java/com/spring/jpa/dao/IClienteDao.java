package com.spring.jpa.dao;

import com.spring.jpa.entity.ClienteModel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
/*
public interface IClienteDao {
    public List<ClienteModel> getClientes();
    public void saveCliente(ClienteModel cliente);
    public ClienteModel findOne(Long id);
    public void deleteOne(Long id);
}
*/
/*
public interface IClienteDao extends CrudRepository <ClienteModel, Long>{

}
*/

public interface IClienteDao extends PagingAndSortingRepository<ClienteModel, Long> {

}