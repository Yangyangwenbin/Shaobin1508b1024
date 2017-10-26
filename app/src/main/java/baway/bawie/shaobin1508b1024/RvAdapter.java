package baway.bawie.shaobin1508b1024;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 朝朝暮暮 on 2017/10/24.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<UserBean.DataBean> list;

    public RvAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tv_age.setText(list.get(position).getUserAge()+"");
        viewHolder.tv_job.setText(list.get(position).getOccupation());
        viewHolder.tv_content.setText(list.get(position).getIntroduction());
        ImageLoader.getInstance().displayImage(list.get(position).getUserImg(),viewHolder.iv_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_image;
        private TextView tv_age;
        private TextView tv_job;
        private TextView tv_content;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_job = itemView.findViewById(R.id.tv_job);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
}
