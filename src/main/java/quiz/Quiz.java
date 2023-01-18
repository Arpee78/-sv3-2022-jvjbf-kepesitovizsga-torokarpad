package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public int calculateSumPoints(List<String> answers){
        int sum = 0;
        for (int i = 0; i < answers.size(); i++) {
            sum += questions.get(i).calculatePoints(answers.get(i));
        }
        return sum;
    }

    public Map<Level,Integer> groupByLevel(){
        Map<Level,Integer> result = new HashMap<>();
        for (Question actual :  questions) {
            Level actualLeveL = actual.getLevel();
            if (!result.containsKey(actualLeveL)){
                result.put(actualLeveL, 0);
            }
            result.put(actualLeveL, result.get(actualLeveL)+1);
        }
        return result;
    }
}
