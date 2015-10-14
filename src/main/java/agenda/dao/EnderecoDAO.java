package agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import agenda.model.Endereco;

@Stateless
public class EnderecoDAO extends AbstractDAO<Endereco, Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Endereco getById(Integer idEndereco) {
		return manager.find(Endereco.class, idEndereco);
	}

	@Override
	public void insert(Endereco endereco) {
		manager.persist(endereco);
	}

	@Override
	public Endereco update(Endereco endereco) {
		return manager.merge(endereco);
	}

	@Override
	public void delete(Endereco endereco) {
		Endereco e = manager.merge(endereco);
		manager.remove(e);
	}

	@Override
	public List<Endereco> listAll() {
		return manager.createQuery("select e from Endereco e", Endereco.class)
				.getResultList();
	}

}
