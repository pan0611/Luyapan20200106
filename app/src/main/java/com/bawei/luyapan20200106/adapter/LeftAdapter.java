package com.bawei.luyapan20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.luyapan20200106.R;
import com.bawei.luyapan20200106.entity.LeftEntity;

import java.util.List;

/**
 * author :Administrator
 * time :2020/01/06上午 10:37
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    //创建集合
    private Context context;
    private List<LeftEntity> list;

    public LeftAdapter(Context context, List<LeftEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.left_item,null);//寻找布局
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).toString());//设置数据
        //点击传值
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
    //创建接口
    private LeftonClick leftonClick;

    public void setLeftonClick(LeftonClick leftonClick) {
        this.leftonClick = leftonClick;
    }

    public interface LeftonClick{
        void leftonClick(String id);
    }
}
