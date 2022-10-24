import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Homework9 {
   /*
    У нас есть список стран countries =
    ["Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"]
    и есть список слов words =
    ["Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba",
     "Finland", "Axelrod" , "Avangard", "Cuba"]
     нужно получить список всех стран из списка слов, начинающихся на "A" - т.е., ["Argentina", "Andorra"]
    */

    public static void main(String[] args) {
        String[] countries = {"Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"};
        String[] words2 = {"Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod", "Avangard", "Cuba"};
        Set<String> endResult = new HashSet<>();
        Set<String> countries1 = new HashSet<>(List.of(countries));
        for (String w : words2) {
            if (countries1.contains(w) && w.charAt(0) == 'A')
                endResult.add(w);
        }
        System.out.println(endResult);
    }

}
