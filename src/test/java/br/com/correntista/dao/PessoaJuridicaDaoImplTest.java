package br.com.correntista.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import br.com.correntista.vo.PessoaJuridica;

import static util.GeradorUtil.*;

import java.util.List;

class PessoaJuridicaDaoImplTest {

	private PessoaJuridica pessoaJuridica;
	private PessoaJuridicaDao dao;
	private Session sessao;

	public PessoaJuridicaDaoImplTest() {
		this.dao = new PessoaJuridicaDaoImpl();
	}

//	@Test
	void testAlterar() {
		pesquisarPessoaJuridicaBD();
		pessoaJuridica.setNome(gerarNome());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(pessoaJuridica, sessao);
		sessao.close();

		sessao = HibernateUtil.abrirSessao();
		PessoaJuridica pessoaJuridicaAlt = dao.pesquisarPorId(pessoaJuridica.getId(), sessao);
		sessao.close();
		assertEquals(pessoaJuridica.getNome(), pessoaJuridicaAlt.getNome());
	}

//	@Test
	public void testSalvar() {
		pessoaJuridica = new PessoaJuridica(null, gerarNome(), gerarEmail()
											, gerarCnpj(), gerarNumero(10));
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(pessoaJuridica, sessao);
		sessao.close();
		assertNotNull(pessoaJuridica.getId());
	}

//	@Test
	void testExcluir() {
		pesquisarPessoaJuridicaBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(pessoaJuridica, sessao);
		PessoaJuridica pessoaJuridicaExc = dao.pesquisarPorId(pessoaJuridica.getId(), sessao);
		sessao.close();
		assertNull(pessoaJuridicaExc);

	}

	@Test
	void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from PessoaJuridica where id = :id");
		consulta.setParameter("id", consulta);
	}

	@Test
	void testPesquisarPorNome() {
		pesquisarPessoaJuridicaBD();
		sessao = HibernateUtil.abrirSessao();
		List<PessoaJuridica> profissoes = dao.pesquisarPorNome(pessoaJuridica.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(profissoes.size() > 0);
	}

	public PessoaJuridica pesquisarPessoaJuridicaBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from PessoaJuridica");
		List<PessoaJuridica> profissoes = consulta.list();
		sessao.close();

		if (profissoes.isEmpty()) {
			testSalvar();
		} else {
			pessoaJuridica = profissoes.get(0);
		}

		return pessoaJuridica;
	}

}
