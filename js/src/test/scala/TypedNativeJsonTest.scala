import org.getshaka.nativeconverter.*

object TypedNativeJsonTest {
  case class Test(a: String, b: Int)
  @main def test(): Unit = {
    val scalaValue = Test("hello", 100)
    val nativeValue = scalaValue.toTypedNative
    val fromNativeValue: Test = nativeValue.unwrap
    assert(scalaValue == fromNativeValue)

    val typedJson = scalaValue.toTypedJson
    val fromTypedValue: Test = typedJson.unwrap
    assert(scalaValue == fromTypedValue)
  }
}
