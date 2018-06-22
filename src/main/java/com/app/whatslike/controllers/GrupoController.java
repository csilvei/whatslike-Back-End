package com.app.whatslike.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.whatslike.models.Grupo;
import com.app.whatslike.models.GruposMembros;
import com.app.whatslike.repository.GrupoMembroRepository;
import com.app.whatslike.repository.GrupoRepository;


@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	@Autowired
	private GrupoRepository gr;

	
	 @GetMapping("/all")
     public ResponseEntity<Iterable<Grupo>> list() {
        return ResponseEntity.ok(gr.findAll());
     }	
	 
	 @PostMapping
	 public ResponseEntity<Grupo> insert(@RequestBody Grupo grupo) {
	        
         gr.save(grupo);  
         return ResponseEntity.ok(grupo);
	  }	 	
	 
	 @PostMapping(value = "/existe")
	 public ResponseEntity<String> logout(@RequestBody String nome) {
	 		boolean achou = false;
	 		String aux = "";
	 		Iterable<Grupo> grupos = gr.findAll();
	         for (Grupo grupo1 : grupos) {
	        	 aux = grupo1.getNome(); 
	             if(aux.equals(nome)) {
	            	 achou = true;
	             }
	         }
	         if(achou){  
                 return ResponseEntity.ok("");
             }else {
            	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }   
	    }
}	
