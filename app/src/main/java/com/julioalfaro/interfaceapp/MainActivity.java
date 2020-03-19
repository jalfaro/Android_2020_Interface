package com.julioalfaro.interfaceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.julioalfaro.interfaceapp.adapters.MenuAdapter;
import com.julioalfaro.interfaceapp.data.OptionMenu;
import com.julioalfaro.interfaceapp.fragments.FragmentDos;
import com.julioalfaro.interfaceapp.fragments.FragmentUno;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView opciones;
    private ActionBarDrawerToggle drawerToggle;
    private List<OptionMenu> listaOpciones;
    private FragmentUno f1;
    private FragmentDos f2;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOption();
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        opciones = findViewById(R.id.listaOpciones);
        initToolbar();
        opciones.setAdapter(new MenuAdapter(this, listaOpciones));
        opciones.setOnItemClickListener(this);
    }

    void initToolbar() {
        toolbar.setTitle("Ejemplo");
        toolbar.setTitleTextColor(Color.rgb(255,255,255));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name, R.string.app_name);
        drawerToggle.syncState();
    }

    void initOption() {
        listaOpciones = new ArrayList<OptionMenu>();
        OptionMenu option = new OptionMenu();
        option.setMessage("Opcion 1");
        option.setImage(R.drawable.ic_tabla);
        listaOpciones.add(option);
        option = new OptionMenu();
        option.setMessage("Opcion 2");
        option.setImage(R.drawable.ic_hoja);
        listaOpciones.add(option);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_configuracion) {
            Toast.makeText(this, "Selecciono Configuracion", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.menu_exit) {
            Toast.makeText(this, "Selecciono Salir", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (position == 0) {
            f1 = new FragmentUno();
           transaction.replace(R.id.frame, f1 );
        } else {
            f2 = new FragmentDos();
            transaction.replace(R.id.frame, f2 );
        }
        drawerLayout.closeDrawer(GravityCompat.START, true);
        transaction.commit();
    }
}
