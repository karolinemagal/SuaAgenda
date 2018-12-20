package tela;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import controle.LoginDAO;
import controle.UsuariosDAO;
import modelo.Usuario;

@SuppressWarnings("deprecation")
@ManagedBean
public class MeuPerfilBean {
	LoginDAO loginDAO = LoginDAO.getLoginDAO();
	UsuariosDAO usuariosDAO = UsuariosDAO.getUsuariosDAO();
	
	private Usuario usuario = loginDAO.getUsuarioLogado();
	private String nascimento;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public String getNascimento() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		nascimento = dateFormat.format(getUsuario().getDataDeNascimento());
		return nascimento;
	}
	
	public void setNascimento(String nascimento){
		this.nascimento = nascimento;
	}
	public String atualizar(){
		usuario.setDataDeNascimento(convertToData(nascimento));
		if(usuariosDAO.update(this)) {
			return "tela_inicial?faces-redirect=true";
		}
		return null;
	}

	
	public Date convertToData(String data) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = (Date)formatter.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		return date;
	}
}
