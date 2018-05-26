package regexChallenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenges1 {

    public static void main(String[] args) {
        String challenge1 = "I want a bike";
        doesItWork("I want a bike", challenge1, 1);

        String challenge2 = "I want a ball";
        doesItWork("I want a \\w+", challenge1, 2);
        doesItWork("I want a \\w+", challenge2, 2);
        String altChallenge2Regex = "I want a (bike|ball)";
        doesItWork(altChallenge2Regex, challenge1, 2);
        doesItWork(altChallenge2Regex, challenge2, 2);

        Pattern chall3pattern = Pattern.compile("I want a \\w+");
        Matcher chall3matcher1 = chall3pattern.matcher(challenge1);
        Matcher chall3matcher2 = chall3pattern.matcher(challenge2);

        System.out.println("Challenge 3: " + chall3matcher1.matches());
        System.out.println("Challenge 3: " + chall3matcher2.matches());

        String challenge4 = "Replace all blank spaces with underscores";
        System.out.println("Challenge 4 : " + challenge4.replaceAll(" ", "_"));
        System.out.println("Challenge 4 : " + challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabcccccccdddefffg";
        System.out.println("Challenge 5 : " + challenge5.matches("a{3}bc{7}d{3}ef{3}g"));
    }

    private static void doesItWork(String regex, String challenge, int challengeNum){
        System.out.println("Challenge " + challengeNum + ": " + challenge.matches(regex));
    }
}