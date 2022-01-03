package com.superchat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "conversations")
@Data
@NoArgsConstructor
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private User user;

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Contact contact;

    @Column
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp startDate;

    @Column
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp endDate;

    @OneToMany(mappedBy = "conversation")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OrderBy("timestamp")
    private Collection<Message> messages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversation that = (Conversation) o;
        return Objects.equals(user, that.user) && Objects.equals(contact, that.contact) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, contact, startDate);
    }
}