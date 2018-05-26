package regexChallenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenges {

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
        doesItWork("[abcdefg]+", challenge5,5);
        doesItWork("[a-g]+", challenge5,5);
        doesItWork("a{3}bc{7}d{3}ef{3}g$", challenge5,6);

        doesItWork("\\D+.\\d+", "kI.2", 7);
        doesItWork("[a-z]+.\\d+", "abc.123", 7);
        doesItWork("(?i)[a-z]+.\\d+", "AbcddaAA.12334422", 7);

        String challenge8 = "abcd.123uvqz.7tzik.999";
        Pattern chall8pattern = Pattern.compile("(?i)[a-z]+\\.(\\d+)");
        Matcher chall8matcher = chall8pattern.matcher(challenge8);

        System.out.println(challenge8.matches("(?i)[a-z]+.(\\d+)(?i)[a-z]+.\\d(?i)[a-z]+.\\d+"));

        while(chall8matcher.find()){
            System.out.println("Challenge 8 : Occurence: " + chall8matcher.group(1));
        }
    }

    public static void doesItWork(String regex, String challenge, int challengeNum){
        System.out.println("Challenge " + challengeNum + ": " + challenge.matches(regex));
    }
}