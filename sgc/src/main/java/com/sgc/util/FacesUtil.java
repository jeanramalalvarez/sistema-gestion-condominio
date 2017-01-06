package com.sgc.util;

/**
 * Clase utilitaria de Java Server Faces.
 * @author Jean Ramal Alvarez
 * @since 06 December 2016
 * @version 1.0
 *
 */

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

public class FacesUtil {
	
	public static void addMessage(Constantes type, String title, String message){
    	if (type == Constantes.INFO){
    		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title == null?Constantes.SISTEMA.getValor():title, message));
    	}else if(type == Constantes.WARN){
    		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title == null?Constantes.SISTEMA.getValor():title, message));
    	}else if(type == Constantes.ERROR){
    		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title == null?Constantes.SISTEMA.getValor():title, message));
    	}else if(type == Constantes.FATAL){
    		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title == null?Constantes.SISTEMA.getValor():title, message));
    	}
    }
    
    public static void addMessage(Constantes type, String title, String message, boolean sinRepetir){
    	boolean existeMensaje = false;
    	
    	if(sinRepetir){
			List<FacesMessage> mensajeList = getCurrentInstance().getMessageList();
			if(mensajeList != null){
				for (FacesMessage facesMessage : mensajeList) {
					if(facesMessage.getDetail().equals(message)){
						existeMensaje = true;
					}
				}
			}
    	}
    	
    	if(!existeMensaje){
    		addMessage(type, title, message);
    	}
    }

	public static void keepMessages() {
		getExternalContext().getFlash().setKeepMessages(true);
	}

	public static FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public static ServletContext getServletContext(){
		return ((ServletContext) getExternalContext().getContext());
	}

	public static ExternalContext getExternalContext(){
		return getCurrentInstance().getExternalContext();
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getExternalContext().getResponse();
	}

	public static String getRemoteAddr() {
		return getRequest().getRemoteAddr();
	}

	public static String getRemoteHost() {
		return getRequest().getRemoteHost();
	}

	public static Object getAttributeSession(String objectName) {
		return getRequest().getSession(false).getAttribute(objectName);
	}
	
	public static Object getSessionObject(String id) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(id);
	}

	public static void setSessionObject(String id, Object obj){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(id, obj);
	}

	public static void invalidate() {
		((HttpSession) getExternalContext().getSession(false)).invalidate();
	}

	public static String getPropertie(String key, String... args) {
		try {
			FacesContext context = getCurrentInstance();
			ResourceBundle rb = context.getApplication().getResourceBundle(context, "mensaje");
			MessageFormat format = new MessageFormat((String) rb.getObject(key));
			return format.format(args);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void redirect(String ruta) throws IOException{
    	getExternalContext().redirect(ruta);
    }
	
	public static UIComponent findComponent(String component){
		return getCurrentInstance().getViewRoot().findComponent(component);
	}
	
	public static void execute(String script){
		RequestContext.getCurrentInstance().execute(script);
    }
	
	public static void publish(String title, String message, String channel) {
		try{
			EventBus eventBus = EventBusFactory.getDefault().eventBus();
			eventBus.publish(channel, new FacesMessage(StringEscapeUtils.escapeHtml(title), StringEscapeUtils.escapeHtml(message)));
		}catch(Exception e){
			System.out.println("notificarPush [Exception]: " + ((e != null)?e.getMessage():"null"));
		}
    }
}
