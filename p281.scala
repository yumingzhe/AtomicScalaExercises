import java.util.logging._

// 1.
trait Logging {
  val log = Logger.getLogger(".")
  log.setUseParentHandlers(false)
  log.addHandler(new FileHandler("AtomicLog.txt"))
  log.addHandler(new FileHandler("AtomicLogDuplicate.txt"))
  log.addHandler(new ConsoleHandler)
  log.addHandler(new ConsoleHandler)
  log.setLevel(Level.ALL)
  log.getHandlers.foreach(_.setLevel(Level.ALL))

  def error(msg: String) = log.severe(msg)

  def warn(msg: String) = log.warning(msg)

  def info(msg: String) = log.info(msg)

  def debug(msg: String) = log.fine(msg)

  def trace(msg: String) = log.finer(msg)
}

class LoggingTest extends Logging {
  info("Constructing a LoggingTest")

  def f = {
    trace("entering f")
    // ...
    trace("leaving f")
  }

  def g(i: Int) = {
    debug(s"inside g with i: $i")
    if (i < 0)
      error("i less than 0")
    if (i > 100)
      warn(s"i getting high: $i")
  }
}

val lt = new LoggingTest
lt.f
lt.g(0)
lt.g(-1)
lt.g(101)


// 2.
trait Logging2 {
  val log = Logger.getLogger(".")
  log.setUseParentHandlers(false)
  log.setLevel(Level.ALL)

  def addHandlers(levels: Level*) =
    for (level <- levels) {
      val fh = new FileHandler("AtomicLog-" + level.getName + ".txt")
      val ch = new ConsoleHandler
      fh.setLevel(level)
      ch.setLevel(level)
      log.addHandler(fh)
      log.addHandler(ch)
    }

  addHandlers(Level.ALL, Level.SEVERE, Level.WARNING,
    Level.INFO, Level.CONFIG, Level.FINE, Level.FINER)

  def error(msg: String) = log.severe(msg)

  def warn(msg: String) = log.warning(msg)

  def info(msg: String) = log.info(msg)

  def debug(msg: String) = log.fine(msg)

  def trace(msg: String) = log.finer(msg)
}

class LoggingTest2 extends Logging2 {
  info("Constructing a LoggingTest")

  def f = {
    trace("entering f")
    // ...
    trace("leaving f")
  }

  def g(i: Int) = {
    debug(s"inside g with i: $i")
    if (i < 0)
      error("i less than 0")
    if (i > 100)
      warn(s"i getting high: $i")
  }
}

val lt2 = new LoggingTest
lt2.f
lt2.g(0)
lt2.g(-1)
lt2.g(101)

// 3.
trait Logging3 {
  val log = Logger.getLogger(".")
  log.setUseParentHandlers(false)
  log.setLevel(Level.ALL)

  def addHandlers(levels: Level*) =
    for (level <- levels) {
      val fh = new FileHandler("AtomicLog-" + level.getName + ".txt")
      val ch = new ConsoleHandler
      fh.setLevel(level)
      ch.setLevel(level)
      log.addHandler(fh)
      log.addHandler(ch)
    }

  def error(msg: String) = log.severe(msg)

  def warn(msg: String) = log.warning(msg)

  def info(msg: String) = log.info(msg)

  def debug(msg: String) = log.fine(msg)

  def trace(msg: String) = log.finer(msg)
}

object LoggingTest extends App with Logging3 {
  def f = {
    trace("entering f")
    // ...
    trace("leaving f")
  }

  def g(i: Int) = {
    debug(s"inside g with i: $i")
    if (i < 0)
      error("i less than 0")
    if (i > 100)
      warn(s"i getting high: $i")
  }

  def argcvt(arg: String) =
    arg match {
      case "ALL" => Level.ALL
      case "SEVERE" => Level.SEVERE
      case "WARNING" => Level.WARNING
      case "INFO" => Level.INFO
      case "CONFIG" => Level.CONFIG
      case "FINE" => Level.FINE
      case "FINER" => Level.FINER
      case _ => throw new IllegalArgumentException(arg + " not an option")
    }

  for (arg <- args) {
    println("Logging level: " + argcvt(arg))
    addHandlers(argcvt(arg))
  }
  f
  g(0)
  g(-1)
  g(101)
}
