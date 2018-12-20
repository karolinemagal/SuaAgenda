package tela;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import controle.LoginDAO;
import controle.TarefasDAO;
import modelo.Tarefa;
import modelo.Usuario;

@SuppressWarnings("deprecation")
@ManagedBean
public class NovaTarefaBean {
	
	public static Tarefa tarefa;
	
	public static Tarefa novaTarefa = new Tarefa();
	
	private static TarefasDAO tarefasDAO = TarefasDAO.getTarefasDAO();
	
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public Tarefa getNovaTarefa() {
		return novaTarefa;
	}
	
	public String cadastrar() {
		System.out.println("Nome: "+novaTarefa.getNome());
		System.out.println("Desc: "+novaTarefa.getDescricao());
		System.out.println("Data: "+novaTarefa.getData());
		novaTarefa.setUsuario(LoginDAO.getLoginDAO().getUsuarioLogado());
		if(tarefasDAO.novaTarefa(novaTarefa)) {
			return "tela_inicial?faces-redirect=true";
		}
		return null;
	}

	
	public String atualizar(){
		System.out.println("Nome: "+tarefa.getNome());
		System.out.println("Desc: "+tarefa.getDescricao());
		System.out.println("Data: "+tarefa.getData());
		
		if(tarefasDAO.editar(tarefa)) {
			return "tela_inicial?faces-redirect=true";
		}
		return null;
	}
}
