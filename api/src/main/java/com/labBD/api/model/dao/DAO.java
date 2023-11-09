package com.labBD.api.model.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;

public class DAO<E> {
    private EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("exerciciosJPA");
    private Class<E> classe;
    public DAO(Class<E> classe) {
        this.classe = classe;
    }

    public void setPersistenceUnity(String pU) {
        this.eMFactory = Persistence.createEntityManagerFactory(pU);
    }

    public E obterPorID(Object id) {
        EntityManager eM = this.eMFactory.createEntityManager();

        if (id instanceof Integer) {
            E result = eM.find(this.classe, (Integer)id);
            eM.close();
            return result;
        }
        if (id instanceof String) {
            E result = eM.find(this.classe, (String)id);
            eM.close();
            return result;
        }

        eM.close();

        return null;
    }


    public List<E> obterTodos(){
        EntityManager eM = this.eMFactory.createEntityManager();

        TypedQuery<E> query = eM.createQuery("SELECT e FROM " + this.classe.getSimpleName() + " e", this.classe);

        List<E> resultado = query.getResultList();

        eM.close();

        return resultado;
    }

    public boolean inserir(E obj) {
        EntityManager eM = this.eMFactory.createEntityManager();

        if(obj != null) {
            eM.getTransaction().begin();

            eM.persist(obj);

            eM.getTransaction().commit();
            eM.close();

            return true;
        }
        eM.close();
        return false;
    }

    public E excluirPorID(Object id) {
        EntityManager eM = this.eMFactory.createEntityManager();

        try {
            E exc = this.obterPorID(id);
            eM.remove(exc);
            eM.close();

            return exc;
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido: " + e.getMessage() + e.getStackTrace());
        }

        eM.close();
        return null;
    }

    public boolean atualizar(E objAlterado) {
        if (objAlterado != null) {
            EntityManager eM = this.eMFactory.createEntityManager();
            try {
                eM.getTransaction().begin();
                eM.merge(objAlterado);
                eM.getTransaction().commit();

                return true;
            } catch (RollbackException e) {
                System.out.println("Transação não concluída: " + e.getMessage());
            }
            eM.close();
            return false;
        } else {
            System.out.println("Objeto vazio!");
            return false;
        }
    }

    private void fechar() {
        this.eMFactory.close();
    }
}