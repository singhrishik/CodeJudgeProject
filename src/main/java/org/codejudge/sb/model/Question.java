package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class Question {

    private String name;

    private String options;

    private int correctOption;

    private int quizId;

    private int points;

    @Column(unique = true)
    private int id;

    public Question(@JsonProperty("id") int id,
                    @JsonProperty("name") String name,
                    @JsonProperty("options") String options,
                    @JsonProperty("correct_option") int correctOption,
                    @JsonProperty("quiz") int quizId,
                    @JsonProperty("points") int points) {
        this.id = id;
        this.name = name;
        this.options = options;
        this.correctOption = correctOption;
        this.quizId = quizId;
        this.points = points;

    }

    public Question() {

    }

    public String getName() {
        return name;
    }

    public String getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public int getQuizId() {
        return quizId;
    }

    public int getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }
}


