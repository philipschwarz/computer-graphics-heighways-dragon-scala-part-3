package dragon.functionalcore

enum Direction:
  case North, East, South, West

  def inverted: Direction = this match
    case Direction.North => Direction.South
    case Direction.East  => Direction.West
    case Direction.South => Direction.North
    case Direction.West  => Direction.East

  def rotated: Direction = this match
    case Direction.North => Direction.East
    case Direction.East  => Direction.South
    case Direction.South => Direction.West
    case Direction.West  => Direction.North
