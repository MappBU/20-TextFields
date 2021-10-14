package com.example.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat

// Интерфейс...
class MainActivity : AppCompatActivity(),View.OnKeyListener {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 1 Тап по самому полю ввода
        binding?.enterCity?.setOnKeyListener(this)

        // 2 Тап по самому полю ввода
        binding?.enterCity2?.setOnKeyListener(this)

        // нажатие на иконку вопроса во 2 поисковике
        // Вызывает нижний снекбар с названием... и кнопкой...
        binding?.sectionEnterCity2?.setEndIconOnClickListener {
            Snackbar.make(it, R.string.headerSnack, Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this, R.color.orange))
                .setAction(R.string.headerActionSnack) {}
                .show()
        }

    }

    // 1 Реализация результата в зависимости от введенных данных (Переопределяем шаблонный метод) 1
    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {
            R.id.enterCity -> {
                // Если в поле что-то введено, то при применении...
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.result?.text = binding?.enterCity?.text
                    // Очищаем Поле ввода
                    binding?.enterCity?.setText("")
                    return true
                }

            }

            R.id.enterCity2 -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.result?.text = binding?.enterCity?.text
                    binding?.enterCity?.setText("")
                    return true
                }
            }
        }
        return false

    }
}