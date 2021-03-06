package br.com.fiap.traveller.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.traveller.dao.UserDao;
import br.com.fiap.traveller.models.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();
	
	public void save() {
	
		new UserDao().create(user);
		System.out.println("Salvando..." + this.user);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastrado com sucesso!"));
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean exist = new UserDao().exist(user);
		if (exist) {

			context.getExternalContext().getSessionMap().put("user", user);
			return "index?faces-redirect=true";
		}

		// Flash Message
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido.", ""));

		return "login?faces-redirect=true";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("user");
		return "login?faces-redirect=true";
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}