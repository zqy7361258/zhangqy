package com.zhangqingyu.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/1.
 */
public class MyAdapter extends BaseAdapterHelper<Map<String, Object>> {
    public MyAdapter(Context context, List<Map<String, Object>> list) {
        super(context, list);
    }

    @Override
    public View getItemView(final int position, View convertView, ViewGroup parent, final List<Map<String, Object>> list, LayoutInflater inflater) {
        ViewHolder mHolder = null;
        if (convertView == null) {
           convertView= inflater.inflate(R.layout.view, parent, false);
            mHolder=new ViewHolder(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder= (ViewHolder) convertView.getTag();
        }
        mHolder.v_title.setText(list.get(position).get("title")+"");
        mHolder.v_box.setChecked((Boolean) list.get(position).get("status"));

        mHolder.v_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean flag= (boolean)(list.get(position).get("status"));
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView v_title;
        private CheckBox v_box;

        public ViewHolder(View convertView) {
            v_title = (TextView) convertView.findViewById(R.id.v_title);
            v_box = (CheckBox) convertView.findViewById(R.id.v_box);
        }
    }
}
