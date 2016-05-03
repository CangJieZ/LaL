package zwt.sean.lal.module.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zwt.sean.lal.R;
import zwt.sean.lal.common.ImageLoaderUtils;
import zwt.sean.lal.common.OnRecycleClick;
import zwt.sean.lal.module.Info.LalInfo;

/**
 * Created by sean on 16/4/28.
 */
public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordHolder> {

    private RecordAdapter mAdapter;
    private ArrayList<LalInfo> list;
    private Context mContext;
    private OnRecycleClick mClick;

    public RecordAdapter(Context context,ArrayList<LalInfo> infos){
        this.list = infos;
        this.mContext = context;
    }

    public RecordAdapter setOnItemClick(OnRecycleClick click){
        mClick = click;
        return this;
    }

    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.record_item, parent, false);
        return new RecordHolder(view,mClick);
    }

    @Override
    public void onBindViewHolder(RecordHolder holder, int position) {
        LalInfo info = list.get(position);
        holder.name.setText(info.getName());
        ImageLoaderUtils.getInstance().displayImg(info.getUrl(),holder.img);
    }



    class RecordHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView img;
        private TextView name;
        private OnRecycleClick mClick;


        public RecordHolder(View itemView,OnRecycleClick click) {
            super(itemView);
            itemView.setTag(getAdapterPosition());
            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            mClick = click;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClick.onItemClick(getAdapterPosition());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
