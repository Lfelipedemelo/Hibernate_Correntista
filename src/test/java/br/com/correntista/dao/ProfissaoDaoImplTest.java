package br.com.correntista.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import br.com.correntista.vo.Profissao;
import static util.GeradorUtil.*;

import java.util.List;

class ProfissaoDaoImplTest {
	
	private Profissao profissao;
	private ProfissaoDao dao;
	private Session sessao;

	
	public ProfissaoDaoImplTest() {
		this.dao = new ProfissaoDaoImpl();
	}


//	@Test
	void testAlterar() {
		pesquisarProfissaoBD();
		profissao.setDescricao(gerarCaracter(18));
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(profissao, sessao);
		sessao.close();
		
		sessao = HibernateUtil.abrirSessao();
		Profissao profissaoAlt = dao.pesquisarPorId(profissao.getId(), sessao);
		sessao.close();
		assertEquals(profissao.getDescricao(), profissaoAlt.getDescricao());
	}
	
//	@Test
	public void testSalvar() {
		profissao = new Profissao(gerarCaracter(8), gerarCaracter(18));
		sessao = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(profissao, sessao);
		sessao.close();
		assertNotNull(profissao.getId());
	}

//	@Test
	void testExcluir() {
		pesquisarProfissaoBD();
		sessao = HibernateUtil.abrirSessao();
		dao.excluir(profissao, sessao);
		Profissao profissaoExc = dao.pesquisarPorId(profissao.getId(), sessao);
		sessao.close();
		assertNull(profissaoExc);
		
	}

////	@Test
//	void testPesquisarPorId() {
//		sessao = HibernateUtil.abrirSessao();
//		Query consulta = sessao.createQuery("from Profissao where id = :id");
//		consulta.setParameter("id", consulta);
//	}

	@Test
	void testPesquisarPorNome() {
		pesquisarProfissaoBD();
		sessao = HibernateUtil.abrirSessao();
		List<Profissao> profissoes = dao.pesquisarPorNome(profissao.getNome().substring(0, 3), sessao);
		sessao.close();
		assertTrue(profissoes.size() > 0);
	}
	
	public Profissao pesquisarProfissaoBD() {
		sessao = HibernateUtil.abrirSessao();
		Query consulta = sessao.createQuery("from Profissao");
		List<Profissao> profissoes = consulta.list();
		sessao.close();
		
		if(profissoes.isEmpty()) {
			testSalvar();
		} else {
			profissao = profissoes.get(0);
		}
		
		return profissao;
}

}
