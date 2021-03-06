package org.juniorcodebreakers.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Status status;

    public Bike() {
    }

    public Bike(Status status) {
        this.status = status;
    }

    public Bike(Long id,Status status) {
        this.status = status;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return id == bike.id &&
                status == bike.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
