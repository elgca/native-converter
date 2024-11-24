package org.getshaka.nativeconverter

import scala.scalajs.js

opaque type TypedNative[+A] <: js.Any = js.Any
extension [A](base: A) inline def toTypedNative(using NativeConverter[A]): TypedNative[A] = base.toNative
extension [A](base: TypedNative[A]) inline def unwrap(using a: NativeConverter[A]): A = a.fromNative(base)

opaque type TypedJson[+A] <: String = String
extension [A](base: A) inline def toTypedJson(using NativeConverter[A]): TypedJson[A] = base.toJson
extension [A](base: TypedJson[A]) inline def unwrap(using a: NativeConverter[A]): A = a.fromJson(base)
