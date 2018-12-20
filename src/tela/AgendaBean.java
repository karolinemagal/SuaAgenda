package tela;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@SuppressWarnings("deprecation")
@ManagedBean
public class AgendaBean {
	         
	    private static Date date1;
 
	    public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        System.out.println("Data: "+event.getObject());
	        System.out.println(event.getObject() instanceof Date);
	        
	    }
	     
	    public String click() {
	        PrincipalBean.dia = date1;
	        
	        return "tela_dia?faces-redirect=true";
	    	
	    	
	    }
	 
	    public Date getDate1() {
	        return date1;
	    }
	 
	    public void setDate1(Date date1) {
	        this.date1 = date1;
	    }
	 
	}

