package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        StringBuilder htmlString = new StringBuilder("<h2>A heading</h2>");
        htmlString.append("<p>A new paragraph</p>");
        htmlString.append("<h2>Another heading</h2>");
        htmlString.append("<p>A new subparahraph</p>");

        String h2pattern = "(<h2>)";//Everything before and everything after
        Pattern pattern = Pattern.compile(h2pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher1 = pattern.matcher(htmlString);
        System.out.println(matcher1.matches());

        int count = 0;
        matcher1.reset();
        while(matcher1.find()){
            count++;
            System.out.println("Occurence: " + count + " => " + matcher1.start() + " to " + matcher1.end());
        }

        String h2Group = "(<h2>.*?</h2>)";
        Pattern h2GroupPattern = Pattern.compile(h2Group);
        Matcher groupMatcher = h2GroupPattern.matcher(htmlString);
        groupMatcher.reset();

        while(groupMatcher.find()){
            System.out.println("Occurence: " + groupMatcher.group(1));
        }

        //Reading what's the content between the tags is
        String h2TextGroup = "(<h2>)(.*?)(</h2>)";
        Pattern h2TextGroupPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextGroupMatcher = h2TextGroupPattern.matcher(htmlString);

        while(h2TextGroupMatcher.find()){
            System.out.println("Occurence: " + h2TextGroupMatcher.group(2));
        }

        //Logical operators in regex
        //OR
        System.out.println("Larry".replaceAll("[L|l]arry", "Harry"));
        System.out.println("larry".replaceAll("[L|l]arry", "Barry"));
        //NOT
        String tvWord = "tstvtvst";
        //String tNotVRegEx = "t[V|v]";
        String tNotVRegEx = "t(?!V|v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvWord);

        count = 0;
        while(tNotVMatcher.find()){
            count++;
            System.out.println("Occurence: " + count + " --> " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

    }
}
