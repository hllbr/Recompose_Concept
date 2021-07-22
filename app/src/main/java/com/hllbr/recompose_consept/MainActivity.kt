package com.hllbr.recompose_consept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hllbr.recompose_consept.ui.theme.Recompose_ConseptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
/*
State Management =

-State ne anlama geliyor? State durum anlamına gelmektedir.
-State development olarak herhangi bir değişen değer olarak ifade ediliyor.
-App içerisinde bir değer varsa ve zaman içerisinde bu değer değişebiliyorsa Bu bir state işaret ediyor demektir.
-Daha öncede değişebilen değerlerimiz vardı fakat Compose yapılar ile bir anlam/değer kazandı
--Burada odaklanmamaız gereken asıl konu Composition ve Recomposition

--Composition = Kullanıcı arayüzünün UI/User Interface in oluşturulması ve kullanıcıya gösterilmesi anblamına geliyor
--ReComposition = Bu yapının tekrar oluşturulması

App veya web vb... işlemlerde aynı görseli birden fazla kez göstermemiz gereken durumlarda Sürekli olarak Compose yapılmıyor.Bunun yerine ReCompose gerçekleştiriyoruz.
Composable'ın tekrar çalıştırılıp kullanıcıya tekrar gösterilmesini sağlan bir sistem oluşturulması gerekiyor.Eğer veri değişirse Recomposition oluşur.
İşte State ifade burada anlam kazanıyor.
Bu işlemin Manuel olarak yapılmaması için oluşturulmuş hazır yapılar mevcuttur.
mutableStateof == Değiştirilebilir anlamına gelir.
Bize değiştirilebilir bir değer oluşturması için çıkmış bir yapı
mutableStateof içinde bir değer tutuyor String olur integer olur ve bu değer değiştirildiğinde recomposition'a olanak sağlıyor.

birde remember == Hatırlamak için kullanılan bir yapı aslında remember bir fonksiyon bu fonksiyon composable fonksiyonlara hafıza katmak için oluşturulmuş bir yapı

 */
@Composable
fun MainScreen() {
    androidx.compose.material.Surface(color = Color.DarkGray) {
        Column(modifier = Modifier.fillMaxSize()
            ,verticalArrangement = Arrangement.Center
            ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var myString = "Android Compose"
            var myString1 = remember{ mutableStateOf("Android myCompose")}
            var myInteger by remember{ mutableStateOf(5)}
            TextField(value = myString1.value,onValueChange = {
                myString1.value = it
                println(myString1.value)
                })


            Spacer(modifier = Modifier.padding(7.dp))
            var textString = remember{ mutableStateOf("Hello!")}
            Text(text = textString.value,color = Color.White
                ,fontSize = 26.sp
                ,fontStyle = FontStyle.Normal)

            Spacer(modifier = Modifier.padding(7.dp))
            Button(onClick = {
                textString.value = "Android"
                println(textString)//bu noktada state management denilen bir yapıdan yararlanmak gerekiyor.
            }) {

                Text(text = "Button / ")
                Spacer(modifier = Modifier.padding(7.dp))
                Text(text = "Button Test")
            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()

}