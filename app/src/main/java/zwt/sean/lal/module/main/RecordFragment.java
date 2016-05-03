package zwt.sean.lal.module.main;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import zwt.sean.lal.Base.BaseFragment;
import zwt.sean.lal.R;
import zwt.sean.lal.common.OnRecycleClick;
import zwt.sean.lal.module.Info.LalInfo;

/**
 * Created by sean on 16/4/21.
 */
public class RecordFragment extends BaseFragment {

    @Bind(R.id.recycle)
    RecyclerView mRecycle;
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;

    @Bind(R.id.record_btn)
    FloatingActionButton mRecordBtn;
    @Bind(R.id.main_coord)
    CoordinatorLayout mMainCoord;


    private ArrayList<LalInfo> list;
    static String[] mStrings;
    private RecordAdapter mAdapter;

    static {
        mStrings = new String[]{
                "http://s8.sinaimg.cn/mw690/6d30b554gx6BOXR7hS717&690",
                "http://upload.site.cnhubei.com/2013/0121/1358749150752.jpg",
                "http://h.hiphotos.baidu.com/image/pic/item/b2de9c82d158ccbf9b3b2eed1dd8bc3eb0354166.jpg",
                "http://e.hiphotos.baidu.com/image/pic/item/3c6d55fbb2fb4316e923e0ad24a4462309f7d32d.jpg",
                "http://h.hiphotos.baidu.com/image/pic/item/6a63f6246b600c3310a0451f1e4c510fd8f9a108.jpg",
                "http://h.hiphotos.baidu.com/image/pic/item/9f2f070828381f308e36177ead014c086e06f03e.jpg",
                "http://g.hiphotos.baidu.com/image/pic/item/72f082025aafa40f75ee540aaf64034f78f01938.jpg",
                "http://b.hiphotos.baidu.com/image/pic/item/2f738bd4b31c8701c0632931237f9e2f0608ff14.jpg",
                "http://c.hiphotos.baidu.com/image/pic/item/d788d43f8794a4c2474741c70af41bd5ac6e39f1.jpg",
                "http://b.hiphotos.baidu.com/image/pic/item/4a36acaf2edda3cc9de31ecc05e93901203f92d3.jpg",
        };
    }


    @Override
    public int setContentView() {
        return R.layout.record_fragment;
    }

    @Override
    public void onCreate() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            LalInfo info = new LalInfo();
            info.setName("第" + i + "个item");
            info.setUrl(mStrings[i % 10]);
            list.add(info);
        }
        mAdapter = new RecordAdapter(getContext(), list);
        mAdapter.setOnItemClick(new OnRecycleClick() {
            @Override
            public void onItemClick(int position) {
                Snackbar.make(mMainCoord, "点击了:" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycle.setAdapter(mAdapter);


        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    @Override
    public void initListener() {
    }

}
