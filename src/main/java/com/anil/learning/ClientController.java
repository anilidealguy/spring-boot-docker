package com.anil.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	ClientRepository dao;

	@RequestMapping(value = "/client/", method = RequestMethod.POST)
	public void create(@RequestBody Client client) {
		dao.save(client);

	}

	@RequestMapping(value = "/client/{id}/", method = RequestMethod.GET)
	public Client read(@PathVariable("id") int id) {
		return dao.findById(id).get();
	}

	@RequestMapping(value = "/client/{id}/", method = RequestMethod.PUT)
	public Client update(@PathVariable("id") int id, @RequestBody Client client) {
		return dao.save(client);
	}

	@RequestMapping(value = "/client/{id}/", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		dao.deleteById(id);
	}

}
