package principal.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import principal.logica.entities.Autor;
import principal.logica.entities.Editorial;
import principal.logica.entities.Libro;
import principal.persistence.exceptions.NonexistentEntityException;

public class LibroJpaController implements Serializable {
    
    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public LibroJpaController() {
        emf = Persistence.createEntityManagerFactory("libreriaJPAPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long isbn = libro.getIsbn();
                if (findLibro(isbn) == null) {
                    throw new NonexistentEntityException("The autor with id " + isbn + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findAutorEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Libro> cq = em.getCriteriaBuilder().createQuery(Libro.class);
            cq.select( cq.from(Libro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            List<Libro> listaL = q.getResultList();
            return listaL;
        } finally {
            em.close();
        }
    }

    public Libro findLibro(long isbn) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, isbn);
        } finally {
            em.close();
        }
    }

    public Libro findLibroByName(String titulo) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, titulo);
        } finally {
            em.close();
        }
    }

    public Libro findLibroByAutor(Autor autor) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, autor);
        } finally {
            em.close();
        }
    }

    public Libro findLibroByEditorial(Editorial editorial) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, editorial);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(cb.count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
