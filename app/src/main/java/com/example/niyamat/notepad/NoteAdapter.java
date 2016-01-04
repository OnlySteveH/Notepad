package com.example.niyamat.notepad;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Niyamat on 1/3/2016.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private Context mContext;
    private Note[] mNotes;

    public NoteAdapter(Context context, Note[] notes) {
        mContext = context;
        mNotes = notes;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_view, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.mNoteTitleTextView.setText(mNotes[position].getTitle());
    }

    @Override
    public int getItemCount() {
        return mNotes.length;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView mNoteTitleTextView;

        public NoteViewHolder(View itemView) {
            super(itemView);
            mNoteTitleTextView = (TextView) itemView.findViewById(R.id.list_note_title);
        }
    }
}
