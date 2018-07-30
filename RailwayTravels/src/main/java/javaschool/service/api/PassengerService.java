package javaschool.service.api;

import java.util.List;
import javaschool.controller.dtoentity.PassengerWithoutTickets;
import javaschool.entity.Passenger;

public interface PassengerService {
    /**
     * Finds all passengers and convert them to PassengerWithoutTickets.class
     *
     * @return List with all passengers converted to PassengerWithoutTickets.class
     */
    List<PassengerWithoutTickets> findAllPassengers();

    /**
     * Saves new passenger
     *
     * @param passenger Passenger to be saved
     */
    void save(Passenger passenger);

    /**
     * Finds passenger with specified id
     *
     * @param id Passenger's id
     * @return Passenger with specified id
     */
    Passenger findById(Integer id);

    /**
     * Make user buy ticket for specified departure and seat. User this method instead of buyTicketTransactional method.
     *
     * @param username    User's username
     * @param departureId Departure's id
     * @param coachNumber Number of coach with specified seat
     * @param seatNumber  Number of seat in specified coach
     */
    void buyTicket(String username, Integer departureId, Integer coachNumber, Integer seatNumber);

    /**
     * Make user buy ticket for specified departure and seat. It does not throw custom exception.
     * Instead of it method can throw DataIntegrityViolationException.class. It's recommended to use buyTicket method
     *
     * @param username    User's username
     * @param departureId Departure's id
     * @param coachNumber Number of coach with specified seat
     * @param seatNumber  Number of seat in specified coach
     */
    void buyTicketTransactional(String username, Integer departureId, Integer coachNumber, Integer seatNumber);

    /**
     * Finds all passengers registered on specified departure
     * @param departureId   Departure's id
     * @return  List of passengers registered on specified departure and converted to PassengerWithoutTickets.class
     */
    List<PassengerWithoutTickets> findAllPassengersByDepartureId(Integer departureId);
}