package com.spring.jpa.dao;

import com.spring.jpa.entity.ClienteModel;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("ClienteDAOJPA")
public class ClienteDaoImpl /*implements IClienteDao*/ {

    @PersistenceContext
    private EntityManager em;

    //@Override
    public List<ClienteModel> getClientes() {
        return em.createQuery("from ClienteModel").getResultList();
    }

    //@Override
    public ClienteModel findOne(Long id) {
        return em.find(ClienteModel.class, id);
    }

    //@Override
    public void saveCliente(ClienteModel cliente) {
        if (cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    //@Override
    public void deleteOne(Long id) {
        ClienteModel cliente = findOne(id);
        if(cliente.getId() != null && cliente.getId() > 0){
            em.remove(cliente);
        }
    }

}
