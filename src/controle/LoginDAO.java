package controle;

import modelo.Usuario;

public class LoginDAO {
	private static Usuario usuarioLogado = null;
	
	private static LoginDAO loginDAO = new LoginDAO();
	public static LoginDAO getLoginDAO() {
		return loginDAO;
	}
	
	public void logar(Usuario usuario) {
		usuarioLogado = usuario;
	}
	
	public void deslogar() {
		usuarioLogado = null;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
}
