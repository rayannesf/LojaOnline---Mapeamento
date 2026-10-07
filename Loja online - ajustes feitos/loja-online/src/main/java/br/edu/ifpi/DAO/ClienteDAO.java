package br.edu.ifpi.DAO;

import br.edu.ifpi.JPAUtil;
import br.edu.ifpi.Model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            String jpql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            query.setParameter("cpf", cpf);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
