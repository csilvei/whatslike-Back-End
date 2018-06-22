package com.app.whatslike.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.whatslike.models.Mensagem;
import com.app.whatslike.models.MensagemGrupo;
import com.app.whatslike.repository.MensagemGrupoRepository;
import com.app.whatslike.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
	
	@Autowired
	private MensagemRepository mr;
	@Autowired
	private MensagemGrupoRepository mrg;
	
	 @GetMapping("/{contato}&{usuario}")
     public ResponseEntity<ArrayList <Mensagem>> list(@PathVariable("contato") Long contato,@PathVariable("usuario") Long usuario) {
		 ArrayList<Mensagem> lista = new ArrayList<Mensagem>();
		 Iterable<Mensagem> msg = mr.findAll();
		 for (Mensagem msg1 : msg) {
			 if(msg1.getRemetente() == usuario && msg1.getDestinatario() == contato || msg1.getRemetente() == contato && msg1.getDestinatario() == usuario)  {
				 if(msg1.getDestinatario() == usuario) {
					 msg1.setLida(true);
				 }
				 mr.save(msg1);
            	 lista.add(msg1);
             }
         }
		
        return ResponseEntity.ok(lista);
     }	
	 
	 @GetMapping("/grupos/{id}")
     public ResponseEntity<ArrayList <Mensagem>> list(@PathVariable("id") Long id) {
		 ArrayList<Mensagem> lista = new ArrayList<Mensagem>();
		 Iterable<Mensagem> msg = mr.findAll();
		 for (Mensagem msg1 : msg) {
			 if(msg1.getDestinatario() == id)  {
            	 lista.add(msg1);
             }
         }
		
        return ResponseEntity.ok(lista);
     }	
	 
	 
	 @PostMapping("/grupos")
	 public ResponseEntity<String> buscamg(@RequestBody long[] ids){
		 ArrayList<MensagemGrupo> MG = new ArrayList<MensagemGrupo>();
		 Iterable<Mensagem> msg = mr.findAll();
		 Iterable<MensagemGrupo> msgg = mrg.findAll();
		 for(MensagemGrupo msgg1 : msgg) {
			 if(msgg1.getGrupo() == ids[0] ) {
				 MG.add(msgg1);
			 }
		 }
		 for(Mensagem msg1 : msg) {
			 if(msg1.getDestinatario() == ids[0]) {
				 for(MensagemGrupo msgg1 : MG) {
					 if(msgg1.getRem() == ids[1] && msgg1.getMsg() == msg1.getId()) {
						 msgg1.setLida(true);
						 mrg.save(msgg1);
					 }
				 }
				 boolean naoleu = false;
				 for(MensagemGrupo msgg1 : msgg) {
					 if(msgg1.getGrupo() == ids[0] ) {
						 MG.add(msgg1);
					 }
				 }
				 
				 for(MensagemGrupo mssg1 : MG) {
					 if(mssg1.getGrupo() == ids[0]) {
						 if(mssg1.getLida() == false) {
							 naoleu = true;
						 }
					 }
					 
				 }
				 if(!naoleu) {
					 msg1.setLida(true);
					 mr.save(msg1);
				 }
			 }
		 }
		 return ResponseEntity.ok("");
	 }
	
	 @PostMapping
	 public ResponseEntity<Mensagem> insert(@RequestBody Mensagem msg) {
	        
         /* itera os usuarios do sistema e verifica se ja existe */
         	
         mr.save(msg);  
         return ResponseEntity.ok(msg);
	  }	 	
}	