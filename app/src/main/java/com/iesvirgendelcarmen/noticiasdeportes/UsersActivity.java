package com.iesvirgendelcarmen.noticiasdeportes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.iesvirgendelcarmen.noticiasdeportes.adaptadores.UsersAdapter;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.User;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.UsersApi;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "EXTRA_USER";

    @BindView(R.id.users)
    ListView listViewUsers;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<User> listaUsers;
    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cargaDatos();
        setLayout();
    }

    /**
     * Configuración de la vista
     */
    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);

        //Evento click en item de la lista
        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Se lanza la Activity de detalles de la noticia
                Intent intent = new Intent(UsersActivity.this, UsersDetalleActivity.class);
                intent.putExtra(EXTRA_USER, listaUsers.get(i));
                startActivity(intent);
            }
        });
    }

    /**
     * Obtiene una lista de noticias usando la API pública newsapi.org
     * <p>
     * Se usa un callback para recibir la lista.
     */
    private void cargaDatos() {
        UsersApi api = new UsersApi();
        api.ultimosUsers(this, new UsersApi.Callback() {
            @Override
            public void getLista(List<User> noticias) {
                listaUsers = noticias;
                //Se instancia adaptador
                usersAdapter = new UsersAdapter(UsersActivity.this, listaUsers);
                listViewUsers.setAdapter(usersAdapter);
            }
        });

    }


}
