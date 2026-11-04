package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleService roleService;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		RoleDTO roleDTO = roleService.findByPk(dto.getRoleId());

		if (roleDTO == null) {
		    throw new RuntimeException("Invalid Role ID");
		}

		dto.setRoleName(roleDTO.getName());
		return userDAO.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		userDAO.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		userDAO.delete(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
		return userDAO.findByPk(id);
	}

	@Transactional(readOnly = true)
	public long save(UserDTO dto) {
		if (dto.getId() > 0) {
			userDAO.update(dto);
		} else {
			userDAO.add(dto);
		}
		return dto.getId();
	}

}
