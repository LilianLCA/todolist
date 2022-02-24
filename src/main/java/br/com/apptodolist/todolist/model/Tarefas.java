package br.com.apptodolist.todolist.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tarefas")
public class Tarefas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo titulo é obrigatório!") 
	@Size(min = 3, max = 100, message = "O título deve conter no mínimo 03 e no máximo 100 caracteres")
	private String titulo;
	
	@NotNull(message = "O atributo descrição é obrigatório!") 
	@Size(min = 3, max = 300, message = "A descrição deve conter no mínimo 03 e no máximo 300 caracteres")
	private String descricao;
	
	@NotNull(message = "O atributo status da tarefa é obrigatório!")
	private boolean concluido;
	
	@NotNull(message = "O atributo prioridade é obrigatório!") 
	@Size(min = 4, max = 10, message = "A prioridade da sua tarefa deve ser categorizada entre: Baixa, Média ou Alta.")
	private String prioridade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("tarefas")
	private Usuario usuario;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
