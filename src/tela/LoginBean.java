package tela;


import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import controle.LoginDAO;
import controle.UsuariosDAO;

@SuppressWarnings("deprecation")
@ManagedBean
public class LoginBean {
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String logar() {
		boolean certo = UsuariosDAO.getUsuariosDAO().login(this);
		if(!certo) {
			RequestContext.getCurrentInstance().execute("PF('confirmDlg').show();");
		}else {
			return "/tela_inicial.faces";
		}
		return null;
	}
	public void cadastrar() {
		System.out.println("SAD");
	}
	
	public String deslogar() {
		LoginDAO.getLoginDAO().deslogar();
		return "login?faces-redirect=true";
	}
}
