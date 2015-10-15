package agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import agenda.model.Contato;

@Stateless
public class ContatoDAO extends AbstractDAO<Contato, Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Contato getById(Integer idContato) {
		return manager.find(Contato.class, idContato);
	}

	@Override
	public void insert(Contato contato) {
		manager.persist(contato);
	}

	@Override
	public Contato update(Contato contato) {
		return manager.merge(contato);
	}

	@Override
	public void delete(Contato contato) {
		Contato c = manager.merge(contato);
		manager.remove(c);
	}

	@Override
	public List<Contato> listAll() {
		return manager.createQuery("select c from Contato c inner join c.enderecos", Contato.class)
				.getResultList();
	}

}
