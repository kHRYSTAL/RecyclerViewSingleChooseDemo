package me.khrystal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.khrystal.adapter.SingleChooseAdapter;
import me.khrystal.impl.ItemClickListener;
import me.khrystal.recyclerviewsinglechoose.R;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView recyclerView;
    SingleChooseAdapter adapter;
    List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            dataList.add(String.valueOf(i));
        }
        if (adapter != null) adapter.notifyDataSetChanged();
    }

    private void initUI() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        dataList = new ArrayList();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        adapter = new SingleChooseAdapter(this,dataList);
        adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, String content, int position) {
        adapter.setNotifyTip(position);
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }
}
