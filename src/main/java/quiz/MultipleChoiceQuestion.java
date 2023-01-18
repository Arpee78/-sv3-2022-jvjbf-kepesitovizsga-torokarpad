package quiz;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion implements Question{

    private String question;
    private List<String> options;
    private List<String> correctAnswers;
    private Level level;

    public MultipleChoiceQuestion(String question, List<String> options, List<String> correctAnswers, Level level) {
        validateParameters(options, correctAnswers);
        this.question = question;
        this.options = options;
        this.correctAnswers = correctAnswers;
        this.level = level;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    public List<String> getOptions() {
        return new ArrayList<>(options);
    }

    public List<String> getCorrectAnswers() {
        return new ArrayList<>(correctAnswers);
    }

    @Override
    public int calculatePoints(String... answer) {
        for (String actual : answer) {
            if (!options.contains(actual)) {
                throw new IllegalArgumentException("Answers are not in options!");
            }
            if (!correctAnswers.contains(actual)){
                return 0;
            }
        }

        return level.getPoint();
    }

    private void validateParameters(List<String> options, List<String> correctAnswers) {
        if (options.size() < 2) {
            throw new IllegalArgumentException("Answers size must be at least 2!");
        }
        for (String actual : correctAnswers) {
            if (!options.contains(actual)) {
                throw new CorrectAnswersMismatchException("Answers must contain all correct answers!");
            }
        }
    }

}
