package controle;

import java.util.ArrayList;
import java.util.Date;

import modelo.Usuario;
import tela.CadastroBean;
import tela.LoginBean;
import tela.MeuPerfilBean;

public class UsuariosDAO {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static LoginDAO loginDAO = LoginDAO.getLoginDAO();
	
	private static UsuariosDAO usuariosDAO = new UsuariosDAO();
	public static UsuariosDAO getUsuariosDAO() {
		return usuariosDAO;
	}
	
	public boolean cadastrar(Usuario usuario) {
		if(!temUsuario(usuario.getUsuario())) {
			Usuario nUsuario = new Usuario();
			nUsuario.setNome(usuario.getNome());
			nUsuario.setDataDeNascimento(usuario.getDataDeNascimento());
			nUsuario.setSenha(usuario.getSenha());
			nUsuario.setEmail(usuario.getEmail());
			nUsuario.setUsuario(usuario.getUsuario());
			usuarios.add(nUsuario);
			return true;
		}
		return false;
	}
	
	public boolean cadastrar(CadastroBean cadastroBean) {
		if(!temUsuario(cadastroBean.getUsuario().getUsuario())) {
			Usuario usuario = new Usuario();
			usuario.setNome(cadastroBean.getUsuario().getNome());
			usuario.setDataDeNascimento(cadastroBean.getUsuario().getDataDeNascimento());
			usuario.setSenha(cadastroBean.getUsuario().getSenha());
			usuario.setEmail(cadastroBean.getUsuario().getEmail());
			usuario.setUsuario(cadastroBean.getUsuario().getUsuario());
			usuarios.add(usuario);
			return true;
		}
		return false;
	}
	
	public static boolean login(LoginBean loginBean) {
		for(Usuario usuario: usuarios) {
			if(usuario.getUsuario().equals(loginBean.getLogin())) {
				if(usuario.getSenha().equals(loginBean.getSenha())) {
					loginDAO.logar(usuario);
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
	
	public boolean update(MeuPerfilBean novoPerfil) {
		for(int i = 0; i < usuarios.size();i++) {
			if(usuarios.get(i).getUsuario().equals(loginDAO.getUsuarioLogado().getUsuario())) {
				usuarios.get(i).setNome(novoPerfil.getUsuario().getNome());
				usuarios.get(i).setEmail(novoPerfil.getUsuario().getEmail());
				usuarios.get(i).setDataDeNascimento(novoPerfil.getUsuario().getDataDeNascimento());
				usuarios.get(i).setSenha(novoPerfil.getUsuario().getSenha());
				loginDAO.logar(usuarios.get(i));
				return true;
			}
		}
		return false;
	}
	
	public boolean delete() {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getUsuario().equals(loginDAO.getUsuarioLogado().getUsuario())) {
				loginDAO.deslogar();
				usuarios.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean temUsuario(String login) {
		for(Usuario usuario: usuarios) {
			if(usuario.getUsuario().equals(login)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
