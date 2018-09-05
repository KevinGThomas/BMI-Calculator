package com.example.kevingt.bmicalc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Kevin GT on 7/30/2018.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private Context context;
    private ArrayList<InfoModel> info;
    private DatabaseHelper databaseHelper;

    public HistoryAdapter(Context context,ArrayList<InfoModel> info) {
        this.context = context;
        this.info = info;
    }

    // inflate
    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false);
        HistoryViewHolder holder = new HistoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView dateText,ageText,resultText,noHistory,nameText,genderText;
        private ImageView delteIcon;
        private int index;

        public HistoryViewHolder(final View itemView) {
            super(itemView);
            delteIcon = (ImageView) itemView.findViewById(R.id.delete_icon);

            ageText = (TextView)itemView.findViewById(R.id.age);
            nameText = itemView.findViewById(R.id.name);
            genderText=itemView.findViewById(R.id.gender);
            resultText = (TextView)itemView.findViewById(R.id.result);
            noHistory = (TextView)itemView.findViewById(R.id.no_history);



        }

        public void onBind(int position){
            index = position;
            float l;
            ageText.setText(info.get(position).getAge());
            nameText.setText(info.get(position).getName());
            genderText.setText(info.get(position).getSex());
            resultText.setText(info.get(position).getBmiResult());
            l=Float.parseFloat(info.get(position).getBmiResult());
            if(l< 18.5)
                delteIcon.setImageResource(R.drawable.ic_expressions_blue);
            else if(l< 25)
                delteIcon.setImageResource(R.drawable.ic_expressions_green);
            else if(l<30)
                delteIcon.setImageResource(R.drawable.ic_expressions_yellow);
            else
                delteIcon.setImageResource(R.drawable.ic_expressions_red);

        }


        @Override
        public void onClick(View view) {
            Log.d("from adapter: ",index+"");
            info.remove(index);
            if (index == 0){
                notifyDataSetChanged();
            }else{
                notifyItemRemoved(index);
            }
            // databaseHelper = new DatabaseHelper(context);
            //  databaseHelper.REMOVE_RECORD(index+1);

        }
    }
    }
