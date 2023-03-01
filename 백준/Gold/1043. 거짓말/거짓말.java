import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int countOfPeoples = Integer.parseInt(input[0]);
        int countOfParties = Integer.parseInt(input[1]);
        int[] parents = initializeParents(countOfPeoples);

        input = br.readLine().split(" ");
        int countOfKnownPeoples = Integer.parseInt(input[0]);
        int[] cautions = new int[countOfKnownPeoples];
        for (int i=0; i<countOfKnownPeoples; i++) {
            cautions[i] = Integer.parseInt(input[i+1]);
        }

        List<int[]> parties = new ArrayList<>();
        getParties(br, countOfParties, parties);

        for (int[] party : parties) {
            int firstPeople = party[0];

            for (int i=1; i<party.length; i++) {
                union(firstPeople, party[i], parents);
            }
        }

        int answer = countOfParties;
        for (int[] party : parties) {
            for (int j=0; j<cautions.length; j++) {
                int partyA = find(party[0], parents);
                int partyB = find(cautions[j], parents);

                if (partyA == partyB) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static int[] initializeParents(int countOfParties) {
        int[] parents = new int[countOfParties +1];
        for (int i=0; i<parents.length; i++) {
            parents[i] = i;
        }
        return parents;
    }

    private static void getParties(BufferedReader br, int countOfParties, List<int[]> parties) throws IOException {
        String[] input;
        for (int i = 0; i< countOfParties; i++) {
            input = br.readLine().split(" ");
            int count = Integer.parseInt(input[0]);
            int[] party = new int[count];
            for (int j=0; j<count; j++) {
                party[j] = Integer.parseInt(input[j+1]);
            }

            parties.add(party);
        }
    }

    private static void union(int peopleA, int peopleB, int[] parents) {
        int partyA = find(peopleA, parents);
        int partyB = find(peopleB, parents);

        if (partyA < partyB) {
            parents[partyB] = partyA;
        } else {
            parents[partyA] = partyB;
        }
    }

    private static int find(int people, int[] parents) {
        if (people == parents[people]) return people;

        return parents[people] = find(parents[people], parents);
    }
}
