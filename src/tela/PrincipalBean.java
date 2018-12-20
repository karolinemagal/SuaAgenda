package tela;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import controle.TarefasDAO;
import modelo.Tarefa;

@SuppressWarnings("deprecation")
@ManagedBean
public class PrincipalBean {
	private ArrayList<Tarefa> tarefas;
	private ArrayList<Tarefa> tarefasDeOutroDia;
	
	private Tarefa tarefaParaEditar;
	
	public static Date dia;
	
	private String diaDaSemana;
	
	private TarefasDAO tarefasDAO = TarefasDAO.getTarefasDAO();
	
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getDia() {
		return dia;
	}
	
	public String getDiaDaSemana() {
		String retorno;
		retorno = dia.getDate()+" de ";
		switch(dia.getMonth()) {
		case 0:
			retorno += "Janeiro de ";
			break;
		case 1:
			retorno += "Fevereiro de ";
			break;
		case 2:
			retorno += "Março de ";
			break;
		case 3:
			retorno += "Abril de ";
			break;
		case 4:
			retorno += "Maio de ";
			break;
		case 5:
			retorno += "Junho de ";
			break;
		case 6:
			retorno += "Julho de ";
			break;
		case 7:
			retorno += "Agosto de ";
			break;
		case 9:
			retorno += "Setembro de ";
			break;
		case 10:
			retorno += "Outubro de ";
			break;
		case 11:
			retorno += "Dezembro de ";
			break;
		}
		retorno += (dia.getYear()+1900);
		return retorno;
	}
	
	public ArrayList<Tarefa> getTarefasDeOutroDia(){
		this.tarefasDeOutroDia = tarefasDAO.consultarTarefasDeUmDia(dia);
		return tarefasDeOutroDia;
	}
	
	public ArrayList<Tarefa> getTarefas() {
		
		Date data = new Date(System.currentTimeMillis());
		this.tarefas = tarefasDAO.consultarTarefasDeUmDia(data);
		
		
		mostrar();
		return tarefas;
	}
	
	public void mostrar() {
		for(Tarefa tarefa: tarefas) {
			System.out.println(tarefa.toString());
		}
	}
	
	public void deletar(Tarefa tarefa) {
		tarefasDAO.delete(tarefa.getID());
	}
	
	public String editar(Tarefa tarefa) {
		System.out.println("VEIO");
		tarefaParaEditar = tarefa;
		NovaTarefaBean.tarefa = tarefaParaEditar;
		
		return "tarefa?faces-redirect=true";
	}
}