package br.com.apptodolist.todolist.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apptodolist.todolist.model.Tarefas;
import br.com.apptodolist.todolist.repository.TarefasRepository;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefasController {

	@Autowired
	private TarefasRepository tarefasRepository;
	
	@GetMapping
	public List<Tarefas> findAll(){
		return tarefasRepository.findAll();
	}
	
	@GetMapping("/titulo{titulo}")
	public ResponseEntity<List<Tarefas>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(tarefasRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/prioridade{prioridade}")
	public ResponseEntity<List<Tarefas>> getByPrioridade(@PathVariable String prioridade) {
		return ResponseEntity.ok(tarefasRepository.findAllByTituloContainingIgnoreCase(prioridade));
	}
	
	@PostMapping
	public ResponseEntity<Tarefas> postTarefas(@Valid @RequestBody Tarefas tarefas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefasRepository.save(tarefas));
	}
	
	@PutMapping
	public ResponseEntity<Tarefas> putTarefas (@Valid @RequestBody Tarefas tarefas) {
		return tarefasRepository.findById(tarefas.getId())
				.map(resposta -> ResponseEntity.ok().body(tarefasRepository.save(tarefas)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTarefas(@PathVariable long id) {
		return tarefasRepository.findById(id)
				.map(resposta -> {tarefasRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
				.orElse(ResponseEntity.notFound().build());
	}

}
