package regexChallenges;

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
    }

    private static void doesItWork(String regex, String challenge, int challengeNum){
        System.out.println("Challenge " + challengeNum + ": " + challenge.matches(regex));
    }
}
