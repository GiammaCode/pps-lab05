package polyglot.a01a

import polyglot.a01a.Logics
import polyglot.a01a.Logics.Result
import util.Sequences.*
import Sequence.*

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  private val FAILURE: Int = 5

  private val random: Random = new Random();
  private var boatSize: Int = boat
  private var boatRow: Int = random.nextInt(size)
  private var boatLeftCol: Int = random.nextInt(size - boat + 1)
  private var failures: Int = 0
  private var hit: Sequence[(Int, Int)]  = Nil()
  println(s"x = " + boatLeftCol + ", y = " + boatRow)

  def hit(row: Int, col: Int) =
    val isBoatHit = row == boatRow && col >= boatLeftCol && col < boatLeftCol + boatSize

    isBoatHit match
      case true => ???
        //hit = hit.concat(Cons((row, col), Nil()))
        //if hit.size == boatSize then Result.WON else Result.HIT
      case false =>
        failures += 1
        if failures == FAILURE then Result.LOST else Result.HIT
