package agenda.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import agenda.dao.UsuarioDAO;
import agenda.model.Usuario;

@SessionScoped
@Named(value = "usuarioBean")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public UsuarioBean() {
		
	}
	
	public void novo() {
		usuario = new Usuario();
	}
	
	public void salvar() {
		usuarioDAO.insert(usuario);
		novo();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
