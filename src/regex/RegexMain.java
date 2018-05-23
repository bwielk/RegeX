package regex;

public class RegexMain {

    public static void main(String[] args) {
        String phrase = "I am hungry and I am going to eat chicken nuggets";
        System.out.println(phrase);

        String youAreHungryPhrase = phrase.replaceAll("I am", "You are");
        System.out.println(youAreHungryPhrase);

        String alphanumeric1 = "abcdefGHIIIJjjkl6543";
        System.out.println(alphanumeric1.replaceAll(".", "Y"));//replaces all chars with Y
        System.out.println(alphanumeric1.replaceAll("^abcdef", "HERE_WERE_THE_CHARS__"));//replaces all chars with Y

        String alphanumeric2 = "abcdefGHIIIJjjkabcdefl6543";
        System.out.println(alphanumeric2.replaceAll("^abcdef", "HERE_WERE_THE_CHARS__"));

        System.out.println(alphanumeric1.matches("^hello"));//false
        System.out.println(alphanumeric1.matches("^HERE_WERE_THE_CHARS__"));//false

        System.out.println(alphanumeric1.replaceAll("kl6543$", "THIS_IS_THE_END"));
        System.out.println(alphanumeric1.replaceAll("[GHIII]", "(CHAR)"));

        System.out.println("blazej".replaceAll("[Bb]", "XX"));
        System.out.println("blazej".replaceAll("[^Bb]", "XYZ"));
        System.out.println(alphanumeric1.replaceAll("[abcdefGgHhIiJ12345]", "X"));
        System.out.println(alphanumeric1.replaceAll("[a-f1-5]", "X"));
        System.out.println(alphanumeric1.replaceAll("[a-fA-Z1-5]", "X"));
        System.out.println(alphanumeric1.replaceAll("(?i)[a-j1-5]", "X"));//(?i) cancels case sensitivity
        System.out.println(alphanumeric1.replaceAll("\\d", "X"));// \\d replaces any digits
        System.out.println(alphanumeric1.replaceAll("\\D", "X"));// \\d replaces any non-digits

        String stringWithSpaces = "Lorem impsum \nLorem ipsum two \tLorem ipsum three";
        System.out.println(stringWithSpaces.replaceAll("\\s", "(SPACE)"));// \\s removes any sort of spaces
        System.out.println(stringWithSpaces.replaceAll("\\S", "."));
        System.out.println(stringWithSpaces.replaceAll("\\W", "."));
        System.out.println(stringWithSpaces.replaceAll("\\w", "."));
        System.out.println(stringWithSpaces.replaceAll("\\b", "<b>"));

        //QUANTIFIER {x}; +;
        String alphanumeric3 = "abcdEEEEEEEEEEEEEEEEEEEEfghiJJJJjjjJ1a2b3c4d";
        System.out.println(alphanumeric3.replaceAll("^abcdE{3}", "X"));
        System.out.println(alphanumeric3.replaceAll("^abcdE+", "X"));
        System.out.println(alphanumeric3.replaceAll("^abcdE*", "X"));
        System.out.println(alphanumeric3.replaceAll("^abcdE{2,5}", "X"));
        System.out.println(alphanumeric3.replaceAll("(?i)e+fghij*", "X"));

        //Patterns and Matchers
        
    }
}
