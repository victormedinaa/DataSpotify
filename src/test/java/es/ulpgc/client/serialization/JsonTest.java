package es.ulpgc.client.serialization;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class JsonTest {

    private Character person;

    @Before
    public void setUp() {
        person = new Character();
        person.name = "Eren";
        person.age = 15;
        person.friends = List.of("Armin", "Mikasa");
    }

    @Test
    public void should_serialize_json_correctly() {
        String json = Json.toJson(person);

        assertNotNull(json);
        assertFalse(json.isBlank());
        //assertFalse(json.isBlank())

        Character deserialized = Json.fromJson(json, Character.class);

        assertNotNull(deserialized);
        assertEquals(person, deserialized);

        System.out.println(json);
    }

    private static class Character {

        private String name;
        private int age;
        private List<String> friends;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Character person = (Character) o;
            return age == person.age && Objects.equals(name, person.name) && Objects.equals(friends, person.friends);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, friends);
        }
    }
}