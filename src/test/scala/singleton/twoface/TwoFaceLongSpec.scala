package singleton.twoface

import org.scalacheck.Properties
import shapeless.test.illTyped
import singleton.TestUtils._

class TwoFaceLongSpec extends Properties("TwoFace.Long") {
  property("Implicit Creation[]") = {
    val a = implicitly[TwoFace.Long[2L]]
    a.getValue == 2L && a.isLiteral
  }
  property("Safe Creation[]") = {
    val a = TwoFace.Long[2L]
    a.getValue == 2L && a.isLiteral
  }
  property("Safe Creation()") = {
    val a = TwoFace.Long(2L)
    a.getValue == 2L && a.isLiteral
  }
  property("Unsafe Creation()") = {
    val a = TwoFace.Long(us(2L))
    a.getValue == 2L && !a.isLiteral
  }

  property("Safe Long + Safe Char") = verifyTF(TwoFace.Long(2L) + TwoFace.Char('\u0001'), 3L)
  property("Safe Long + Unsafe Char") = verifyTF(TwoFace.Long(2L) + TwoFace.Char(us('\u0001')), us(3L))
  property("Unsafe Long + Safe Char") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Char('\u0001'), us(3L))
  property("Unsafe Long + Unsafe Char") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Char(us('\u0001')), us(3L))
  property("Safe Long + Safe Int") = verifyTF(TwoFace.Long(2L) + TwoFace.Int(1), 3L)
  property("Safe Long + Unsafe Int") = verifyTF(TwoFace.Long(2L) + TwoFace.Int(us(1)), us(3L))
  property("Unsafe Long + Safe Int") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Int(1), us(3L))
  property("Unsafe Long + Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Int(us(1)), us(3L))
  property("Safe Long + Safe Long") = verifyTF(TwoFace.Long(2L) + TwoFace.Long(1L), 3L)
  property("Safe Long + Unsafe Long") = verifyTF(TwoFace.Long(2L) + TwoFace.Long(us(1L)), us(3L))
  property("Unsafe Long + Safe Long") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Long(1L), us(3L))
  property("Unsafe Long + Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Long(us(1L)), us(3L))
  property("Safe Long + Safe Float") = verifyTF(TwoFace.Long(2L) + TwoFace.Float(1.0f), 3.0f)
  property("Safe Long + Unsafe Float") = verifyTF(TwoFace.Long(2L) + TwoFace.Float(us(1.0f)), us(3.0f))
  property("Unsafe Long + Safe Float") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Float(1.0f), us(3.0f))
  property("Unsafe Long + Unsafe Float") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Float(us(1.0f)), us(3.0f))
  property("Safe Long + Safe Double") = verifyTF(TwoFace.Long(2L) + TwoFace.Double(1.0), 3.0)
  property("Safe Long + Unsafe Double") = verifyTF(TwoFace.Long(2L) + TwoFace.Double(us(1.0)), us(3.0))
  property("Unsafe Long + Safe Double") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Double(1.0), us(3.0))
  property("Unsafe Long + Unsafe Double") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Double(us(1.0)), us(3.0))

  property("Safe Long - Safe Char") = verifyTF(TwoFace.Long(2L) - TwoFace.Char('\u0001'), 1L)
  property("Safe Long - Unsafe Char") = verifyTF(TwoFace.Long(2L) - TwoFace.Char(us('\u0001')), us(1L))
  property("Unsafe Long - Safe Char") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Char('\u0001'), us(1L))
  property("Unsafe Long - Unsafe Char") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Char(us('\u0001')), us(1L))
  property("Safe Long - Safe Int") = verifyTF(TwoFace.Long(2L) - TwoFace.Int(1), 1L)
  property("Safe Long - Unsafe Int") = verifyTF(TwoFace.Long(2L) - TwoFace.Int(us(1)), us(1L))
  property("Unsafe Long - Safe Int") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Int(1), us(1L))
  property("Unsafe Long - Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Int(us(1)), us(1L))
  property("Safe Long - Safe Long") = verifyTF(TwoFace.Long(2L) - TwoFace.Long(1L), 1L)
  property("Safe Long - Unsafe Long") = verifyTF(TwoFace.Long(2L) - TwoFace.Long(us(1L)), us(1L))
  property("Unsafe Long - Safe Long") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Long(1L), us(1L))
  property("Unsafe Long - Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Long(us(1L)), us(1L))
  property("Safe Long - Safe Float") = verifyTF(TwoFace.Long(2L) - TwoFace.Float(1.0f), 1.0f)
  property("Safe Long - Unsafe Float") = verifyTF(TwoFace.Long(2L) - TwoFace.Float(us(1.0f)), us(1.0f))
  property("Unsafe Long - Safe Float") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Float(1.0f), us(1.0f))
  property("Unsafe Long - Unsafe Float") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Float(us(1.0f)), us(1.0f))
  property("Safe Long - Safe Double") = verifyTF(TwoFace.Long(2L) - TwoFace.Double(1.0), 1.0)
  property("Safe Long - Unsafe Double") = verifyTF(TwoFace.Long(2L) - TwoFace.Double(us(1.0)), us(1.0))
  property("Unsafe Long - Safe Double") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Double(1.0), us(1.0))
  property("Unsafe Long - Unsafe Double") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Double(us(1.0)), us(1.0))

  property("Safe Long * Safe Char") = verifyTF(TwoFace.Long(2L) * TwoFace.Char('\u0001'), 2L)
  property("Safe Long * Unsafe Char") = verifyTF(TwoFace.Long(2L) * TwoFace.Char(us('\u0001')), us(2L))
  property("Unsafe Long * Safe Char") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Char('\u0001'), us(2L))
  property("Unsafe Long * Unsafe Char") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Char(us('\u0001')), us(2L))
  property("Safe Long * Safe Int") = verifyTF(TwoFace.Long(2L) * TwoFace.Int(1), 2L)
  property("Safe Long * Unsafe Int") = verifyTF(TwoFace.Long(2L) * TwoFace.Int(us(1)), us(2L))
  property("Unsafe Long * Safe Int") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Int(1), us(2L))
  property("Unsafe Long * Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Int(us(1)), us(2L))
  property("Safe Long * Safe Long") = verifyTF(TwoFace.Long(2L) * TwoFace.Long(1L), 2L)
  property("Safe Long * Unsafe Long") = verifyTF(TwoFace.Long(2L) * TwoFace.Long(us(1L)), us(2L))
  property("Unsafe Long * Safe Long") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Long(1L), us(2L))
  property("Unsafe Long * Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Long(us(1L)), us(2L))
  property("Safe Long * Safe Float") = verifyTF(TwoFace.Long(2L) * TwoFace.Float(1.0f), 2.0f)
  property("Safe Long * Unsafe Float") = verifyTF(TwoFace.Long(2L) * TwoFace.Float(us(1.0f)), us(2.0f))
  property("Unsafe Long * Safe Float") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Float(1.0f), us(2.0f))
  property("Unsafe Long * Unsafe Float") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Float(us(1.0f)), us(2.0f))
  property("Safe Long * Safe Double") = verifyTF(TwoFace.Long(2L) * TwoFace.Double(1.0), 2.0)
  property("Safe Long * Unsafe Double") = verifyTF(TwoFace.Long(2L) * TwoFace.Double(us(1.0)), us(2.0))
  property("Unsafe Long * Safe Double") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Double(1.0), us(2.0))
  property("Unsafe Long * Unsafe Double") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Double(us(1.0)), us(2.0))

  property("Safe Long / Safe Char") = verifyTF(TwoFace.Long(6L) / TwoFace.Char('\u0002'), 3L)
  property("Safe Long / Unsafe Char") = verifyTF(TwoFace.Long(6L) / TwoFace.Char(us('\u0002')), us(3L))
  property("Unsafe Long / Safe Char") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Char('\u0002'), us(3L))
  property("Unsafe Long / Unsafe Char") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Char(us('\u0002')), us(3L))
  property("Safe Long / Safe Int") = verifyTF(TwoFace.Long(6L) / TwoFace.Int(2), 3L)
  property("Safe Long / Unsafe Int") = verifyTF(TwoFace.Long(6L) / TwoFace.Int(us(2)), us(3L))
  property("Unsafe Long / Safe Int") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Int(2), us(3L))
  property("Unsafe Long / Unsafe Int") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Int(us(2)), us(3L))
  property("Safe Long / Safe Long") = verifyTF(TwoFace.Long(6L) / TwoFace.Long(2L), 3L)
  property("Safe Long / Unsafe Long") = verifyTF(TwoFace.Long(6L) / TwoFace.Long(us(2L)), us(3L))
  property("Unsafe Long / Safe Long") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Long(2L), us(3L))
  property("Unsafe Long / Unsafe Long") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Long(us(2L)), us(3L))
  property("Safe Long / Safe Float") = verifyTF(TwoFace.Long(6L) / TwoFace.Float(2.0f), 3.0f)
  property("Safe Long / Unsafe Float") = verifyTF(TwoFace.Long(6L) / TwoFace.Float(us(2.0f)), us(3.0f))
  property("Unsafe Long / Safe Float") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Float(2.0f), us(3.0f))
  property("Unsafe Long / Unsafe Float") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Float(us(2.0f)), us(3.0f))
  property("Safe Long / Safe Double") = verifyTF(TwoFace.Long(6L) / TwoFace.Double(2.0), 3.0)
  property("Safe Long / Unsafe Double") = verifyTF(TwoFace.Long(6L) / TwoFace.Double(us(2.0)), us(3.0))
  property("Unsafe Long / Safe Double") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Double(2.0), us(3.0))
  property("Unsafe Long / Unsafe Double") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Double(us(2.0)), us(3.0))

  property("Safe Long % Safe Char") = verifyTF(TwoFace.Long(7L) % TwoFace.Char('\u0004'), 3L)
  property("Safe Long % Unsafe Char") = verifyTF(TwoFace.Long(7L) % TwoFace.Char(us('\u0004')), us(3L))
  property("Unsafe Long % Safe Char") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Char('\u0004'), us(3L))
  property("Unsafe Long % Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Char(us('\u0004')), us(3L))
  property("Safe Long % Safe Int") = verifyTF(TwoFace.Long(7L) % TwoFace.Int(4), 3L)
  property("Safe Long % Unsafe Int") = verifyTF(TwoFace.Long(7L) % TwoFace.Int(us(4)), us(3L))
  property("Unsafe Long % Safe Int") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Int(4), us(3L))
  property("Unsafe Long % Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Int(us(4)), us(3L))
  property("Safe Long % Safe Long") = verifyTF(TwoFace.Long(7L) % TwoFace.Long(4L), 3L)
  property("Safe Long % Unsafe Long") = verifyTF(TwoFace.Long(7L) % TwoFace.Long(us(4L)), us(3L))
  property("Unsafe Long % Safe Long") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Long(4L), us(3L))
  property("Unsafe Long % Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Long(us(4L)), us(3L))
  property("Safe Long % Safe Float") = verifyTF(TwoFace.Long(7L) % TwoFace.Float(4.0f), 3.0f)
  property("Safe Long % Unsafe Float") = verifyTF(TwoFace.Long(7L) % TwoFace.Float(us(4.0f)), us(3.0f))
  property("Unsafe Long % Safe Float") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Float(4.0f), us(3.0f))
  property("Unsafe Long % Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Float(us(4.0f)), us(3.0f))
  property("Safe Long % Safe Double") = verifyTF(TwoFace.Long(7L) % TwoFace.Double(4.0), 3.0)
  property("Safe Long % Unsafe Double") = verifyTF(TwoFace.Long(7L) % TwoFace.Double(us(4.0)), us(3.0))
  property("Unsafe Long % Safe Double") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Double(4.0), us(3.0))
  property("Unsafe Long % Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Double(us(4.0)), us(3.0))

  property("Safe Long < Safe Char") = verifyTF(TwoFace.Long(7L) < TwoFace.Char('\u0004'), false)
  property("Safe Long < Unsafe Char") = verifyTF(TwoFace.Long(7L) < TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Long < Safe Char") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Char('\u0004'), us(false))
  property("Unsafe Long < Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Char(us('\u0004')), us(false))
  property("Safe Long < Safe Int") = verifyTF(TwoFace.Long(7L) < TwoFace.Int(4), false)
  property("Safe Long < Unsafe Int") = verifyTF(TwoFace.Long(7L) < TwoFace.Int(us(4)), us(false))
  property("Unsafe Long < Safe Int") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Int(4), us(false))
  property("Unsafe Long < Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Int(us(4)), us(false))
  property("Safe Long < Safe Long") = verifyTF(TwoFace.Long(7L) < TwoFace.Long(4L), false)
  property("Safe Long < Unsafe Long") = verifyTF(TwoFace.Long(7L) < TwoFace.Long(us(4L)), us(false))
  property("Unsafe Long < Safe Long") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Long(4L), us(false))
  property("Unsafe Long < Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Long(us(4L)), us(false))
  property("Safe Long < Safe Float") = verifyTF(TwoFace.Long(7L) < TwoFace.Float(4.0f), false)
  property("Safe Long < Unsafe Float") = verifyTF(TwoFace.Long(7L) < TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Long < Safe Float") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Float(4.0f), us(false))
  property("Unsafe Long < Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Float(us(4.0f)), us(false))
  property("Safe Long < Safe Double") = verifyTF(TwoFace.Long(7L) < TwoFace.Double(4.0), false)
  property("Safe Long < Unsafe Double") = verifyTF(TwoFace.Long(7L) < TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Long < Safe Double") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Double(4.0), us(false))
  property("Unsafe Long < Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Double(us(4.0)), us(false))

  property("Safe Long > Safe Char") = verifyTF(TwoFace.Long(7L) > TwoFace.Char('\u0004'), true)
  property("Safe Long > Unsafe Char") = verifyTF(TwoFace.Long(7L) > TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Long > Safe Char") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Char('\u0004'), us(true))
  property("Unsafe Long > Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Char(us('\u0004')), us(true))
  property("Safe Long > Safe Int") = verifyTF(TwoFace.Long(7L) > TwoFace.Int(4), true)
  property("Safe Long > Unsafe Int") = verifyTF(TwoFace.Long(7L) > TwoFace.Int(us(4)), us(true))
  property("Unsafe Long > Safe Int") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Int(4), us(true))
  property("Unsafe Long > Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Int(us(4)), us(true))
  property("Safe Long > Safe Long") = verifyTF(TwoFace.Long(7L) > TwoFace.Long(4L), true)
  property("Safe Long > Unsafe Long") = verifyTF(TwoFace.Long(7L) > TwoFace.Long(us(4L)), us(true))
  property("Unsafe Long > Safe Long") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Long(4L), us(true))
  property("Unsafe Long > Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Long(us(4L)), us(true))
  property("Safe Long > Safe Float") = verifyTF(TwoFace.Long(7L) > TwoFace.Float(4.0f), true)
  property("Safe Long > Unsafe Float") = verifyTF(TwoFace.Long(7L) > TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Long > Safe Float") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Float(4.0f), us(true))
  property("Unsafe Long > Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Float(us(4.0f)), us(true))
  property("Safe Long > Safe Double") = verifyTF(TwoFace.Long(7L) > TwoFace.Double(4.0), true)
  property("Safe Long > Unsafe Double") = verifyTF(TwoFace.Long(7L) > TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Long > Safe Double") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Double(4.0), us(true))
  property("Unsafe Long > Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Double(us(4.0)), us(true))

  property("Safe Long <= Safe Char") = verifyTF(TwoFace.Long(7L) <= TwoFace.Char('\u0004'), false)
  property("Safe Long <= Unsafe Char") = verifyTF(TwoFace.Long(7L) <= TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Long <= Safe Char") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Char('\u0004'), us(false))
  property("Unsafe Long <= Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Char(us('\u0004')), us(false))
  property("Safe Long <= Safe Int") = verifyTF(TwoFace.Long(7L) <= TwoFace.Int(4), false)
  property("Safe Long <= Unsafe Int") = verifyTF(TwoFace.Long(7L) <= TwoFace.Int(us(4)), us(false))
  property("Unsafe Long <= Safe Int") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Int(4), us(false))
  property("Unsafe Long <= Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Int(us(4)), us(false))
  property("Safe Long <= Safe Long") = verifyTF(TwoFace.Long(7L) <= TwoFace.Long(4L), false)
  property("Safe Long <= Unsafe Long") = verifyTF(TwoFace.Long(7L) <= TwoFace.Long(us(4L)), us(false))
  property("Unsafe Long <= Safe Long") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Long(4L), us(false))
  property("Unsafe Long <= Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Long(us(4L)), us(false))
  property("Safe Long <= Safe Float") = verifyTF(TwoFace.Long(7L) <= TwoFace.Float(4.0f), false)
  property("Safe Long <= Unsafe Float") = verifyTF(TwoFace.Long(7L) <= TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Long <= Safe Float") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Float(4.0f), us(false))
  property("Unsafe Long <= Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Float(us(4.0f)), us(false))
  property("Safe Long <= Safe Double") = verifyTF(TwoFace.Long(7L) <= TwoFace.Double(4.0), false)
  property("Safe Long <= Unsafe Double") = verifyTF(TwoFace.Long(7L) <= TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Long <= Safe Double") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Double(4.0), us(false))
  property("Unsafe Long <= Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Double(us(4.0)), us(false))

  property("Safe Long >= Safe Char") = verifyTF(TwoFace.Long(7L) >= TwoFace.Char('\u0004'), true)
  property("Safe Long >= Unsafe Char") = verifyTF(TwoFace.Long(7L) >= TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Long >= Safe Char") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Char('\u0004'), us(true))
  property("Unsafe Long >= Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Char(us('\u0004')), us(true))
  property("Safe Long >= Safe Int") = verifyTF(TwoFace.Long(7L) >= TwoFace.Int(4), true)
  property("Safe Long >= Unsafe Int") = verifyTF(TwoFace.Long(7L) >= TwoFace.Int(us(4)), us(true))
  property("Unsafe Long >= Safe Int") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Int(4), us(true))
  property("Unsafe Long >= Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Int(us(4)), us(true))
  property("Safe Long >= Safe Long") = verifyTF(TwoFace.Long(7L) >= TwoFace.Long(4L), true)
  property("Safe Long >= Unsafe Long") = verifyTF(TwoFace.Long(7L) >= TwoFace.Long(us(4L)), us(true))
  property("Unsafe Long >= Safe Long") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Long(4L), us(true))
  property("Unsafe Long >= Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Long(us(4L)), us(true))
  property("Safe Long >= Safe Float") = verifyTF(TwoFace.Long(7L) >= TwoFace.Float(4.0f), true)
  property("Safe Long >= Unsafe Float") = verifyTF(TwoFace.Long(7L) >= TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Long >= Safe Float") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Float(4.0f), us(true))
  property("Unsafe Long >= Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Float(us(4.0f)), us(true))
  property("Safe Long >= Safe Double") = verifyTF(TwoFace.Long(7L) >= TwoFace.Double(4.0), true)
  property("Safe Long >= Unsafe Double") = verifyTF(TwoFace.Long(7L) >= TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Long >= Safe Double") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Double(4.0), us(true))
  property("Unsafe Long >= Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Double(us(4.0)), us(true))

  property("Safe Long == Safe Char") = verifyTF(TwoFace.Long(7L) == TwoFace.Char('\u0007'), true)
  property("Safe Long == Unsafe Char") = verifyTF(TwoFace.Long(7L) == TwoFace.Char(us('\u0007')), us(true))
  property("Unsafe Long == Safe Char") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Char('\u0007'), us(true))
  property("Unsafe Long == Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Char(us('\u0007')), us(true))
  property("Safe Long == Safe Int") = verifyTF(TwoFace.Long(7L) == TwoFace.Int(7), true)
  property("Safe Long == Unsafe Int") = verifyTF(TwoFace.Long(7L) == TwoFace.Int(us(7)), us(true))
  property("Unsafe Long == Safe Int") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Int(7), us(true))
  property("Unsafe Long == Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Int(us(7)), us(true))
  property("Safe Long == Safe Long") = verifyTF(TwoFace.Long(7L) == TwoFace.Long(7L), true)
  property("Safe Long == Unsafe Long") = verifyTF(TwoFace.Long(7L) == TwoFace.Long(us(7L)), us(true))
  property("Unsafe Long == Safe Long") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Long(7L), us(true))
  property("Unsafe Long == Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Long(us(7L)), us(true))
  property("Safe Long == Safe Float") = verifyTF(TwoFace.Long(7L) == TwoFace.Float(7.0f), true)
  property("Safe Long == Unsafe Float") = verifyTF(TwoFace.Long(7L) == TwoFace.Float(us(7.0f)), us(true))
  property("Unsafe Long == Safe Float") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Float(7.0f), us(true))
  property("Unsafe Long == Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Float(us(7.0f)), us(true))
  property("Safe Long == Safe Double") = verifyTF(TwoFace.Long(7L) == TwoFace.Double(7.0), true)
  property("Safe Long == Unsafe Double") = verifyTF(TwoFace.Long(7L) == TwoFace.Double(us(7.0)), us(true))
  property("Unsafe Long == Safe Double") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Double(7.0), us(true))
  property("Unsafe Long == Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Double(us(7.0)), us(true))

  property("Safe Long != Safe Char") = verifyTF(TwoFace.Long(7L) != TwoFace.Char('\u0007'), false)
  property("Safe Long != Unsafe Char") = verifyTF(TwoFace.Long(7L) != TwoFace.Char(us('\u0007')), us(false))
  property("Unsafe Long != Safe Char") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Char('\u0007'), us(false))
  property("Unsafe Long != Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Char(us('\u0007')), us(false))
  property("Safe Long != Safe Int") = verifyTF(TwoFace.Long(7L) != TwoFace.Int(7), false)
  property("Safe Long != Unsafe Int") = verifyTF(TwoFace.Long(7L) != TwoFace.Int(us(7)), us(false))
  property("Unsafe Long != Safe Int") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Int(7), us(false))
  property("Unsafe Long != Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Int(us(7)), us(false))
  property("Safe Long != Safe Long") = verifyTF(TwoFace.Long(7L) != TwoFace.Long(7L), false)
  property("Safe Long != Unsafe Long") = verifyTF(TwoFace.Long(7L) != TwoFace.Long(us(7L)), us(false))
  property("Unsafe Long != Safe Long") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Long(7L), us(false))
  property("Unsafe Long != Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Long(us(7L)), us(false))
  property("Safe Long != Safe Float") = verifyTF(TwoFace.Long(7L) != TwoFace.Float(7.0f), false)
  property("Safe Long != Unsafe Float") = verifyTF(TwoFace.Long(7L) != TwoFace.Float(us(7.0f)), us(false))
  property("Unsafe Long != Safe Float") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Float(7.0f), us(false))
  property("Unsafe Long != Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Float(us(7.0f)), us(false))
  property("Safe Long != Safe Double") = verifyTF(TwoFace.Long(7L) != TwoFace.Double(7.0), false)
  property("Safe Long != Unsafe Double") = verifyTF(TwoFace.Long(7L) != TwoFace.Double(us(7.0)), us(false))
  property("Unsafe Long != Safe Double") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Double(7.0), us(false))
  property("Unsafe Long != Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Double(us(7.0)), us(false))

  property("Safe Long min Safe Long") = verifyTF(TwoFace.Long(2L) min TwoFace.Long(1L), 1L)
  property("Safe Long min Unsafe Long") = verifyTF(TwoFace.Long(2L) min TwoFace.Long(us(1L)), us(1L))
  property("Unsafe Long min Safe Long") = verifyTF(TwoFace.Long(us(2L)) min TwoFace.Long(1L), us(1L))
  property("Unsafe Long min Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) min TwoFace.Long(us(1L)), us(1L))

  property("Safe Long max Safe Int") = verifyTF(TwoFace.Long(2L) max TwoFace.Long(1L), 2L)
  property("Safe Long max Unsafe Int") = verifyTF(TwoFace.Long(2L) max TwoFace.Long(us(1L)), us(2L))
  property("Unsafe Long max Safe Int") = verifyTF(TwoFace.Long(us(2L)) max TwoFace.Long(1L), us(2L))
  property("Unsafe Long max Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) max TwoFace.Long(us(1L)), us(2L))

  property("Safe Negate") = verifyTF(-TwoFace.Long(-1L), 1L)
  property("Unsafe Negate") = verifyTF(-TwoFace.Long(us(1L)), us(-1L))

  //  property("Safe toChar") = verifyTF(TwoFace.Long(7L).toChar, '\u0001')
  //  property("Unsafe toChar") = verifyTF(TwoFace.Long(us(1L)).toChar, us('\u0001'))
  property("Safe toInt") = verifyTF(TwoFace.Long(1L).toInt, 1)
  property("Unsafe toInt") = verifyTF(TwoFace.Long(us(1L)).toInt, us(1))
  property("Safe toLong") = verifyTF(TwoFace.Long(1L).toLong, 1L)
  property("Unsafe toLong") = verifyTF(TwoFace.Long(us(1L)).toLong, us(1L))
  property("Safe toFloat") = verifyTF(TwoFace.Long(1L).toFloat, 1.0f)
  property("Unsafe toFloat") = verifyTF(TwoFace.Long(us(1L)).toFloat, us(1.0f))
  property("Safe toDouble") = verifyTF(TwoFace.Long(1L).toDouble, 1.0)
  property("Unsafe toDouble") = verifyTF(TwoFace.Long(us(1L)).toDouble, us(1.0))
  property("Safe toString") = verifyTF(TwoFace.Long(1L).toString, "1")
  property("Unsafe toString") = verifyTF(TwoFace.Long(us(1L)).toString, us("1"))

  property("Implicit Conversions") = wellTyped {
    import singleton.ops._
    val a : TwoFace.Long[3L] = implicitly[TwoFace.Long[2L + 1L]]
    val b : TwoFace.Long[3L + 0L] = implicitly[TwoFace.Long[2L + 1L]]
    val c : TwoFace.Long[3L + 0L] = implicitly[TwoFace.Long[3L]]
  }

  property("Wrong Implicit Conversions") = {
    import singleton.ops._
    illTyped("""val a : TwoFace.Int[3L] = implicitly[TwoFace.Int[2L + 2L]]""")
    illTyped("""val b : TwoFace.Int[3L + 0L] = implicitly[TwoFace.Int[2L + 2L]]""")
    illTyped("""val c : TwoFace.Int[3L + 0L] = implicitly[TwoFace.Int[4L]]""")
    true
  }
}