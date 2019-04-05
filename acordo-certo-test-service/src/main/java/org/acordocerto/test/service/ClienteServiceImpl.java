package org.acordocerto.test.service;

import org.acordo.certo.test.domain.entity.Cliente;
import org.acordo.certo.test.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

}
