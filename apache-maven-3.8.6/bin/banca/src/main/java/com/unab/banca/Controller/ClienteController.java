package com.unab.banca.Controller;

import com.unab.banca.Models.Cliente;
//import com.nestor.banca.Dao.ClienteDao;
import com.unab.banca.Service.ClienteService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
    // @Autowired
    // private ClienteDao clienteDao;
    @Autowired
    private ClienteService clienteService;
    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Cliente> agregar(@Valid @RequestBody Cliente cliente) {
        Cliente obj = clienteService.save(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable String id) {

        Cliente obj = clienteService.findById(id);
        if (obj != null)
            clienteService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Cliente> editar(@Valid @RequestBody Cliente cliente) {
        Cliente obj = clienteService.findById(cliente.getId_cliente());
        if (obj != null) {
            obj.setNombre_cliente(cliente.getNombre_cliente());
            obj.setClave_cliente(cliente.getClave_cliente());
            clienteService.save(cliente);
        } else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    // @ResponseBody
    public List<Cliente> consultarTodo() {
        return clienteService.findAll();
    }

    @GetMapping("/list/{id}")
    @ResponseBody
    public Cliente consultaPorId(@PathVariable String id) {
        return clienteService.findById(id);
    }

    @GetMapping("/login")
    @ResponseBody
    public Cliente ingresar(@RequestParam("usuario") String usuario, @RequestParam("clave") String clave) {
        return clienteService.login(usuario, clave);
    }
    
}