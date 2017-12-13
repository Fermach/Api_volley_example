package com.iesvirgendelcarmen.noticiasdeportes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.User;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.VolleySingleton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersDetalleActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.detalleID)
    TextView id;
    @BindView(R.id.detalleNombre)
    TextView nombre;
    @BindView(R.id.detalleApellido)
    TextView apellido;
    @BindView(R.id.detalleEmail)
    TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_detalle);
        ButterKnife.bind(this);

        User user = (User) getIntent().getExtras().getSerializable(UsersActivity.EXTRA_USER);

        setLayout();
        setUser(user);
    }


    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * Establece valores para los views de la noticia
     *
     * @param user Objeto noticia
     */
    private void setUser(User user) {
        if (user != null) {
            nombre.setText("Nombre: "+user.getFirst_name());
            apellido.setText("Apellidos: "+user.getLast_name());
            id.setText("ID: "+user.getId());
            email.setText("Email: "+user.getEmail());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
