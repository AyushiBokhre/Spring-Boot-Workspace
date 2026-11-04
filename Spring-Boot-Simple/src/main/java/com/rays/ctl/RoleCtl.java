package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.Response;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleService;

@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl {

	@Autowired
	private RoleService service;

	@PostMapping("save")
	public Response save(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		Response res = new Response();

		res = validate(bindingResult);
		if (res.isSuccess() == false) {
			return res;
		}

		RoleDTO dto = (RoleDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			service.update(dto);
			res.addMessage("role updated successfully");
			res.addData(dto);
		} else {
			service.add(dto);
			res.addMessage("role added successfully");
			res.addData(dto);
		}

		return res;

	}

	@GetMapping("delete/{ids}")
	public Response save(@PathVariable long[] ids) {

		Response res = new Response();

		for (long id : ids) {
			service.delete(id);
			res.setSuccess(true);
			res.addMessage("record deleted successfully");
		}

		return res;

	}

	@GetMapping("get/{id}")
	public Response save(@PathVariable long id) {

		Response res = new Response();

		RoleDTO dto = service.findByPk(id);

		if (dto != null) {
			res.addData(dto);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}

		return res;

	}

}