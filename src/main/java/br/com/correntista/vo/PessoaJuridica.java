package br.com.correntista.vo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PessoaJuridica")
public class PessoaJuridica implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Column(nullable = false, length = 14, unique = true)
	private String cnpj;
	@Column(nullable = false, length = 9)
	private String inscricaoEstadual;
	
	public PessoaJuridica(Long id, String cnpj, String inscricaoEstadual) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
