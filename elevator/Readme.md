# Elevator System - Low Level Design

## Overview

This is a clean, interview-oriented design of an elevator system. The focus is on clarity and separation of responsibilities rather than advanced optimizations.

At a high level:

* Floors generate requests
* The system forwards requests to a controller
* The controller decides which elevator to use and how to assign the request
* Elevators execute requests sequentially

---

## Class Diagram

ElevatorSystem --> Elevator
ElevatorSystem --> ElevatorController

ElevatorController --> ElevatorSelectionStrategy
ElevatorController --> SchedulingStrategy

Elevator --> Request
Request <|-- ExternalRequest
Request <|-- InternalRequest

Floor --> ExternalRequest
ElevatorPanel --> InternalRequest
ElevatorPanel --> Elevator

Elevator --> Direction
Elevator --> ElevatorState
```

---

## How the System Works

1. A user presses a button on a floor
2. A request is created (ExternalRequest)
3. ElevatorSystem forwards it to the ElevatorController
4. Controller:

   * selects an elevator using the selection strategy
   * assigns the request using the scheduling strategy
5. The selected elevator stores the request
6. When the elevator runs, it processes requests one by one

---

## Design Choices

* **Controller Layer**: Keeps decision-making separate from the Elevator and System
* **Strategy Pattern**: Makes selection and scheduling interchangeable without changing core logic
* **Request Abstraction**: Separates external (floor) and internal (panel) interactions
* **Simple Processing Model**: Requests are handled sequentially to keep behavior predictable

---

## Scope and Assumptions

* Single-threaded execution
* No advanced scheduling (priority, batching, etc.)
* No real-time constraints

These are intentional to keep the design focused and easy to reason about.

---

## Summary

This design balances simplicity and structure. It is easy to explain, easy to extend, and aligns well with common LLD interview expectations.
