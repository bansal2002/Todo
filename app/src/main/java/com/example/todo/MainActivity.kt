package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),INoteAdaptar {

    lateinit var viewModal: NoteViewModal
    lateinit var input:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        input = findViewById<EditText>(R.id.input)

        val adaptar = NoteAdaptar(this,this)
        recyclerView.adapter = adaptar
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModal = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModal::class.java)
        viewModal.allNotes.observe(this, Observer {
            adaptar.updateList(it)
        })

    }

    override fun OnItemClick(note: Notes) {
        viewModal.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun SubmitData(view: View) {
        val noteText = input.text.toString()
        if (noteText.isNotEmpty()){
            viewModal.InsetNote(Notes(noteText))
            Toast.makeText(this,"${noteText} Inserted",Toast.LENGTH_LONG).show()
        }
    }
}