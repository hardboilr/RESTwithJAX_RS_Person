package test;

import control.ControlPerson;
import entity.Person;
import facade.FacadePerson;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tobias Jacobsen
 *
 * Problems running the createScript from the persistence.xml. It appears the
 * syntax is different here, than when running it "normally" Therefore I can't
 * just "reset" the database before every test, but have to manually "normalize" 
 * the database back to its initial state in each test
 */
public class PersonTester {

    public PersonTester() {
    }

    @Test
    public void testGetPerson() {
        FacadePerson ctrl = new ControlPerson();
        Person p1 = ctrl.getPerson(1l);
        Person p2 = ctrl.getPerson(9l);
        assertEquals(1l, p1.getId());
        assertEquals("Amethyst", p1.getFirstName());
        assertEquals(9l, p2.getId());
        assertEquals("Xandra", p2.getFirstName());
    }

    @Test
    public void testAddPerson() {
        Person person = new Person("Tobias", "Jacobsen", 31203083);
        FacadePerson ctrl = new ControlPerson();
        Person p = ctrl.addPerson(person);
        assertEquals("Tobias", p.getFirstName());
        assertEquals(31203083, p.getPhone());
        //delete person
        ctrl.deletePerson(11l);
    }

    @Test
    public void testDeletePerson() {
        FacadePerson ctrl = new ControlPerson();

        //add person first
        Person pTest = new Person("Tobias", "Jacobsen", 31203083);
        ctrl.addPerson(pTest);

        Person p = ctrl.deletePerson(11l);
        assertEquals(11l, p.getId());
        assertEquals("Tobias", p.getFirstName());
        assertNull(null, ctrl.getPerson(11l));
    }

    @Test
    public void testGetPersons() {
        FacadePerson ctrl = new ControlPerson();
        List<Person> personList = ctrl.getPersons();
        assertEquals(1l, personList.get(0).getId());
        assertEquals(10l, personList.get(9).getId());
        assertEquals("Amethyst", personList.get(0).getFirstName());
        assertEquals("Nathan", personList.get(9).getFirstName());
    }
    
    @Test
    public void testEditPerson() {
        FacadePerson ctrl = new ControlPerson();
        Person p1 = new Person("Niels", "Nielsen", 46403083);
        p1.setId(1l);
        Person p = ctrl.editPerson(p1);
        assertEquals("Niels", p.getFirstName());
        assertEquals(46403083, p.getPhone());
    }
}
