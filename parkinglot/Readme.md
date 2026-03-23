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