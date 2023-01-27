package cz.spsmb.dto.in;

import java.util.Set;

public class QuestionDto {
    private String question;
    private String answer;
    private Set<String> options;

    public QuestionDto() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<String> getOptions() {
        return options;
    }

    public void setOptions(Set<String> options) {
        this.options = options;
    }
}
