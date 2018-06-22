package com.app.whatslike.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.whatslike.models.GruposMembros;
import com.app.whatslike.repository.GrupoMembroRepository;

@RestController
@RequestMapping("/gruposMembros")
public class GruposMembrosController {
	
	@Autowired
	private GrupoMembroRepository gmr;
	@GetMapping("/all")
    public ResponseEntity<Iterable<GruposMembros>> listgrm() {
       return ResponseEntity.ok(gmr.findAll());
    }	
	 
	 
	 @PostMapping
	 public ResponseEntity<String> insertgrm(@RequestBody long[] grm) {
		 
		 for(int i = 1; i < grm.length; i++) {
			 GruposMembros aux = new GruposMembros();
			 aux.setGrupo(grm[0]);
			 aux.setMembro(grm[i]);
			 gmr.save(aux);
		 }  
		 return ResponseEntity.ok("");
	  }	 
}
