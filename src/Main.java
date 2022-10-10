//import intro.assignments.VersionManager;
import java1refresher.*;

//import java.util.Arrays;
import java.util.*;

//import intro.assignments.Version;

//import java.util.*;
//import java.lang.reflect.*;
//import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Map<Person, List<Animal>> owners_and_their_pets = new HashMap<>();

        Person marc = new Person("Marc");
        List<Animal> marcs_pets = new ArrayList<>();
        marcs_pets.add(new Cat("Zipper"));
        marcs_pets.add(new Cat("Waffles"));
        owners_and_their_pets.put(marc, marcs_pets);

        Person krystal = new Person("Krystal");
        List<Animal> krystal_pets = new ArrayList<>();
        krystal_pets.add(new Cat("Lulu"));
        krystal_pets.add(new Dog("Penny"));
        krystal_pets.add(new Cat("Gus"));
        owners_and_their_pets.put(krystal, krystal_pets);

        Person bob = new Person("Bob");
        List<Animal> bobs_pets = new ArrayList<>();
        owners_and_their_pets.put(bob, bobs_pets);

        Person amy = new Person("Amy");
        List<Animal> amys_pets = new ArrayList<>();
        amys_pets.add(new Cat("Velcro"));
        owners_and_their_pets.put(amy, amys_pets);

        Person john = new Person("John");
        List<Animal> johns_pets = new ArrayList<>();
        johns_pets.add(new Dog("Cooper"));
        owners_and_their_pets.put(john,johns_pets);

        Person kaitlyn =new Person("Kaitlyn");
        List<Animal> kaitlyns_pets = new ArrayList<>();
        kaitlyns_pets.add(new Cat("Midnight"));
        kaitlyns_pets.add(new Cat("Cloud"));
        kaitlyns_pets.add(new Cat("Ayla"));
        kaitlyns_pets.add(new Cat("Tippy Toes"));
        kaitlyns_pets.add(new Cat("Sambo"));
        kaitlyns_pets.add(new Cat("Butternut"));
        owners_and_their_pets.put(kaitlyn,kaitlyns_pets);

        owners_and_their_pets.forEach((person, pets) -> {
            // Part 1 code
            if (pets.size() > 1){
                String str = person.getFirstName() + "'s pets: ";
                int petCount = 0;
                for (Animal pet: pets) {
                    if (petCount == 0) {
                        str += pet.toString();
                        petCount++;
                    } else {
                        str += ", " + pet.toString();
                    }
                }
                System.out.println(str);
            }
            else if(pets.size() == 0){
                System.out.println(person.getFirstName() + " has no pets.");
            }
            else{
                System.out.println(person.getFirstName() + "'s " + "pet: " + pets.get(0).toString());
            }
        });
        System.out.println();

        processData(owners_and_their_pets);
        printReport();

    }

    static Map<String, Integer> counter = new HashMap<>();

    public static void processData(Map<Person, List<Animal>> map) {
        // Part 2 code
        map.forEach((person, pets) -> {
            for (Animal pet:pets){
                String petKey = pet.getClass().getSimpleName();
                if(!counter.containsKey(petKey)){
                    counter.put(petKey, 0);
                }
                else{
                    counter.put(petKey, counter.get(petKey) + 1);
                }
            }
        });
    }


    public static void printReport() {
        System.out.println("--- Animals Report ---");
        // Part 3 code
        counter.forEach((petKey, count) -> {
            System.out.println("Type: " + petKey + "\t Count: " + count);
        });
    }

//    public static void printCollection(Collection<?> collection) {
//        Class<?> listClass = null;
//        try {
//            Field listField = Main.class.getDeclaredField("collection");
//            ParameterizedType listType = (ParameterizedType) listField.getGenericType();
//            listClass = (Class<?>) listType.getActualTypeArguments()[0];
//        } catch(NoSuchElementException | NoSuchFieldException e) {
//            System.out.println("Cannot print this collection");
//        }
//
//        System.out.println("This " + collection.getClass().getSimpleName() + " contains " + collection.size() + " " + listClass.getSimpleName() + " element" + (collection.size() == 1? "" : "s"));
////        collection.forEach(element -> System.out.println(element));
////         collection.forEach(System.out::println);
////         System.out.println(collection.toString());
//        System.out.println(collection.stream().map(Object::toString).collect(Collectors.joining(", ")));
//        System.out.println();
//    }
}