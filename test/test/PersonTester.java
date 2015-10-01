package test;

import control.PersonController;
import entity.Person;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Tobias Jacobsen
 */
public class PersonTester {

    public PersonTester() {

    }

    @Before
    public void beforeTest() {

    }

    @Test
    public void testAddPerson() {
        PersonController personController = new PersonController();
        Person p = personController.addPerson(null);
    }
}
