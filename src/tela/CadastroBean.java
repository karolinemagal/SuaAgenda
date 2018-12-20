package tela;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import controle.UsuariosDAO;
import modelo.Usuario;

@SuppressWarnings("deprecation")
@ManagedBean
public class CadastroBean {
	private Usuario usuario = new Usuario();
	private String dataDeNascimento;
	private String senhaConfirma;
	
	private static UsuariosDAO usuariosDAO = UsuariosDAO.getUsuariosDAO();
	
	public Usuario getUsuario() {
		
		return usuario;
	}
	
	public String getSenhaConfirma() {
		return senhaConfirma;
	}
	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}
	
	
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	public void cadastrar(){
		usuario.setDataDeNascimento(convertToData(dataDeNascimento));
		
		if(usuario.getSenha().equals(senhaConfirma)) {
		
			boolean cadastrou = usuariosDAO.cadastrar(this);
			
			if(!cadastrou) {
				RequestContext.getCurrentInstance().execute("PF('confirmDlg').show();");
			}else {
				RequestContext.getCurrentInstance().execute("PF('confirmaCadastro').show();");
			}
		}else {
			RequestContext.getCurrentInstance().execute("PF('senhas').show();");
		}
		
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
