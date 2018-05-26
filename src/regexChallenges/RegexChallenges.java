package regexChallenges;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

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

        String challenge9 = "abcd.335\tuvqz.417\ttzik.911\n";
        Pattern chall9pattern = Pattern.compile("(?i)[a-z]+\\.(\\d+)\\D");
        Matcher chall9matcher = chall9pattern.matcher(challenge9);

        while(chall9matcher.find()){
            System.out.println("Challenge 9 : Occuerence: " + chall9matcher.group(1));
        }

        String challenge10 = "{0, 1}, {0, yy}, {1, 3}, {2, 5}, {2a, 56}, {23, 1}";
        System.out.println("Challenge 10 : " + challenge10.replaceAll("[{}]", ""));
        Pattern chall10pattern = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher chall10matcher = chall10pattern.matcher(challenge10);

        while(chall10matcher.find()){
            System.out.println("Challenge 10 : " + chall10matcher.group(1));
        }
        String ukPostcodeRegex = "^(?i)[a-z]{1,2}\\d{1,2}\\s*\\d(?i)[a-z]{2}$"; //UK POSTCODE REGEX (simplified)
        System.out.println("Challenge 11 : " + "VH21   2EF".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "EH6 8SF".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "GA168SX".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "G16 8SX".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "GA162SF".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "EH76  1SE".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "B33 8TH".matches(ukPostcodeRegex));
        System.out.println("Challenge 11 : " + "CA12 4TN".matches(ukPostcodeRegex));

        String plPostcodeRegex = "^\\d{2}-\\d{3}$";
        System.out.println("Challenge 12 : " + "22-400".matches(plPostcodeRegex));
        System.out.println("Challenge 12 : " + "21-200".matches(plPostcodeRegex));
        System.out.println("Challenge 12 : " + "20-827".matches(plPostcodeRegex));

        String ukPhoneNumberRegex = "^\\+44?\\s*\\d{3}\\s*\\d{3}\\s*(\\d{4}|\\d{2}\\s*\\d{2})$";
        System.out.println("Challenge 13 : " + "+44 794 710 5728".matches(ukPhoneNumberRegex));
        System.out.println("Challenge 13 : " + "+447147235318".matches(ukPhoneNumberRegex));
        System.out.println("Challenge 13 : " + "+44 714 723 53 18".matches(ukPhoneNumberRegex));
        System.out.println("Challenge 13 : " + "+44 714123 53 18".matches(ukPhoneNumberRegex));
        System.out.println("Challenge 13 : " + "0 714 100 23 38".matches(ukPhoneNumberRegex));
        System.out.println("Challenge 13 : " + "714 100 23 38".matches(ukPhoneNumberRegex));
        System.out.println("Challenge 13 : " + "7141002338".matches(ukPhoneNumberRegex));
    }

    public static void doesItWork(String regex, String challenge, int challengeNum){
        System.out.println("Challenge " + challengeNum + ": " + challenge.matches(regex));
    }
}