package modelo;

import java.util.Date;

public class Tarefa {
	private Usuario usuario;
	private String nome;
	private String descricao;
	private Date data;
	private int id;
	private static int countIDTarefa = 0;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Tarefa() {
		this.id = countIDTarefa;
		countIDTarefa ++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
}
