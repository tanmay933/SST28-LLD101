# BookMyShow – Low Level Design (LLD)

This is a simplified backend design of a movie ticket booking system. The focus is on clean structure, separation of concerns, and handling core problems like seat booking and extensibility.

## Features

* List movies by city
* List theatres by city
* View shows for a movie
* View seats for a show
* Book and cancel tickets
* Multiple seat types
* Multiple payment modes
* Prevent double booking


## Design Overview

### Model Layer

Core entities: Movie, Theatre, Screen, Seat, Show, ShowSeat, Booking, User, Payment.

Key abstraction:

* Seat is static (layout)
* ShowSeat is dynamic (price, availability per show)


### Service Layer

Contains business logic:

* BookingService handles booking and cancellation
* SeatAllocationService prevents double booking
* PaymentService processes payments


### Strategy Pattern

Used for extensibility:

* PricingStrategy → default and surge pricing
* PaymentStrategy → card, UPI, etc.


### Repository Layer

In-memory storage using maps/lists. Keeps data access separate from logic.


### Controller Layer

Acts as API layer to connect user actions with services.


## Booking Flow

1. User selects seats
2. Seats are locked
3. Price is calculated
4. Payment is processed
5. Booking confirmed or rolled back


## Limitations

* No database (in-memory only)
* No seat lock timeout
* Basic repository design
* Simplified payment handling


## Class Diagram

```
User
 └── id, name

Movie
 └── id, name, duration

Theatre
 └── id, name, city
 └── List<Screen>

Screen
 └── id, name
 └── List<Seat>

Seat
 └── id, row, number, type

Show
 └── id, Movie, Screen, startTime
 └── List<ShowSeat>

ShowSeat
 └── id, Seat, price, isBooked

Booking
 └── id, User, Show
 └── List<ShowSeat>
 └── status

Payment
 └── id, amount, mode, status


BookingService
 ├── SeatAllocationService
 ├── PaymentService
 └── PricingStrategy

SeatAllocationService
 └── lockSeats(), releaseSeats()

PaymentService
 └── processPayment()

PricingStrategy (interface)
 ├── DefaultPricingStrategy
 └── SurgePricingStrategy

PaymentStrategy (interface)
 ├── CreditCardPayment
 ├── DebitCardPayment
 └── UpiPayment
```