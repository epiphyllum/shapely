package object shapely {
  type ::[H, T <: HList] = HCons[H, T]

  type HNil = HNil0.type
  val HNil = HNil0

  implicit class HListSyntax[L <: HList](val self: L) extends AnyVal {

    def ::[H](head: H): H :: L = HCons(head, self)

    def remove[A](implicit R: Remover[A, L]): R.Out =
      R(self)
  }
}

