/*
  Finds the longest subsequence which contains two unique characters within a given sequence.
 */

package app;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UniqueSubsequence {
    public static final int NUMBER_OF_UNIQUE_CHARACTERS = 2;

    public static void main(String[] args) {
        final String sequence = "ABAACACAACDA";
        final Set<Character> set = new HashSet<>();
        String maxSubsequence = sequence.substring(0, 1);
        StringBuilder subsequenceBuilder = new StringBuilder(sequence.length());
        Character c;

        for (int i = 0; i < sequence.length() - 1; i++) {
            c = sequence.charAt(i);
            subsequenceBuilder.append(c);
            set.add(c);
            for (int j = i + 1; j < sequence.length() - 1; j++) {
                c = sequence.charAt(j);
                subsequenceBuilder.append(c);
                set.add(c);

                // Check the next character
                c = sequence.charAt(j + 1);
                if (set.size() == NUMBER_OF_UNIQUE_CHARACTERS && !set.contains(c)) {
                    // End of subsequence
                    maxSubsequence = getMaxString(maxSubsequence, subsequenceBuilder.toString());
                    subsequenceBuilder.delete(0, subsequenceBuilder.length());
                    set.clear();
                    break;
                }
            }
        }

        System.out.println("For the given sequence: " + sequence + ",");
        System.out.println("the longest subsequence which contains two unique characters is: " + maxSubsequence);
    }

    /**
     * Returns the longest string of the given two strings.
     *
     * @param s1 String 1
     * @param s2 String 2
     * @return The longest string.
     */
    private static String getMaxString(String s1, String s2) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);

        if (s1.length() > s2.length()) {
            return s1;
        }

        return s2;
    }
}
