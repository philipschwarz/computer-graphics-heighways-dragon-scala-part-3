package dragon.functionalcore

import scala.annotation.tailrec

type DragonShape = List[Direction]

object DragonShape:

  def apply(startDirection: Direction, age: Int): DragonShape =
    DragonShape(startDirection).grow(age)

  private def apply(startDirection: Direction): DragonShape =
    List(startDirection)

extension (shape: DragonShape)

  @tailrec
  private def grow(age: Int): DragonShape =
    if age == 0 then shape
    else shape.plusRotatedCopy.grow(age - 1)

  private def plusRotatedCopy: DragonShape =
    shape.foldLeft(shape)((directions, direction) => direction.inverted.rotated :: directions)

  def path(startPoint: Point, length: Int): DragonPath =
    DragonPath(startPoint, shape, length)