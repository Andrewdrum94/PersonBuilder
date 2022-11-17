import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return this.age > 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == -1) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(age);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public void happyBirthday() {
        if (hasAge()) this.age++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ageToString() +
                addressToString() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        Person o = (Person) obj;
        return name.equals(o.name) && surname.equals(o.surname);
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAge(1)
                .setAddress(getAddress());
    }

    private String ageToString() {
        if (!hasAge()) {
            return "";
        } else {
            return ", age=" + age + '\'';
        }
    }

    private String addressToString() {
        if (!hasAddress()) {
            return "";
        } else {
            return ", Address='" + address + '\'';
        }
    }
}
