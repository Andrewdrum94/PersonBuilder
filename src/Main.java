import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Гоша")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);
        mom.happyBirthday();

        OptionalInt momAge = mom.getAge();
        if (momAge.isPresent()) {
            int ageOfMom = momAge.getAsInt();
            System.out.println(ageOfMom);
        }

        Person vasya = new PersonBuilder().setName("Vasiliy").setSurname("Ivanovich").build();
        System.out.println(vasya);
        if (vasya.getAge().isPresent()) {
            System.out.println(vasya.getAge().getAsInt());
        }
        vasya.setAddress("Moscow");
        System.out.println(vasya);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-200).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
