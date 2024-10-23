import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Country> country = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            country.add(new Country(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        Collections.sort(country);

        int rank = 1;
        int tie = 1;
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && country.get(i).compareTo(country.get(i - 1)) == 0) {
                country.get(i).rank = tie;
            } else {
                country.get(i).rank = rank;
                tie = rank;
            }

            rank++;

            if (country.get(i).id == k) {
                System.out.println(country.get(i).rank);
                return;
            }
        }
    }
}

class Country implements Comparable<Country> {

    int id;
    int gold;
    int silver;
    int bronze;
    int rank;

    public Country(int id, int gold, int silver, int bronze) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Country o) {
        if (this.gold != o.gold) {
            return o.gold - this.gold;
        }
        if (this.silver != o.silver) {
            return o.silver - this.silver;
        } else {
            return o.bronze - this.bronze;
        }
    }
}
