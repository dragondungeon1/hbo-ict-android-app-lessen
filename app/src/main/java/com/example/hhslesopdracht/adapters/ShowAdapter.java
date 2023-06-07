package com.example.hhslesopdracht;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hhslesopdracht.models.Show;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private List<Show> data;

    public ShowAdapter(List<Show> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,
                                 int position) {
        Show show = data.get(position);
        holder.showNameTf.setText(show.getName());
        String characterName = show.getCharacter() !=
                null ?
                show.getCharacter().getName() :
                null;
        holder.characterNameTf.setText(characterName);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_row, parent, false);
        return new ViewHolder(view);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView showNameTf;
        private TextView characterNameTf;

        public ViewHolder(View itemView) {
            super(itemView);
            showNameTf = itemView.findViewById(R.id.
                    showRow_showName_tf);
            characterNameTf = itemView.findViewById(R.id.
                    showRow_showCharacter_tf);
        }
    }
}
