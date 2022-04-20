package br.senai.service;

import br.senai.model.Cliente;
import br.senai.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImple implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Optional<Cliente> updatedCliente = clienteRepository.findById(id);
        if(! updatedCliente.isEmpty()){
            updatedCliente.get().setNome(cliente.getNome());
            updatedCliente.get().setEmail(cliente.getEmail());
            return clienteRepository.save(updatedCliente.get());
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> read(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll(Sort.by("nome"));
    }
}
