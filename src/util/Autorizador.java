package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import modelo.Usuario;
import controle.LoginDAO;


public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent evento) {

		FacesContext context = evento.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();
	
		System.out.println(nomePagina);
		
		Usuario usuarioLogado = LoginDAO.getLoginDAO().getUsuarioLogado();
		
		if("/login.xhtml".equals(nomePagina) || "/cadastro.xhtml".equals(nomePagina)) {
			if(usuarioLogado != null) {
				NavigationHandler handler = context.getApplication().getNavigationHandler();
				handler.handleNavigation(context, null, "/tela_inicial?faces-redirect=true");
				context.renderResponse();
			}
			return;
		}
		
		
		if(usuarioLogado != null) {
			return;
		}
		
		//redirecionamento para login.xhtml
		
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	} 

	private Object LoginDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
