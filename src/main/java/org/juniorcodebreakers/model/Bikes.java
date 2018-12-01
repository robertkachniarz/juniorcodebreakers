package org.juniorcodebreakers.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bikes {
    private final List<Bike> bikes;
    private final Integer quantityOfBikes;

    @JsonCreator
    public Bikes(@JsonProperty("bikes") List<Bike> bikes,@JsonProperty("quantityOfBikes") Integer quantityOfBikes) {
        this.bikes = bikes;
        this.quantityOfBikes = quantityOfBikes;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public Integer getQuantityOfBikes() {
        return quantityOfBikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bikes bikes1 = (Bikes) o;
        return Objects.equals(bikes, bikes1.bikes) &&
                Objects.equals(quantityOfBikes, bikes1.quantityOfBikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikes, quantityOfBikes);
    }
}
