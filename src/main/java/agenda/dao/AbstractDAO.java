package agenda.dao;

import java.util.List;

public abstract class AbstractDAO<T, I> {
	
	public abstract T getById(I i);

	public abstract void insert(T t);

	public abstract T update(T t);

	public abstract void delete(T t);

	public abstract List<T> listAll();
}
