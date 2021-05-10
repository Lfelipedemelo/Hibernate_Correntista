package br.com.correntista.vo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="cartao")
public class Cartao implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 16)
    private String numero;
    @Column(nullable = false)
    private String bandeira;
    @Column(nullable = false)
    private String validadeAno;
    @ManyToOne
    private Cliente cliente;
	public Cartao(Long id, String numero, String bandeira, String validadeAno, Cliente cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.bandeira = bandeira;
		this.validadeAno = validadeAno;
		this.cliente = cliente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getValidadeAno() {
		return validadeAno;
	}
	public void setValidadeAno(String validadeAno) {
		this.validadeAno = validadeAno;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    
}
