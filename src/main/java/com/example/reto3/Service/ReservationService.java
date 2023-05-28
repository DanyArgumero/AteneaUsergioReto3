package com.example.reto3.Service;


import com.example.reto3.Model.Reservation;
import com.example.reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository ReservationRepository;

    public List<Reservation> getAll() {
        return ReservationRepository.findAllReservations();
    }

    public Optional<Reservation> getById(int id) {
        return ReservationRepository.findById(id);
    }

    public Reservation save(Reservation Reservation) {
        if (Reservation.getIdReservation() == null) {
            return ReservationRepository.save(Reservation);
        } else {
            Optional<Reservation> FindReservation = getById(Reservation.getIdReservation());
            if (FindReservation.isEmpty())
                return ReservationRepository.save(Reservation);
            else
                return Reservation;
        }
    }

    public Reservation update(Reservation Reservation) {
        if(Reservation.getIdReservation() != null){
            Optional<Reservation> FindReservation = getById(Reservation.getIdReservation());
            if (FindReservation.isPresent()) {
                if (Reservation.getStartDate() != null) {
                    FindReservation.get().setStartDate(Reservation.getStartDate());
                }
                if (Reservation.getDevolutionDate() != null) {
                    FindReservation.get().setDevolutionDate(Reservation.getDevolutionDate());
                }
                if (Reservation.getStatus() != null) {
                    FindReservation.get().setStatus(Reservation.getStatus());
                }
                return ReservationRepository.save(FindReservation.get());
            }else {
                return Reservation;
            }
        }else{
            return Reservation;
        }
    }

    public boolean deleteReservationById(int id){
        Boolean respuesta = getById(id).map(Reservation -> {
            ReservationRepository.Delete(Reservation);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
