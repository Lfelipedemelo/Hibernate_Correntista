package br.com.correntista.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.correntista.vo.PessoaJuridica;

public class PessoaJuridicaDaoImpl extends BaseDaoImpl<PessoaJuridica, Long>
implements PessoaJuridicaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public PessoaJuridica pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (PessoaJuridica) sessao.get(PessoaJuridica.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaJuridica> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		
		Query consulta = sessao.createQuery("from PessoaJuridica where nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}


}
