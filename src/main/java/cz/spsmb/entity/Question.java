package cz.spsmb.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "question")
    private String question;

    // TODO udělat difficulty
    @Column(name = "difficulty")
    private int difficulty;

    @OneToOne
    @JoinColumn(name = "right_option_ID")
    private OptionEntity rightOption;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    private List<OptionEntity> options;

    public OptionEntity getRightOption() {
        return rightOption;
    }

    public void setOptions(List<OptionEntity> options) {
        this.options = options;
    }

    public List<OptionEntity> getOptions() {
        return options;
    }

    public Question() {
    }

    public Question(long id, String uuid, String question, int difficulty, OptionEntity rightOption, List<OptionEntity> options) {
        this.id = id;
        this.uuid = uuid;
        this.question = question;
        this.difficulty = difficulty;
        this.rightOption = rightOption;
        this.options = options;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setRightOption(OptionEntity rightOption) {
        this.rightOption = rightOption;
    }
}
