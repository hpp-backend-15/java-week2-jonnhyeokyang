package com.hhplus.course.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import static lombok.AccessLevel.*;

@Embeddable
@NoArgsConstructor(access = PROTECTED, force = true)
public class UserId {
    private final Long value;

    public UserId(Long value) {
        this.value = value;
    }

}
