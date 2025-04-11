// ============================
// File: Clock.scala
// ============================
package lamportclock

class Clock(var time: Int = 0) {
  def increment(): Int = { time += 1; time }
  def update(received: Int): Int = { time = math.max(time, received) + 1; time }
  def get: Int = time
}