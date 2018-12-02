package org.juniorcodebreakers.model.rental;

import org.juniorcodebreakers.model.station.BikeStation;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "rent")
public class RentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRent;
    private Long idUser;
    private Long idBike;
    private BikeStation startStation;
    private BikeStation endStation;
    private LocalTime startTime;
    private LocalTime endTime;

    public RentDetails(Long idUser, Long idBike, BikeStation startStation, BikeStation endStation, LocalTime startTime, LocalTime endTime) {
        this.idUser = idUser;
        this.idBike = idBike;
        this.startStation = startStation;
        this.endStation = endStation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public RentDetails() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBike() {
        return idBike;
    }

    public void setIdBike(Long idBike) {
        this.idBike = idBike;
    }

    public BikeStation getStartStation() {
        return startStation;
    }

    public void setStartStation(BikeStation startStation) {
        this.startStation = startStation;
    }

    public BikeStation getEndStation() {
        return endStation;
    }

    public void setEndStation(BikeStation endStation) {
        this.endStation = endStation;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
