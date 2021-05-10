package br.com.correntista.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.correntista.vo.Profissao;

public interface ProfissaoDao extends BaseDao<Profissao, Long> {
	
	List<Profissao> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
}
