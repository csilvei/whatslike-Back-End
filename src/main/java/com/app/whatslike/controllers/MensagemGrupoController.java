package com.app.whatslike.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.whatslike.models.MensagemGrupo;
import com.app.whatslike.repository.MensagemGrupoRepository;

@RestController
@RequestMapping("/mensagemgrupos")
public class MensagemGrupoController {
	
	@Autowired
	private MensagemGrupoRepository mgr;
	
	@GetMapping("/all")
    public ResponseEntity<Iterable<MensagemGrupo>> listmg() {
       return ResponseEntity.ok(mgr.findAll());
    }	
	
	
	 @PostMapping
	 public ResponseEntity<String> insertmgr(@RequestBody long[] grm) {
		 
		 for(int i = 2; i < grm.length; i++) {
			 MensagemGrupo aux = new MensagemGrupo();
			 aux.setGrupo(grm[0]);
			 aux.setMsg(grm[1]);
			 aux.setRem(grm[i]);
			 aux.setLida(false);
			 mgr.save(aux);
		 }  
		 return ResponseEntity.ok("");
	  }	 
}
