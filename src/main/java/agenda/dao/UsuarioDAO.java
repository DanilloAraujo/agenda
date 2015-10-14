package agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import agenda.model.Usuario;

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario, Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Usuario getById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Usuario usuario) {
		manager.persist(usuario);
	}

	@Override
	public Usuario update(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Usuario t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario getUsuarioByLogin(String login) {

		Usuario usuario = null;
		String query = "Select u from Usuario u where u.login = :login";
		try {
			TypedQuery<Usuario> tq = manager.createQuery(query, Usuario.class);
			usuario = tq.setParameter("login", login).getSingleResult();
		} catch (Exception e) {
		
		}
		return usuario;
	}

}
