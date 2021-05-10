package br.com.correntista.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.correntista.vo.PessoaFisica;

public class PessoaFisicaDaoImpl extends BaseDaoImpl<PessoaFisica, Long>
implements PessoaFisicaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public PessoaFisica pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (PessoaFisica) sessao.get(PessoaFisica.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaFisica> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		
		Query consulta = sessao.createQuery("from PessoaFisica where nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}


}
