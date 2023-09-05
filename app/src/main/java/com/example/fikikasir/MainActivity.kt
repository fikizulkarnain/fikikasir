package com.example.fikikasir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namapembeli = findViewById<EditText>(R.id.txtnamapembeli)
        val namabarang = findViewById<EditText>(R.id.txtnamabarang)
        val jumlahbeli = findViewById<EditText>(R.id.txtjumlahbeli)
        val harga = findViewById<EditText>(R.id.txtharga)
        val uangbayar = findViewById<EditText>(R.id.txtuangbayar)
        val btnproses= findViewById<Button>(R.id.btnproses)
        val totalbelanja =  findViewById<TextView>(R.id.txttotalbelanja)
        val kembalian =  findViewById<TextView>(R.id.txtuangkembalian)
        val bonus =  findViewById<TextView>(R.id.txtbonus)
        val keterangan =  findViewById<TextView>(R.id.txtketerangan)
        val btnreset =  findViewById<Button>(R.id.btnreset)



        btnproses.setOnClickListener {
        var total: Int = 0
        val jmlbeli = Integer.parseInt(jumlahbeli.text.toString())
        val hrg = Integer.parseInt(harga.text.toString())
        val bayar = Integer.parseInt(uangbayar.text. toString())


          total = jmlbeli * hrg
           val kembali = bayar - total

          totalbelanja.text = "total belanja: " + total.toString()
          kembalian.text = "uang kembalian: " + kembali.toString()

            if (bayar == total) {
                keterangan.text = "keterangan: kurang pas "
            }
            if (bayar < total) {
                keterangan.text = "keterangan: kurang bayar "+ abs(kembali)
            }
            if (bayar > total){
                keterangan.text = "keterangan: kembali"+ kembali
            }

            if(total >= 200000) {
                bonus.text = "bonus: mouse"
            } else if(total >= 400000) {
                bonus.text = "bonus: keyboard"
            } else if(total >= 600000) {
                bonus.text = "bonus: harddisk"
            } else {
                bonus.text = "bonus: tidak ada bonus"
            }

        }

        btnreset.setOnClickListener {
            namapembeli.setText("")
            namabarang.setText("")
            jumlahbeli.setText("")
            harga.setText("")
            uangbayar.setText("")
            totalbelanja.setText("total belanja")
            kembalian.setText("uang kembali")
            bonus.setText("bonus")
            keterangan.setText("keterangan")
        }
    }
}