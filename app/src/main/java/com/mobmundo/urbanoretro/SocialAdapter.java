package com.mobmundo.urbanoretro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anderson on 07/04/2015.
 */
public class SocialAdapter extends BaseAdapter {

    private List<Social> listSocial;
    private LayoutInflater mInflater;

    public SocialAdapter(Context context, List<Social> listSocial){
        this.listSocial = listSocial;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listSocial.size();
    }

    @Override
    public Object getItem(int position) {
        return listSocial.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Social social = listSocial.get(position);

        convertView = mInflater.inflate(R.layout.lv_social, null);
        ((TextView) convertView.findViewById(R.id.tvTitulo)).setText(social.getTitulo());
        ((ImageView) convertView.findViewById(R.id.im_social)).setImageDrawable(social.getImagem());
        return convertView;
    }
}
