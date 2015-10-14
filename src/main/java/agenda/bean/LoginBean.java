package agenda.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import agenda.dao.UsuarioDAO;
import agenda.model.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDAO usuarioDAO;

	public LoginBean() {

	}

	public String logar() {
		Usuario usuarioBuscado = usuarioDAO.getUsuarioByLogin(usuario.getLogin());
		if (usuarioBuscado != null && usuarioBuscado.getSenha().equals(usuario.getSenha())) {
			usuario = usuarioBuscado;
			usuario.setLogado(true);
			//return "principal?faces-redirect=true";
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login/Senha inválido!"));
			usuario = new Usuario();
			return null;
		}
	}

	public String logout() {
		usuario.setLogado(false);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (session != null) {
			session.invalidate();
		}
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
