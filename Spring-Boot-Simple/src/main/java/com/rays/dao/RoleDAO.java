package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.rays.dto.RoleDTO;

@Repository
public class RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public long add(RoleDTO roleDTO) {
		entityManager.persist(roleDTO);
		return roleDTO.getId();
	}

	public void update(RoleDTO roleDTO) {
		entityManager.merge(roleDTO);
	}

	public void delete(long id) {
		RoleDTO dto = findByPk(id);
		entityManager.remove(dto);
	}

	public RoleDTO findByPk(long id) {
		RoleDTO dto = entityManager.find(RoleDTO.class, id);
		return dto;
	}

}
