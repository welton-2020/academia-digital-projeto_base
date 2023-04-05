package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoUpdateForm {

  private String nome;

  private String bairro;

  private LocalDate dataDeNascimento;
}
