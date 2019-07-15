package com.spring.jpa.service;

import com.spring.jpa.entity.ClienteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ClienteServiceInterface {
    public List<ClienteModel> getClientes();
    public Page<ClienteModel> getClientes(Pageable pageable);
    public void saveCliente(ClienteModel cliente);
    public ClienteModel findOne(Long id);
    public void deleteOne(Long id);
}

