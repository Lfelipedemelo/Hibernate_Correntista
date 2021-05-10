package br.com.correntista.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.correntista.vo.Profissao;

public class ProfissaoDaoImpl extends BaseDaoImpl<Profissao, Long>
							implements ProfissaoDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public Profissao pesquisarPorId(Long id, Session sessao) throws HibernateException {	
		return (Profissao) sessao.get(Profissao.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profissao> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		
		Query consulta = sessao.createQuery("from Profissao where nome like :nome");
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.list();
	}


}
