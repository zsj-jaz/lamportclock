// ============================
// File: Process.scala
// ============================
package lamportclock

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object Process {
  // Message types only relevant to Process
  sealed trait Message
  final case class Request(ts: Int, from: ActorRef[Message]) extends Message
  final case class Ack(ts: Int, from: ActorRef[Message]) extends Message
  final case class Release(ts: Int, from: ActorRef[Message]) extends Message
  case object Start extends Message
  case object Shutdown extends Message

  def apply(name: String, all: Seq[ActorRef[Message]]): Behavior[Message] =
    Behaviors.setup { context =>
      val clock = new Clock()
      var queue = List.empty[(Int, ActorRef[Message])]
      var acks = Set.empty[ActorRef[Message]]
      var peers = all.filterNot(_ == context.self)
      var holding = false
      var shuttingDown = false

      // TODO: define behavior

      Behaviors.receiveMessage {
        case Start =>
          // TODO: Start requesting the resource
          Behaviors.same

        case Request(ts, from) =>
          // TODO: Handle incoming request
          Behaviors.same

        case Ack(ts, from) =>
          // TODO: Handle acknowledgment
          Behaviors.same

        case Release(ts, from) =>
          // TODO: Handle release
          Behaviors.same

        case Shutdown =>
          // TODO: Clean shutdown
          Behaviors.same
      }
    }
}
