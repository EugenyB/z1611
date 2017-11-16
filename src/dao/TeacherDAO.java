package dao;

import tables.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TeacherDAO {
    @PersistenceContext
    private EntityManager em;


    public List<Teacher> findAll() {
        return em.createNamedQuery("Teacher.FindAll", Teacher.class).getResultList();
    }

    public void delete(int id) {
        Teacher teacher = em.find(Teacher.class, id);
        em.remove(teacher);
    }

    public void add(Teacher teacher) {
        em.persist(teacher);
    }

    public Teacher find(int id) {
        return em.find(Teacher.class, id);
    }

    public void fixedit(Teacher teacher) {
        em.merge(teacher);
    }
}
