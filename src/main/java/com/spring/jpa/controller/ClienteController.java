package com.spring.jpa.controller;

import com.spring.jpa.dao.IClienteDao;
import com.spring.jpa.entity.ClienteModel;
import com.spring.jpa.service.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    //@Qualifier(value = "ClienteService")
    private ClienteServiceInterface clienteService;

    @GetMapping({"/", "/index", "/home"})
    public String listarClientes(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page, 5);
        Page<ClienteModel> clientes = clienteService.getClientes(pageable);
        PageRender<ClienteModel> pageRender = new PageRender<ClienteModel>("/index",clientes);
        model.addAttribute("page", pageRender);
        model.addAttribute("clientes",clientes);
        return "index";
    }

    @GetMapping("/nuevo")
    public String verForm(Model model){
        ClienteModel cliente = new ClienteModel();
        model.addAttribute("cliente", cliente);
        return "formCliente";
    }

    @PostMapping("/nuevo")
    public String saveCliente(@Valid @ModelAttribute("cliente") ClienteModel nuevoCliente, BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "formCliente";
        }
        clienteService.saveCliente(nuevoCliente);
        status.setComplete();
        return "redirect:/index";
    }

    @GetMapping("/find/{id}")
    public String getCliente(@PathVariable(value = "id") Long id, Model model){
        ClienteModel cliente = null;
        if (id > 0){
            cliente = clienteService.findOne(id);
        } else {
            return "redirect:/index";
        }
        model.addAttribute("cliente", cliente);
        return "formCliente";
    }

    @GetMapping("/delete/{id}")
    public String deleteOne(@PathVariable(value = "id") Long id){
        if(id != null && id > 0) {
            clienteService.deleteOne(id);
        }
        return "redirect:/index";
    }
}
