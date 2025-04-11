// ============================
// File: Main.scala
// ============================
package lamportclock

import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object Main extends App {
  val numProcesses = args.headOption.map(_.toInt).getOrElse(3)

  val system = ActorSystem(Behaviors.setup[Nothing] { context =>
    val processes = (1 to numProcesses).map { i =>
      context.spawn(Process(s"P$i", null), s"P$i") // null placeholder for now
    }

    // update each process with all peers
    processes.foreach { p =>
      context.system ! Process.Start // or send from controller
    }

    Behaviors.empty
  }, "LamportMutex")
}
