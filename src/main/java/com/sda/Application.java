package com.sda;

import com.sda.model.Address;
import com.sda.model.User;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RENT on 2017-07-01.
 */
public class Application {
    public static void main(String[] args) {

        Address address = Address.builder()
                .city("Poznan")
                .street("Grunwaldzka")
                .flatNumber(18)
                .postalCode("60-12345")
                .build();

        Address address2 = Address.builder()
                .city("Pila")
                .street("Grudnia")
                .flatNumber(20)
                .postalCode("60-12345")
                .build();

        Address address3 = Address.builder()
                .city("Lipa")
                .street("Kreta")
                .flatNumber(22)
                .postalCode("62-23345")
                .build();

        User user = User.builder()
                .firstName("Ula")
                .lastName("Radon")
                .age(30)
                .phoneNumber("12234234")
                .address(address)
                .build();

        User user2 = User.builder()
                .firstName("Janina")
                .lastName("Makota")
                .age(16)
                .phoneNumber("758647834")
                .address(address2)
                .build();

        User user3 = User.builder()
                .firstName("Jan")
                .lastName("Makota")
                .age(22)
                .phoneNumber("896734234")
                .address(address2)
                .build();

        User user4 = User.builder()
                .firstName("Ela")
                .lastName("Kowalski")
                .age(31)
                .phoneNumber("6877234234")
                .address(address3)
                .build();

        List<User> users = Arrays.asList(user, user2, user3, user4);

//        List<String> list = new ArrayList<>();

        users.stream()
                .filter(e -> e.getAge() > 29)
                .forEach(e -> System.out.println(e));

//        users.stream()
//                .filter(e -> e.getAge() > 29)
//                .forEach(System.out::println);

        users.stream()

                .filter(e -> e.getAddress().getCity().equals("Pila"))
                .forEach(e -> System.out.println(e));

        users.stream()
                .filter(e -> e.getAddress().getPostalCode().startsWith("60"))
//                .filter(e -> e.getAddress().getCity().equals("Pila"))
                .forEach(e -> System.out.println(e));

        System.out.println(users.stream()
                .filter(e -> e.getLastName().equals("Makota"))
                .count());

        users.stream()
                .map(e -> e.getLastName())
                .filter(e -> "Makota".equals(e))
                .count();

        users.stream()
                .map(e -> e.getAddress())
                .distinct()
                .count();

        users.stream()
                .filter(e -> e.getAddress().equals(address2))
                .forEach(e -> System.out.println(e));


//      users.forEach();

//      wyświetlić userów powyżej wieku 29
//      wyświetlić userów z Poznania
//      kod pocztowy zaczyna się od 60
//      zliczyć wystąpienia nazwiska Makota
//      osoby pod tym samym adresem

//        7 lista userow ktorych imie zaczyna sie od J

        List<User> usersWithFirstName = users.stream()
                .filter(e -> e.getFirstName().startsWith("J"))
                .collect(Collectors.toList());

//        8 sprawdz czy w kolekcji istnieje ktos z miasta Kalisz

        System.out.println(users.stream()
                .map(e -> e.getAddress())
                .distinct()
                .map(e -> e.getCity())
                .anyMatch(e -> "Kalisz".equals(e)));

//        9 sprawdz czy wszyscy userzy o nazwisku kowalski mieszkaja w poznaniu

        System.out.println(users.stream()
                .filter(e -> "Kowalski".equals(e.getLastName()))
                .map(e -> e.getAddress())
                .map(e -> e.getCity())
                .distinct()
                .allMatch(e -> "Poznan".equals(e)));

//        10  obliczyc srednia wieku userow

        System.out.println(users.stream()
                .mapToInt(e -> e.getAge())
                .average());

//        11 wyswietlic hashe wszystkich userow
        users.stream()
                .map(e -> e.getAddress())
                .mapToInt(e -> e.hashCode())
                .forEach(e -> System.out.println(e));


        Map<String, List<User>> usersByDistrict = new HashMap<>();
        usersByDistrict.put("wielkopolskie", Arrays.asList(user, user2, user3));
        usersByDistrict.put("mazowieckie", Arrays.asList(user4));

        usersByDistrict.entrySet().stream()
                .map(e -> e.getValue())
                .flatMap(e -> e.stream())
                .forEach(e -> System.out.println(e));

        List<String> names2 = new ArrayList<>();
        names2.add("Szymon");
        names2.add("Anna");
        names2.add("Jan");
        names2.add("Tadeusz");
        names2.add("Mateusz");

//        HashSet<String> namesSet = new HashSet<>(names2);
//        List<String> distinctNames = new ArrayList<>(namesSet);

        Set<String> namesSet = new HashSet<>();
        List<String> toRemove = new ArrayList<>();
        for (int i = 0; i < names2.size(); i++) {
            String name = names2.get(i);
            if (namesSet.contains(name)) {
                toRemove.add(name);
            } else {
                namesSet.add(name);
            }
        }
        System.out.println(names2);
        names2.removeAll(toRemove);
        System.out.println(names2);


//        names.stream()
////                .map(e -> new ArrayList(Arrays.asList(e.toCharArray())))
//                .map(e -> convert(e))
//                .flatMap(e -> e.stream())
//                .map(e -> e.toLowerCase())
//                .distinct()
//                .sorted()
//                .forEach(e -> System.out.println(e));
//    }
//
//    private static <R> R convert(String e) {
//    }


    }
}
