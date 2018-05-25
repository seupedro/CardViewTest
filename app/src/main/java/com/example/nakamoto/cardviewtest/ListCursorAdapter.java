package com.example.nakamoto.cardviewtest;

import android.animation.LayoutTransition;
import android.content.Context;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class ListCursorAdapter extends CursorRecyclerViewAdapter<ListCursorAdapter.ViewHolder>{

    public ListCursorAdapter(Context context, Cursor cursor){
        super(context,cursor);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView paramSubtitle;
        CardView cardViewParent;
        Button expandCollapseButton;
        ConstraintLayout constraintLayout;
        TableLayout tableLayout;
        public ViewHolder(View view) {
            super(view);
            cardViewParent = view.findViewById(R.id.card_parent);
            expandCollapseButton = view.findViewById(R.id.expand_collapse_button);
            paramSubtitle = view.findViewById(R.id.params_card_subtitle);
            constraintLayout = view.findViewById(R.id.constraint_card_child);
            tableLayout = view.findViewById(R.id.card_tableLayout);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, Cursor cursor) {

        /* Set Layout Animations on Change */
        viewHolder.constraintLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        /* Collapse/Expand Info */
        viewHolder.expandCollapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tableVisibility = viewHolder.tableLayout.getVisibility();
                 if (tableVisibility == View.VISIBLE){
                     viewHolder.tableLayout.setVisibility(View.GONE);
                     viewHolder.paramSubtitle.setVisibility(View.GONE);
                     viewHolder.expandCollapseButton.setText("Expand");
                 } else{
                     viewHolder.tableLayout.setVisibility(View.VISIBLE);
                     viewHolder.paramSubtitle.setVisibility(View.VISIBLE);
                     viewHolder.expandCollapseButton.setText("Collapse");
                 }
            }
        });

    }
}