package me.khrystal.holder;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 列表ViewHolder基类
 *
 * @FileName: me.shurufa.holder.BaseViewHolder.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-01-21 18:51
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected Activity mActivity;
    protected Fragment mFragment;
    public View mView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public BaseViewHolder(View itemView, Object parent) {
        super(itemView);
        if (parent == null)
            return;
        if (parent instanceof Activity) {
            mActivity = (Activity) parent;
        } else if (parent instanceof Fragment) {
            mFragment = (Fragment) parent;
        }
    }

    public void addOnClickListener(View view) {
        if (view != null)
            view.setOnClickListener(this);
    }

    protected boolean checkLogin() {
       return true;
    }

    @Override
    public void onClick(View v) {

    }
}
