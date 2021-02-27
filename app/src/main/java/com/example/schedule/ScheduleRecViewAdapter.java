package com.example.schedule;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schedule.model.Class;
import com.example.schedule.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRecViewAdapter extends RecyclerView.Adapter<ScheduleRecViewAdapter.ViewHolder> {

    private List<Class> classes = new ArrayList<>();
    private Context context;

    public ScheduleRecViewAdapter(Context context) {
        this.context = context;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameClassTV.setText(classes.get(position).getName());
        holder.nameTeacherTV.setText(classes.get(position).getTeacher().getName());
        Schedule schedule1 = classes.get(position).getScheduleOne();
        String schedule1str = schedule1.getDay()+" h: "+schedule1.getStartTime()+" ";
        Schedule schedule2 = classes.get(position).getScheduleTwo();
        String schedule2str = schedule2.getDay()+" h: "+schedule2.getStartTime();
        holder.schedule1TV.setText(schedule1str);
        holder.schedule2TV.setText(schedule2str);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameClassTV;
        private TextView nameTeacherTV;
        private TextView schedule1TV;
        private TextView schedule2TV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameClassTV = (TextView) itemView.findViewById(R.id.name_class_text_view);
            nameTeacherTV = (TextView) itemView.findViewById(R.id.name_teacher_text_view);
            schedule1TV = (TextView) itemView.findViewById(R.id.schedule_1_text_view);
            schedule2TV = (TextView)itemView.findViewById(R.id.schedule_2_text_view);
        }
    }
}
