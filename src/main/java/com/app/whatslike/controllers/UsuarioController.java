package com.app.whatslike.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.app.whatslike.models.Usuario;
import com.app.whatslike.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	 @PostMapping
	 public ResponseEntity<Usuario> insert(@RequestBody Usuario user) {
	        
		 boolean nome = false;
         boolean ip   = false;

         /* itera os usuarios do sistema e verifica se ja existe */
         Iterable<Usuario> usuarios = ur.findAll();
         for (Usuario usuario1 : usuarios) {
             if(usuario1.getNome().equalsIgnoreCase(user.getNome()) || usuario1.getIp().equalsIgnoreCase(user.getIp())) {
                 nome = true;
                 ip = true;
             }
         }
         if(!nome &&  !ip){
        	 ur.save(user);  
             return ResponseEntity.ok(user);
         }else {
        	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
	  }
	 	
	 @PostMapping(value = "/buscar")
	 public ResponseEntity<Usuario> find(@RequestBody Usuario user) {
	 		Usuario achouUser = null; 		
	 		boolean achouNome = false;
	 		boolean achouIp = false;
	 		Iterable<Usuario> usuarios = ur.findAll();
	         for (Usuario usuario1 : usuarios) {
	             if(usuario1.getNome().equalsIgnoreCase(user.getNome()) && usuario1.getIp().equalsIgnoreCase(user.getIp())) {
	                 achouNome = true;
	                 achouIp = true;
	            	 achouUser = usuario1;
	            	 achouUser.setStatus(true);
	             }
	         }
	         if(achouNome &&  achouIp){  
	        	 ur.save(achouUser);
                 return ResponseEntity.ok(achouUser);
             }else {
            	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }   
	    }
	 
	 @PostMapping(value = "/buscarCont")
	 public ResponseEntity<Usuario> findC(@RequestBody Usuario user) {
	 		Usuario achouUser = null; 		
	 		boolean achouNome = false;
	 		boolean achouIp = false;
	 		Iterable<Usuario> usuarios = ur.findAll();
	         for (Usuario usuario1 : usuarios) {
	             if(usuario1.getNome().equalsIgnoreCase(user.getNome()) && usuario1.getIp().equalsIgnoreCase(user.getIp())) {
	                 achouNome = true;
	                 achouIp = true;
	            	 achouUser = usuario1;
	             }
	         }
	         if(achouNome &&  achouIp){  
                 return ResponseEntity.ok(achouUser);
             }else {
            	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }   
	    }
	 
	 @GetMapping(value = "/{id}")
	    public ResponseEntity<Optional<Usuario>> find(@PathVariable("id") Long id) {
	        Optional<Usuario> user = ur.findById(id);

	        if (user == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        return ResponseEntity.ok(user);
	    }
	 
	 @PostMapping(value = "/logout")
	 public ResponseEntity<Usuario> logout(@RequestBody Usuario user) {
	 		Usuario achouUser = null; 		
	 		boolean achouNome = false;
	 		boolean achouIp = false;
	 		Iterable<Usuario> usuarios = ur.findAll();
	         for (Usuario usuario1 : usuarios) {
	             if(usuario1.getNome().equalsIgnoreCase(user.getNome()) && usuario1.getIp().equalsIgnoreCase(user.getIp())) {
	                 achouNome = true;
	                 achouIp = true;
	            	 achouUser = usuario1;
	            	 achouUser.setStatus(false);
	             }
	         }
	         if(achouNome &&  achouIp){  
	        	 ur.save(achouUser);
                 return ResponseEntity.ok(achouUser);
             }else {
            	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }   
	    }
}	

	
