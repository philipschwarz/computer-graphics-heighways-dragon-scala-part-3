package dragon.functionalcore

import dragon.functionalcore.translate

import scala.annotation.tailrec

type DragonPath = List[Point]

object DragonPath:

  def apply(start: Point, shape: DragonShape, length: Int): DragonPath =
    shape.foldLeft(List(start))((path, direction) =>
      path.head.translate(direction, length) :: path
    )

extension (path: DragonPath)
  def lines: List[Line] =
    if path.length < 2 then Nil
    else path.zip(path.tail)