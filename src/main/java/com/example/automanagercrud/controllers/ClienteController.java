package com.example.automanagercrud.controllers;

import com.example.automanagercrud.DTOs.ClienteRequestDTO;
import com.example.automanagercrud.DTOs.ClienteResponseDTO;
import com.example.automanagercrud.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody ClienteRequestDTO requestDTO){

        return  ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarCliente(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarIdCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarIdCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCliente(@Valid @PathVariable long id, @RequestBody ClienteRequestDTO requestDTO){
        return ResponseEntity.ok(clienteService.alterarCliente(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.deletarCliente(id));
    }
}
