package hexlet.code.games;

import hexlet.code.Game;
import java.util.Random;

public class Progression implements Game {
    private static final int MAX_START = 50;
    private static final int MAX_STEP = 10;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final Random RANDOM = new Random();

    public String getDescription() {
        return "What number is missing in the progression?";
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + step * i;
        }
        return progression;
    }

    public String[] generateRound() {
        var start = RANDOM.nextInt(MAX_START);
        var step = RANDOM.nextInt(MAX_STEP) + 1;
        var length = RANDOM.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        var hiddenIndex = RANDOM.nextInt(length);

        var progression = generateProgression(start, step, length);
        var question = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                question.append(" ");
            }
            question.append(i == hiddenIndex ? ".." : String.valueOf(progression[i]));
        }
        return new String[] {question.toString(), String.valueOf(progression[hiddenIndex])};
    }
}
