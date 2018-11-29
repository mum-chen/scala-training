object TestListBase {
  def main(args: Array[String]) = {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    val diag3 = (1 :: (0 :: (0 :: Nil))) ::
                (0 :: (1 :: (0 :: Nil))) ::
                (0 :: (0 :: (1 :: Nil))) :: Nil
    val empty = Nil

    val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
    val nums2 = 1 :: 2 :: 3 :: 4 :: Nil
    assert(nums == nums2)
    assert(nums.head == 1)
    assert(nums.tail.head == 2)
    assert(nums.last == 4)
    assert(nums.init.last == 3)
    assert(nums.isEmpty == false)

    val x :: xs = nums2
    assert(x == 1)
    assert(xs.head == 2)

    println("=== map ===")
    assert((List(1, 2, 3) map (_ + 1)) == List(2, 3, 4))
    val words = List("the", "quick", "brown", "fox")
    println(words map (_.toList))
    println(words flatMap (_.toList))

    println("=== filter ===")
    println(words filter (_.length == 3))
    println(words partition (_.length == 3))
    println(words find (_.length == 3))
    println(words takeWhile (_.length == 3))
    println(words dropWhile (_.length == 3))

    println("=== check ===")
    println(words forall (_.length >= 3))
    println(words exists (_.length < 3))

    println("=== fold ===")
    /* foldLeft /:, foldRight :\ */
    def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)
    println(sum(List.range(1, 5)))
    println(("" /: words) (_ + " " + _))

    def reverseLeft[T](xs : List[T]) = (List[T]() /: xs) {(ys, y) => y :: ys}

    println("=== sortWith ===")
    println(List(1, -3, 4, 2, 6) sortWith (_ < _))

    println("=== function with List ===")
    println(List.apply(1, 2, 3))
    println(List.range(5, 9))
    println(List.fill(10)(0))
    println(List.tabulate(5)(n => n * n))
    println(List.concat(List(1, 2, 3), List(4, 9, 7)))

    /* The `5` in the second List will be dropped */
    println((List(10, 20), List(3, 4, 5)).zipped.map(_ * _))
  }
}
