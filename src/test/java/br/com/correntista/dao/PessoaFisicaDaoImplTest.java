package br.com.correntista.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import br.com.correntista.vo.PessoaFisica;
import static util.GeradorUtil.*;

import java.util.List;

class PessoaFisicaDaoImplTest {

	private PessoaFisica pessoaFisica;
	private PessoaFisicaDao dao;
	private Session sessao;

	public PessoaFisicaDaoImplTest() {
		this.dao = new PessoaFisicaDaoImpl();
	}

//	@Test
	void testAlterar() {
		pesquisarPessoaFisicaBD();
		pessoaFisica.setNome(gerarNome());
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(pessoaFisica, sessao);
		sessao.close();

		sessao = HibernateUtil.abrirSessao();
		PessoaFisica pessoaFisicaAlt = dao.pesquisarPorId(pessoaFisica.getId(), sessao);
		sessao.close();
		assertEquals(pessoaFisica.getNome(), pessoaFisicaAlt.getNome());
	}

//	@Test
	public void testSalvar() {
		pessoaFisica = new PessoaFisica(null, gerarNome(), gerarEmail(), gerarCpf(), gerarNumero(7));
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(pessoaFisica, sessao);
		sessao.close();
		assertNotNull(pessoaFisica.getId());
	}

//	@Test
	void testExcluir() {
		pesquisarPessoaFisicaBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(pessoaFisica, sessao);
		PessoaFisica pessoaFisicaExc = dao.pesquisarPorId(pessoaFisica.getId(), sessao);
		sessao.close();
		assertNull(pessoaFisicaExc);

	}

//	@Test
	void testPesquisarPorId() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from PessoaFisica where id = :id");
		consulta.setParameter("id", consulta);
	}

//	@Test
	void testPesquisarPorNome() {
		pesquisarPessoaFisicaBD();
		sessao = HibernateUtil.abrirSessao();
		List<PessoaFisica> profissoes = dao.pesquisarPorNome(pessoaFisica.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(profissoes.size() > 0);
	}

	public PessoaFisica pesquisarPessoaFisicaBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from PessoaFisica");
		List<PessoaFisica> profissoes = consulta.list();
		sessao.close();

		if (profissoes.isEmpty()) {
			testSalvar();
		} else {
			pessoaFisica = profissoes.get(0);
		}

		return pessoaFisica;
	}

}
