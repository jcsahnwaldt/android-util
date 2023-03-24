package jcsahnwaldt.util.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View

interface ActivityCompanion {
    @Suppress("UNCHECKED_CAST")
    val cls: Class<out Activity> get() =
        javaClass.declaringClass!! as Class<out Activity>

    fun extraKey(key: String) =
        "${cls.name}.${key}"
}

interface NullaryActivityCompanion : ActivityCompanion {
    fun start(context: Activity) =
        context.startActivity(cls)

    fun starter(context: Activity) =
        View.OnClickListener { start(context) }
}

interface UnaryActivityCompanion : ActivityCompanion {
    fun start(context: Activity, k: String?, v: Any?) =
        context.startActivity(cls, k, v)

    fun starter(context: Activity, k: String?, v: Any?) =
        View.OnClickListener { start(context, k, v) }
}

interface BinaryActivityCompanion : ActivityCompanion {
    fun start(context: Activity, k0: String?, v0: Any?, k1: String?, v1: Any?) =
        context.startActivity(cls, k0, v0, k1, v1)

    fun starter(context: Activity, k0: String?, v0: Any?, k1: String?, v1: Any?) =
        View.OnClickListener { start(context, k0, v0, k1, v1) }
}

fun Context.startActivity(cls: Class<out Activity>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

fun Context.startActivity(cls: Class<out Activity>, k: String?, v: Any?) {
    val intent = Intent(this, cls)
    intent.putExtra(k, v)
    startActivity(intent)
}

fun Context.startActivity(cls: Class<out Activity>, k0: String?, v0: Any?, k1: String?, v1: Any?) {
    val intent = Intent(this, cls)
    intent.putExtra(k0, v0)
    intent.putExtra(k1, v1)
    startActivity(intent)
}

@Suppress("UNCHECKED_CAST") // https://youtrack.jetbrains.com/issue/KT-11948
fun Intent.putExtra(k: String?, v: Any?) {
    when {
        v is String -> putExtra(k, v)
        v is Array<*> && v.isArrayOf<String>() -> putExtra(k, v as Array<String>)
        v is CharSequence -> putExtra(k, v)
        v is Array<*> && v.isArrayOf<CharSequence>() -> putExtra(k, v as Array<CharSequence>)
        v is Boolean -> putExtra(k, v)
        v is BooleanArray -> putExtra(k, v)
        v is Byte -> putExtra(k, v)
        v is ByteArray -> putExtra(k, v)
        v is Char -> putExtra(k, v.toChar())
        v is CharArray -> putExtra(k, v)
        v is Double -> putExtra(k, v)
        v is DoubleArray -> putExtra(k, v)
        v is Float -> putExtra(k, v)
        v is FloatArray -> putExtra(k, v)
        v is Int -> putExtra(k, v)
        v is IntArray -> putExtra(k, v)
        v is Long -> putExtra(k, v)
        v is LongArray -> putExtra(k, v)
        v is Short -> putExtra(k, v)
        v is ShortArray -> putExtra(k, v)
        v != null -> throw IllegalArgumentException("cannot handle extra of type " + v.javaClass.name + ": [" + v + "]")
    }
}
