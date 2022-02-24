package br.com.apptodolist.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apptodolist.todolist.model.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
	
	public List<Tarefas> findAllByTituloContainingIgnoreCase(String titulo);
	
	public Object findAllByPrioridade(String prioridade);

}
