package me.khrystal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.khrystal.holder.SingleChooseViewHolder;
import me.khrystal.impl.ItemClickListener;
import me.khrystal.recyclerviewsinglechoose.R;

/**
 * 单选适配器
 *
 * @FileName: me.khrystal.adapter.SingleChooseAdapter.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-02-15 10:05
 */
public class SingleChooseAdapter extends RecyclerView.Adapter<SingleChooseViewHolder> {

    List<String> dataList;
    Object parent;
    int notifyTip ;
    ItemClickListener listener;

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    public SingleChooseAdapter(Object parent, List<String> dataList) {
        this.dataList = dataList;
        this.parent = parent;
        notifyTip = -1;
    }

    public void setNotifyTip(int notifyTip) {
        this.notifyTip = notifyTip;
    }

    @Override
    public SingleChooseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_choose, parent, false);
        SingleChooseViewHolder holder = new SingleChooseViewHolder(v, parent,listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(SingleChooseViewHolder holder, int position) {
        String s = dataList.get(position);
        if (notifyTip == position)
            holder.bind(s,true,position);
        else
            holder.bind(s,false,position);
    }

    public void append(String[] items) {
        int pos = dataList.size();
        for (String item : items) {
            if (!dataList.contains(item))
                dataList.add(item);
        }
        notifyItemRangeInserted(pos, items.length);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void remove(int position) {
        if (dataList.size() > 0) {
            dataList.remove(position);
            this.notifyItemRemoved(position);
        }
    }

    public void clear() {
        int size = dataList.size();
        dataList.clear();
        this.notifyItemRangeRemoved(0, size);
    }
}
