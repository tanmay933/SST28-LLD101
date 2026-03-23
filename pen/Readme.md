Pen
 ├── state        -> PenState
 ├── refill       -> Refill
 ├── nib          -> Nib
 ├── start()
 ├── write()
 ├── close()
 ├── refill()

Refill
 ├── ink          -> Ink
 ├── level
 ├── hasInk()
 ├── consume()
 ├── refill()

Nib
 ├── type

Ink (interface)
 ├── getColor()

BlueInk
BlackInk
RedInk

PenState
 ├── OPEN
 ├── CLOSED