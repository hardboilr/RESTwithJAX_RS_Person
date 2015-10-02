package facade;
import entity.Person;
import java.util.List;

/**
 * @author Tobias Jacobsen
 */

public interface FacadePerson {
    public Person addPerson(Person p);
    public Person deletePerson(long id);
    public Person getPerson(long id);
    public List<Person> getPersons();
    public Person editPerson(Person p);
}
