package br.com.correntista.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.correntista.vo.Cartao;
import br.com.correntista.vo.Cliente;
import br.com.correntista.vo.Endereco;
import br.com.correntista.vo.PessoaFisica;
import br.com.correntista.vo.PessoaJuridica;
import br.com.correntista.vo.Profissao;

public class HibernateUtil {

    private static final SessionFactory sessionFactory; //singleton
    
    static {
        try {
            Configuration cfg = new Configuration();
//            cfg.addAnnotatedClass(Endereco.class);
//            cfg.addAnnotatedClass(Cartao.class);
            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(PessoaFisica.class);
//            cfg.addAnnotatedClass(PessoaJuridica.class);
            cfg.addAnnotatedClass(Profissao.class);
            

            cfg.configure("/br/com/correntista/dao/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session abrirSessao() {
        return sessionFactory.openSession();
    }
}
