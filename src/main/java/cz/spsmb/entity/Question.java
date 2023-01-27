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
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "question")
    private String question;

    @OneToOne
    @JoinColumn(name = "right_option_ID")
    private OptionEntity rightOption;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<OptionEntity> options = new java.util.ArrayList<>();

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
