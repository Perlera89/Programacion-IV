package com.example.sqlliveapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.prefs.PreferencesFactory

class AdminSqLite(Contex:Context?,
                  name: String,
                  factory: SQLiteDatabase.CursorFactory?,
                  version:Int): SQLiteOpenHelper(Contex,name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        //Creacion de BD
        db?.execSQL("create table article(id int primary key,description text, price real)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}