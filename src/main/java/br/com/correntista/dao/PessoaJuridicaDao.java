package br.com.correntista.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.correntista.vo.PessoaJuridica;

public interface PessoaJuridicaDao extends BaseDao<PessoaJuridica, Long> {

	List<PessoaJuridica> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
}
