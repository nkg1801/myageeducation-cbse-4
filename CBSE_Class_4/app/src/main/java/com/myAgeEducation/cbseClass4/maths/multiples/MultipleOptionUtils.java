package com.myAgeEducation.cbseClass4.maths.multiples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MultipleOptionUtils {
    private static final Random RANDOM = new Random();
    private static final int OPTION_COUNT = 4;

    private MultipleOptionUtils() {}

    public static String[] generateTrueFalseOptions() {
        return new String[]{"TRUE", "FALSE"};
    }

    public static String[] generateCommonMultipleOptions(int n1, int n2) {
        int lcm = getLCM(n1, n2);
        
        // Correct answer is a multiple of LCM
        int correct = lcm * (1 + RANDOM.nextInt(3));
        
        List<Integer> options = new ArrayList<>();
        options.add(correct);
        
        // Distractors: multiples of n1 but not n2, or n2 but not n1, or neither.
        List<Integer> distractors = new ArrayList<>();
        int candidate = Math.min(n1, n2);
        while (distractors.size() < 10) {
            if (candidate % n1 == 0 && candidate % n2 == 0) {
                // skip, it's a common multiple
            } else if (candidate % n1 == 0 || candidate % n2 == 0) {
                distractors.add(candidate);
            } else {
                // also add some that are neither if we need
                if (RANDOM.nextBoolean()) distractors.add(candidate);
            }
            candidate++;
            if (candidate > correct + 50) break;
        }

        // Add 3 distractors
        addRandomDistinctValues(options, distractors, OPTION_COUNT);
        
        // Ensure we have 4
        while (options.size() < OPTION_COUNT) {
            int r = RANDOM.nextInt(100) + 1;
            if (!options.contains(r) && (r % n1 != 0 || r % n2 != 0)) {
                options.add(r);
            }
        }

        Collections.shuffle(options, RANDOM);
        return toStringArray(options);
    }

    private static int getGCD(int a, int b) {
        while (b > 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int getLCM(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / getGCD(a, b);
    }

    private static void addRandomDistinctValues(List<Integer> target, List<Integer> source, int totalCount) {
        List<Integer> available = new ArrayList<>(source);
        Collections.shuffle(available, RANDOM);
        for (Integer val : available) {
            if (!target.contains(val)) {
                target.add(val);
            }
            if (target.size() >= totalCount) break;
        }
    }

    private static String[] toStringArray(List<Integer> options) {
        String[] res = new String[options.size()];
        for (int i = 0; i < options.size(); i++) {
            res[i] = String.valueOf(options.get(i));
        }
        return res;
    }
}
