package com.hhplus.course.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

import static lombok.AccessLevel.*;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class UserId implements Serializable {
    @Column(name = "users_id")
    String id;

    public static UserId of(String id) {
        return new UserId(id);}

}
