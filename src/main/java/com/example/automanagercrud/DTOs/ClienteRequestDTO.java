package com.example.automanagercrud.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    @NotBlank
    private String nome;
    @Size(max = 20, message = "O maxiomo de caracteres é 20!")
    private String telefone;
    @Email
    @Size(max = 150, message = "O maxiomo de caracters é 150!")
    private String email;

}
