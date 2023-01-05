package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context:Context, private val listner:INotesAdapter) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

     val allNotes= ArrayList<Note>()

     inner class NotesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
         val textView=itemView.findViewById<TextView>(R.id.textView)
          val deleteButton=itemView.findViewById<Button>(R.id.imageView)

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
         val viewHolder=NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_adapter,parent,false))
         viewHolder.deleteButton.setOnClickListener{
            listner.onItemClicked(allNotes[viewHolder.adapterPosition])
         }

         return viewHolder
     }

     override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote=allNotes[position]
         holder.textView.text=currentNote.text
     }

     override fun getItemCount(): Int {
        return allNotes.size
     }

    fun updateList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }


}
interface INotesAdapter{
    fun onItemClicked(note:Note)
}