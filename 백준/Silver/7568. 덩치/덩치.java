import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Person> people = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        Person[] save = new Person[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            Person person = new Person(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            people.add(person);
            save[i] = person;
        }

        for (int i = 0; i < count; i++) {
            int rank = 1;
            Person person = save[i];
            for (int j = 0; j < count; j++) {
                if (j == i) {
                    continue;
                }
                Person compare = save[j];
                if (person.tall < compare.tall && person.weight < compare.weight) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}

class Person {

    int weight;
    int tall;

    public Person(int weight, int tall) {
        this.tall = tall;
        this.weight = weight;
    }
}
