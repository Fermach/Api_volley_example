package com.iesvirgendelcarmen.noticiasdeportes.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.iesvirgendelcarmen.noticiasdeportes.R;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.User;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.VolleySingleton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luis on 9/12/17.
 */

public class UsersAdapter extends BaseAdapter {

    private Context context;
    private List<User> users;

    public UsersAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.noticias_row_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        User user = (User) getItem(i);


        viewHolder.nombre.setText("Nombre: "+user.getFirst_name());
        viewHolder.apellido.setText("Apellido: "+user.getLast_name());
        viewHolder.email.setText("Email: "+user.getEmail());

        return view;
    }

    public static class ViewHolder {
        @BindView(R.id.listaNombre)
        TextView nombre;
        @BindView(R.id.listaApellido)
        TextView apellido;
        @BindView(R.id.listaEmail)
        TextView email;


        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
