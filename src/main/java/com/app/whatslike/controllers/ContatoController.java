package com.app.whatslike.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.whatslike.models.Contato;
import com.app.whatslike.repository.ContatoRepository;



@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoRepository cr;
	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Contato>> list() {
        return ResponseEntity.ok(cr.findAll());
     }	
	
	 @PostMapping
	 public ResponseEntity<Contato> insert(@RequestBody Contato contato) {
	        
         /* itera os usuarios do sistema e verifica se ja existe */
         	
         cr.save(contato);  
         return ResponseEntity.ok(contato);
	  }	 	
	 
	 @PostMapping(value = "/existe")
	 public ResponseEntity<Contato> logout(@RequestBody Contato contato) {
	 		boolean achou = false;
	 		Iterable<Contato> contatos = cr.findAll();
	         for (Contato contato1 : contatos) {
	             if(contato1.getUsuario() == contato.getUsuario() && contato1.getContato() == contato.getContato()) {
	            	 achou = true;
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok(contato);
             }else {
            	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }   
	    }
}	
