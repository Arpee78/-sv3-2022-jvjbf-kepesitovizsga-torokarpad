package quiz;

public class OneWordQuestion implements Question {

    private String question;
    private String correctAnswer;
    private Level level;

    public OneWordQuestion(String question, String correctAnswer, Level level) {
        this.question = question;
        this.correctAnswer = correctAnswer;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public int calculatePoints(String... answer) {
        if (answer.length>1){
            throw new IllegalArgumentException("Only one answer acceptable!");
        }
        if (correctAnswer.equals(answer[0])){
            return level.getPoint();
        }
        return 0;
    }
}
