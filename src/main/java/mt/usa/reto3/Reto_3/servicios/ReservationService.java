/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.servicios;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Reservation;
import mt.usa.reto3.Reto_3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation>getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation>getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()== null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> evt=reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> g=reservationRepository.getReservation(reservation.getIdReservation());
            if(!g.isEmpty()){
                if(reservation.getStarDate()!=null){
                    g.get().setStarDate(reservation.getStarDate());
                }
            if(reservation.getDevolutionDate()!=null){
                g.get().setDevolutionDate(reservation.getDevolutionDate());
            }
            if(reservation.getStatus()!=null){
                g.get().setStatus(reservation.getStatus());
            }
            return reservationRepository.save(g.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    public boolean deleteReservation(int idReservation){
        Boolean d = getReservation(idReservation).map(reservation->{
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
