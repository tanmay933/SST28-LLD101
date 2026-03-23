## Class Diagram

ParkingLot
 ├── List<ParkingFloor>

ParkingFloor
 ├── List<ParkingSlot>

ParkingSlot
 ├── slotId
 ├── type
 ├── status
 ├── distanceFromGate

Vehicle
 ├── vehicleNumber
 ├── type

Ticket
 ├── vehicle  -> Vehicle
 ├── slot     -> ParkingSlot
 ├── entryTime

ParkingService
 ├── park()
 ├── exit()
 ├── status()

 ## Design Approach

- Used object-oriented design with clear separation of concerns.
- ParkingService handles core operations like park, exit, and status.
- SlotAllocationStrategy is used to assign nearest available compatible slot.
- Compatibility rules:
  - BIKE → SMALL, MEDIUM, LARGE
  - CAR → MEDIUM, LARGE
  - BUS → LARGE
- Billing is calculated based on slot type, not vehicle type.
- Ticket stores vehicle, slot, and entry time.
- Repository classes manage in-memory storage.