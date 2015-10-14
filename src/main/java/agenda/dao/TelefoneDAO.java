package agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import agenda.model.Telefone;

@Stateless
public class TelefoneDAO extends AbstractDAO<Telefone, Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Telefone getById(Integer idTelefone) {
		return manager.find(Telefone.class, idTelefone);
	}

	@Override
	public void insert(Telefone telefone) {
		manager.persist(telefone);
	}

	@Override
	public Telefone update(Telefone telefone) {
		return manager.merge(telefone);
	}

	@Override
	public void delete(Telefone telefone) {
		Telefone t = manager.merge(telefone);
		manager.remove(t);
	}

	@Override
	public List<Telefone> listAll() {
		return manager.createQuery("select t from Telefone t", Telefone.class)
				.getResultList();
	}

}
