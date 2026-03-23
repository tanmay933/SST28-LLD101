Game
 ├── board        -> Board
 ├── dice         -> Dice
 ├── players      -> Queue<Player>
 ├── start()

Board
 ├── size
 ├── jumps        -> Map<Integer, Jump>
 ├── resolveJump()

Player
 ├── name
 ├── position

Dice
 ├── roll()

Jump
 ├── end

Snake -> Jump
Ladder -> Jump