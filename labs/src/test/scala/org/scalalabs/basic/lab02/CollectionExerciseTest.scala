package org.scalalabs.basic.lab02

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import java.lang.{ IllegalArgumentException => IAE }
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import ListManipulationExercise02.{ Person => _ }
import CollectionExercise02.Person
/**
 * This Lab contains exercises where the usage of
 * higher order collection methods can be rehearsed.
 */
@RunWith(classOf[JUnitRunner])
class CollectionExerciseTest extends Specification {

  "CollectionExercise02:" should {
    "group a list of adults by age group. Each group is sorted by name" in {
      val jack = new Person(14, "Jack")
      val duke = new Person(32, "Duke")
      val jeniffer = new Person(34, "Jeniffer")
      val erik = new Person(24, "Erik")
      val susy = new Person(40, "Susy")

      val result = CollectionExercise02.groupAdultsPerAgeGroup(Seq(jack, jeniffer, duke, erik, susy))
      Map(20 -> Seq(erik), 30 -> Seq(duke, jeniffer), 40 -> Seq(susy)) ==== result
    }
  }

  "CollectionExercise03" should {
    "check that each subsequent value in the sequence increases" in {
      CollectionExercise03.checkValuesIncrease(Seq(1, 2, 3)) ==== true
      CollectionExercise03.checkValuesIncrease(Seq(1)) ==== true
      CollectionExercise03.checkValuesIncrease(Seq(1, 2, 100)) ==== true
      CollectionExercise03.checkValuesIncrease(Seq(1, 2, 1)) ==== false
    }
  }

  "CollectionExercise04:" should {
    "calculate the length of the longest word in a list of sentences" in {
      val l1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque pharetra lorem ut sem feugiat tristique. "
      val l2 = "Etiam id magna ut libero ullamcorperano scelerisque. "

      val result = CollectionExercise04.calcLengthLongestWord(l1, l2)
      "ullamcorperano".length() === result
    }
  }

  "CollectionExercise05" should {
    "use foldLeft for common higher order functions" in {
      val input = Seq(1, 2, 3)
      input.filter(_ % 2 == 0) ==== CollectionExercise05.filterWithFoldLeft(input)
      input.groupBy(_ % 2 == 0) ==== CollectionExercise05.groupByWithFoldLeft(input)
    }
  }

}
