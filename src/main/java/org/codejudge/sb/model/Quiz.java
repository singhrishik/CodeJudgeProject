package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;

public class Quiz {

    private String name;

    private String description;

    @Column(unique=true)
    private int id;

    public Quiz() {

    }

    public int getId() {
        return id;
    }


    public Quiz(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
