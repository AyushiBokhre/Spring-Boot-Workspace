package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.Response;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "Ors")
public class ResponseCtl {

	@GetMapping
	public Response get() {

		Response res = new Response();

		res.addMessage("something went wrong..");

		return res;

	}

	@GetMapping("get")
	public Response get1() {

		Response res = new Response();

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("pass123");

		TestDTO dto1 = new TestDTO();
		dto1.setId(2L);
		dto1.setFirstName("Shyam");
		dto1.setLastName("Yadav");
		dto1.setLogin("shyam@gmail.com");
		dto1.setPassword("pass");

		List<TestDTO> list = new ArrayList<TestDTO>();
		list.add(dto);
		list.add(dto1);

		res.addData(list);
		res.setSuccess(true);

		return res;

	}

	@GetMapping("get1")
	public Response get2() {

		Response res = new Response();

		Map<String, String> errors = new HashMap<String, String>();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("login", "logn is required");
		errors.put("password", "passwrod is required");

		res.addInputError(errors);

		return res;

	}

	@GetMapping("get2")
	public Response get3() {

		Response res = new Response();

		Map<Integer, String> roleList = new HashMap<Integer, String>();
		roleList.put(1, "Admin");
		roleList.put(2, "Student");
		roleList.put(3, "College");
		roleList.put(4, "Faculty");

		res.addResult("roleList", roleList);
		res.setSuccess(true);

		return res;

	}

}