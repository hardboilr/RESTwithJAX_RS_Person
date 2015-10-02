package control;

import entity.Person;
import facade.FacadePerson;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Tobias Jacobsen
 */
public class ControlPerson implements FacadePerson {

    EntityManagerFactory emf;
    EntityManager em;

    public ControlPerson() {
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
    }

    @Override
    public Person getPerson(long id) {
        return em.find(Person.class, id);
    }

    @Override
    public Person addPerson(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    @Override
    public Person deletePerson(long id) {
        Person p = em.find(Person.class, id);
        em.remove(p);
        return p;
    }

    @Override
    public List<Person> getPersons() {
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> personList = query.getResultList();
        return personList;
    }

    @Override
    public Person editPerson(Person pers) {
         Person p = em.find(Person.class, pers.getId());
        if (p != null) {
            em.getTransaction().begin();
            p = pers;
            em.getTransaction().commit();
        }
        return p;
    }
}
