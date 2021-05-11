package br.com.correntista.vo;

import javax.persistence.*;

@Entity
@Table(name = "PessoaJuridica")
@PrimaryKeyJoinColumn(name = "idCliente")
public class PessoaJuridica extends Cliente{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String cnpj;
	@Column(nullable = false, unique = true)
	private String inscricaoEstadual;
	
	public PessoaJuridica() {
	}
	
	public PessoaJuridica(Long id, String nome, String email , String cnpj, String inscricaoEstadual) {
		super(id, nome, email);
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
}
