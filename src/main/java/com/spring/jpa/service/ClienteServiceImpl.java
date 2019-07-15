package com.spring.jpa.service;

import com.spring.jpa.dao.IClienteDao;
import com.spring.jpa.entity.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteServiceInterface {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteModel> getClientes() {
        //return clienteDao.getClientes();
        return (List<ClienteModel>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClienteModel> getClientes(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveCliente(ClienteModel cliente) {
        //clienteDao.saveCliente(cliente);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteModel findOne(Long id) {
        //return clienteDao.findOne(id);
        return  clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteOne(Long id) {
        //clienteDao.deleteOne(id);
        clienteDao.deleteById(id);
    }
}
