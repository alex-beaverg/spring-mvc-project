package by.springcourse.dao;

import by.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Bobrykov
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Alex"));
        people.add(new Person(++PEOPLE_COUNT, "John"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
        people.add(new Person(++PEOPLE_COUNT, "Jack"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        Person person = null;
        for (Person item: people) {
            if (item.getId() == id) {
                person = item;
                break;
            }
        }
        return person;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        for (Person item: people) {
            if (item.getId() == id) {
                people.remove(item);
                break;
            }
        }
    }
}
