import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Comparator;



public class Main {
    public static void main(String[] args) {
        ArrayList<String> studenti = new ArrayList<>();
        studenti.add("Cosmin");
        studenti.add("Ghiseandru");
        studenti.add("Bogdan");
        studenti.add("Octavian");
        studenti.add("Carlos Prates");
        for (String nume : studenti) {
            System.out.println(nume);
        }
        studenti.remove(2);
        System.out.println("Stergere studentul nr.3: " + studenti);

        List<Integer> numere = new ArrayList<>();
        numere.add(10);
        numere.add(98);
        numere.add(99);
        numere.add(18);
        numere.add(18);
        numere.add(18);
        numere.add(47);
        numere.add(22);
        numere.add(22);
        numere.add(50);
        int suma = 0;
        for (int n : numere) {
            suma += n;
        }
        double medie = (double) suma / numere.size();
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + medie);

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        Collections.reverse(lista);
        System.out.println("Lista inversata: " + lista);
        String propozitie = "Sunt Cosmin si abia astept meciul dintre mcgregor si holloway!";
        String[] cuvinte = propozitie.split(" ");
        Set<String> unice = new HashSet<>();
        for (String c : cuvinte) {
            unice.add(c);
        }
        System.out.println("Cuvinte unice: " + unice);
        System.out.println("Numar cuvinte unice: " + unice.size());


        String text = "apple banana apple orange banana apple";
        String[] words = text.split(" ");
        Map<String, Integer> frecventa = new HashMap<>();
        for (String w : words) {
            frecventa.put(w, frecventa.getOrDefault(w, 0) + 1);
        }
        System.out.println("Frecventa: " + frecventa);
        Map<String, String> agenda = new HashMap<>();
        agenda.put("Cosmin", "0711111111");
        agenda.put("Ghiseandru", "0722222222");
        agenda.put("Bogdan", "0733333333");
        System.out.println("Nr Cosmin: " + agenda.get("Cosmin"));
        System.out.println("Intrari: " + agenda);



        List<Student> elevi = new ArrayList<>();
        elevi.add(new Student("Cosmin", 6));
        elevi.add(new Student("Ghiseandru", 9));
        elevi.add(new Student("Bogdan", 7));
        elevi.add(new Student("Octavian", 6));
        for (Student st : elevi) {
            System.out.println(st);
        }

        Student premiant = elevi.get(0);
        for (Student st : elevi) {
            if (st.grade > premiant.grade) {
                premiant = st;
            }
        }
        System.out.println("Premiant: " + premiant);

        elevi.sort(Comparator.comparing(a -> a.name));
        System.out.println("Sortre alfabetic: " + elevi);

        elevi.sort(Comparator.comparing((Student a) -> a.grade).reversed());
        System.out.println("Sortare note desc: " + elevi);

        elevi.add(new Student("Cosmin", 6));
        elevi.add(new Student("Ghiseandru", 9));
        Set<Student> unic = new HashSet<>(elevi);
        System.out.println("Dupa eliminare duplicate: " + unic);

    }
}