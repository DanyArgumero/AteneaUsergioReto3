package com.example.reto3.Repository;

import com.example.reto3.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.reto3.Repository.CRUDRepository.ReservationCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository ReservationCrudRepository;

    public List<Reservation> findAllReservations() {
        return (List<Reservation>) ReservationCrudRepository.findAll();
    }

    public Optional<Reservation> findById(int id){
        return ReservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation Reservation){
        return ReservationCrudRepository.save(Reservation);
    }

    public void Delete(Reservation reservation){
        ReservationCrudRepository.delete(reservation);
    }
}
