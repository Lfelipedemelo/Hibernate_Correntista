package br.com.correntista.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.correntista.vo.PessoaFisica;
import br.com.correntista.vo.Profissao;

public interface PessoaFisicaDao extends BaseDao<PessoaFisica, Long> {

	List<PessoaFisica> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
}
