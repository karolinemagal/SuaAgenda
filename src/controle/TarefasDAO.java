package controle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.Tarefa;

public class TarefasDAO {
	private static ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	private static TarefasDAO tarefasDAO = new TarefasDAO();
	public static TarefasDAO getTarefasDAO() {
		return tarefasDAO;
	}
	
	public boolean novaTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
		return true;
	}
	
	public ArrayList<Tarefa> consultarTarefasDeUmDia(Date data) {
		ArrayList<Tarefa> retorno = new ArrayList<Tarefa>();
		for(Tarefa tarefa: tarefas) {
			System.out.println("\nDatas");
			System.out.println("Data 1: "+tarefa.getData());
			System.out.println("Data 2: "+data);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			
			if(sdf.format(tarefa.getData()).equals(sdf.format(data)) && tarefa.getUsuario().getUsuario().equals(LoginDAO.getLoginDAO().getUsuarioLogado().getUsuario())) {
				retorno.add(tarefa);
			}
		}
		return retorno;
	}
	
	public ArrayList<Tarefa> consultarTarefasEmUmIntervalo(Date inicio, Date fim){
		ArrayList<Tarefa> retorno = new ArrayList<Tarefa>();
		for(Tarefa tarefa: tarefas) {
			if(tarefa.getData().compareTo(inicio)>=0 && tarefa.getData().compareTo(fim)<=0 && tarefa.getUsuario().getUsuario().equals(LoginDAO.getLoginDAO().getUsuarioLogado().getUsuario())) {
				retorno.add(tarefa);
			}
		}
		return retorno;
	}
	
	public boolean delete(int id) {
		for(int i = 0; i < tarefas.size();i++) {
			if(tarefas.get(i).getID()==id) {
				tarefas.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean editar(Tarefa tarefa) {
		for(int i = 0; i < tarefas.size();i++) {
			if(tarefas.get(i).getID() == tarefa.getID()) {
				tarefas.set(i,tarefa);
				return true;
			}
		}
		return false;
	}
}
