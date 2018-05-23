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
    }
}
