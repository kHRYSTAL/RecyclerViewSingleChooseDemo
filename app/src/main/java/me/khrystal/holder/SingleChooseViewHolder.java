package me.khrystal.holder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.khrystal.impl.ItemClickListener;
import me.khrystal.recyclerviewsinglechoose.R;

/**
 *
 *
 * @FileName: me.khrystal.holder.SingleChooseViewHolder.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-02-15 10:11
 */
public class SingleChooseViewHolder extends BaseViewHolder{

    TextView contentView;
    RelativeLayout checkLayout;
    RelativeLayout rootLayout;

    private Context mContext;
    private int mPosition;
    private String mContent;
    private ItemClickListener mListener;


    public SingleChooseViewHolder(View itemView, Object parent,ItemClickListener listener) {
        super(itemView, parent);
        mContext = itemView.getContext();
        this.mListener = listener;
        contentView = (TextView) itemView.findViewById(R.id.item_content);
        checkLayout = (RelativeLayout)itemView.findViewById(R.id.item_check);
        rootLayout = (RelativeLayout)itemView.findViewById(R.id.item_root);
        addOnClickListener(rootLayout);
    }

    public void bind(String content,boolean check,int position){
        this.mPosition = position;
        this.mContent = content;
        contentView.setText(content);
        checkLayout.setVisibility(check ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.item_root:
                if (mListener!=null)
                    mListener.onItemClick(v,mContent,mPosition);
                break;
        }
    }
}
