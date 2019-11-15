package io.altar.jseproject.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public abstract class EntityRepository<T extends Entity> {

	public Map<Long, T> baseDados = new HashMap<Long, T>();

	private static long maxId;

	private long maxId() {
		return ++maxId;
	}

	public long createEntity(T nextId) {
		nextId.setId(maxId());
		baseDados.put(maxId, nextId);
		return maxId;
	}

	public Collection<T> consultEntity() {
		return baseDados.values();
	}

	public Collection<Long> getAllIds() {
		return baseDados.keySet();
	}
	
	public T consultEntity(long Id) {
		return baseDados.get(Id);
	}

	public T editEntity(T editedEntity) {
		return baseDados.put(editedEntity.getId(), editedEntity);
	}

	public T removeEntity(long id) {
		return baseDados.remove(id);
	}
}
