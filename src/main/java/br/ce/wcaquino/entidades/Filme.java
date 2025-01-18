package br.ce.wcaquino.entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filme {

	private String nome;
	private Integer estoque;
	private Double precoLocacao;

}