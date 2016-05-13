import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.linw.hellokotlin.R

class MainActivity : AppCompatActivity() {

    inline fun <reified TV : View> v(context:Context, init:TV.() -> Unit):TV{
        val constr = TV::class.java.getConstructor(Context::class.java)
        val view = constr.newInstance(context)
        view.init()
        return view
    }
    //代码解释:
    // <reified TV : View>
    // reify的意思是具体化。
    // 而作为Kotlin的一个方法泛型关键字，它代表你可以在方法体内访问泛型指定的JVM类对象。
    // 这段代码的意思就是v方法要使用命名为TV(意为Type of View，即View种类)的reified泛型，
    // 它指定类必须为View或其子类。必须以内联方式声明这个方法才有效。
    // 调用者要给TV指定一个具体的类型。

    //init: TV.() -> Unit
    //v方法有两个参数，一个是Context，一个是lambda风格的init。
    // init在这里很特殊，因为它是一种lambda with receiver类型的方法引用。
    // lambda with receiver是一个要求特定类型的对象的代码块，
    // 这里要求的对象在lambda代码中通过this关键字引用。
    // 在这里receiver对象就是reified泛型TV。


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
