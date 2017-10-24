package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/24/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<AnimeCharacter> animeCharacterList = new ArrayList<>();
    Context context;

    public RecyclerAdapter(List<AnimeCharacter> animeCharacterList) {
        this.animeCharacterList = animeCharacterList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AnimeCharacter animeCharacter = animeCharacterList.get(position);

        holder.tvAnimeCharacterName.setText("Name: " + animeCharacter.getName());
        holder.tvAnimeCharacterShow.setText("Show: " + animeCharacter.getShow());
        holder.tvAnimeCharacterCatchPhrase.setText("Catch Phrase: " + animeCharacter.getCatchPhase());
    }

    @Override
    public int getItemCount() {
        return animeCharacterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAnimeCharacterName, tvAnimeCharacterShow, tvAnimeCharacterCatchPhrase;

        public ViewHolder(View itemView) {
            super(itemView);

            tvAnimeCharacterName = itemView.findViewById(R.id.tvAnimeCharacterName);
            tvAnimeCharacterShow = itemView.findViewById(R.id.tvAnimeCharacterShow);
            tvAnimeCharacterCatchPhrase = itemView.findViewById(R.id.tvAnimeCharacterCatchPhrase);

        }
    }
}
