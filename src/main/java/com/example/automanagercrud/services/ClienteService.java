package com.example.automanagercrud.services;

import com.example.automanagercrud.DTOs.ClienteRequestDTO;
import com.example.automanagercrud.DTOs.ClienteResponseDTO;
import com.example.automanagercrud.entities.Cliente;
import com.example.automanagercrud.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String cadastrarCliente(ClienteRequestDTO requestDTO){

        Cliente cliente = new Cliente();

        cliente.setNome(requestDTO.getNome());
        cliente.setEmail(requestDTO.getEmail());
        cliente.setTelefone(requestDTO.getTelefone());

        clienteRepository.save(cliente);
        return "Cliente cadastrado com Sucesso!!";
    }

    public ClienteResponseDTO buscarIdCliente(long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        ClienteResponseDTO responseDTO = new ClienteResponseDTO();

        responseDTO.setId(cliente.getId());
        responseDTO.setNome(cliente.getNome());
        responseDTO.setEmail(cliente.getEmail());
        responseDTO.setTelefone(cliente.getTelefone());

        return responseDTO;
    }

    public String alterarCliente(long id, ClienteRequestDTO requestDTO){

        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        cliente.setNome(requestDTO.getNome());
        cliente.setEmail(requestDTO.getEmail());
        cliente.setTelefone(requestDTO.getTelefone());

        clienteRepository.save(cliente);

        return "Alterações feita com sucesso!";

    }

    public String deletarCliente(long id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()){
            return "Cliente não registrado";
        } else {
            clienteRepository.deleteById(id);
            return "Cliente apagado com sucesso";
        }
    }

}
