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
        doesItWork("[abcdefg]+", challenge5, 5);
        doesItWork("[a-g]+", challenge5, 5);
        doesItWork("a{3}bc{7}d{3}ef{3}g$", challenge5, 6);

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
        String ukPostcodeRegex = "^\\s*(?i)[a-z]{1,2}\\d{1,2}\\s*\\d(?i)[a-z]{2}\\s*$"; //UK POSTCODE REGEX (simplified)
        doesItWork(ukPostcodeRegex, "VH21   2EF", 11);
        doesItWork(ukPostcodeRegex, "EH6 8SF", 11);
        doesItWork(ukPostcodeRegex, " GA168SX ", 11);
        doesItWork(ukPostcodeRegex, "G16 8SX", 11);
        doesItWork(ukPostcodeRegex, "GA162SF", 11);
        doesItWork(ukPostcodeRegex, "EH76  1SE", 11);
        doesItWork(ukPostcodeRegex, "B33 8TH      ", 11);
        doesItWork(ukPostcodeRegex, "CA12 4TN", 11);

        String plPostcodeRegex = "^\\d{2}\\s*-\\s*\\d{3}\\s*$";
        doesItWork(plPostcodeRegex, "22-400", 12);
        doesItWork(plPostcodeRegex, "21-200", 12);
        doesItWork(plPostcodeRegex, "20 - 827  ", 12);

        String ukPhoneNumberRegex = "^\\s*(\\+44|0)?\\s*\\d{3}\\s*\\d{3}\\s*(\\d{4}|\\d{2}\\s*\\d{2})\\s*$";//UK PHONE NUMBER REGEX (simplified)
        doesItWork(ukPhoneNumberRegex, "+44 794 710 5728", 13);
        doesItWork(ukPhoneNumberRegex, " +447147235318", 13);
        doesItWork(ukPhoneNumberRegex, "+44 714 723 53 18", 13);
        doesItWork(ukPhoneNumberRegex, " +44 714123 53 18", 13);
        doesItWork(ukPhoneNumberRegex, "0 714 100 23 38", 13);
        doesItWork(ukPhoneNumberRegex, "714 100 23 38 ", 13);
        doesItWork(ukPhoneNumberRegex, "7141002338", 13);

        String plPhoneNumberRegex = "^(0|\\+48)?\\s*\\d{3}\\s*(\\d{3}\\s*\\d{3}|\\d{2}\\s*\\d{2}\\s*\\d{2}\\s*)$"; //POLISH PHONE NUMBER REGEX (simplified)
        doesItWork(plPhoneNumberRegex, "0976234112", 14);
        doesItWork(plPhoneNumberRegex, "+48 976234112", 14);
        doesItWork(plPhoneNumberRegex, "+48 976 234 112", 14);
        doesItWork(plPhoneNumberRegex, "+48976 234112", 14);
        doesItWork(plPhoneNumberRegex, "+48976 234112", 14);
        doesItWork(plPhoneNumberRegex, "888 133 112", 14);
        doesItWork(plPhoneNumberRegex, "800 11 21 12", 14);
        doesItWork(plPhoneNumberRegex, "0 700 880 774", 14);
    }

    public static void doesItWork(String regex, String stringToValidate, int challengeNum){
        System.out.println("Challenge " + challengeNum + ": " + stringToValidate.matches(regex));
    }
}