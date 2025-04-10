package polyglot.a05b

import polyglot.a05b.Logics
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:
  private val random: Random = new Random()
  private val initial: (Int, Int) = (random.nextInt(size - 2) + 1, random.nextInt(size - 2) + 1)
  private var tickCount: Int = 0

  override def tick(): Unit = tickCount += 1

  override def isOver: Boolean =
    val (ix, iy) = initial
    iy - tickCount < 0 || iy + tickCount >= size ||
      ix - tickCount < 0 || ix + tickCount >= size

  override def hasElement(x: Int, y: Int): Boolean =
    val (ix, iy) = initial

    (x == ix && withinDistance(y, iy)) ||
    (y == iy && withinDistance(x, ix)) ||
    (x - y == ix - iy && withinDistance(x, ix)) ||
    (x + y == ix + iy && withinDistance(y, iy))
  private def withinDistance(a: Int, b: Int): Boolean =
    Math.abs(a - b) <= tickCount
