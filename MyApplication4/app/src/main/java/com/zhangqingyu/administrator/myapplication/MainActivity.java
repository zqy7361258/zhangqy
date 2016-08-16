package com.zhangqingyu.administrator.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private boolean status=false;
    private MyAdapter adapter=null;
    private Context mContext=this;
    private List<Map<String,Object>> totalList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        String[] arrUser=getResources().getStringArray(R.array.arrUser);
        for (int i = 0; i < arrUser.length; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("username",arrUser[i]);
            map.put(("status"),false);
            totalList.add(map);
        }
    }

    private void initView() {
        listView= (ListView) findViewById(R.id.list);
        adapter=new MyAdapter(mContext,totalList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(listView,"口口口口这不是乱码口口",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    public void clickView(View view){
        List<Map<String,Object>> list=new ArrayList<>();
        switch (view.getId()){
            case R.id.cancel:
                for (int i = 0; i < totalList.size(); i++) {
                    Map<String, Object> map = totalList.get(i);
                    map.put("status", false);
                    list.add(map);
                }
                adapter.reloadListView(list,true);
                break;
            case R.id.selectall:
                for (int i = 0; i < totalList.size(); i++) {
                    Map<String,Object> map=totalList.get(i);
                    map.put("status",true);
                    list.add(map);
                }
                adapter.reloadListView(list,true);
                break;
            case R.id.reverse:
                for (int i = 0; i < totalList.size(); i++) {
                    Map<String,Object> map=totalList.get(i);
                    map.put("status",!(boolean)((totalList.get(i).get("status"))));
                    list.add(map);
                }
                adapter.reloadListView(list,true);

                break;
            case R.id.delete:

                break;
        }

    }
}
