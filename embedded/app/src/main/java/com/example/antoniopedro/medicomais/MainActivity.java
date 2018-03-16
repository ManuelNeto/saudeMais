package com.example.antoniopedro.medicomais;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.antoniopedro.medicomais.fragments.AjudaFragment;
import com.example.antoniopedro.medicomais.fragments.ConfiguracoesFragment;
import com.example.antoniopedro.medicomais.fragments.ConsultasEfetuadasFragment;
import com.example.antoniopedro.medicomais.fragments.FalarMedicoFragment;
import com.example.antoniopedro.medicomais.fragments.LoginFragment;
import com.example.antoniopedro.medicomais.fragments.MarcarConsultaFragment;
import com.example.antoniopedro.medicomais.fragments.PagamentosFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    public static final Integer MARCAR_CONSULTA = 1;
    public static final Integer CONSULTAS_EFETUADAS = 2;
    public static final Integer FALAR_MEDICO = 3;
    public static final Integer PAGAMENTO = 4;
    public static final Integer LOGIN = 6;
    public static final Integer CONFIGURACOES = 7;
    public static final Integer AJUDA = 8;
    public static final Integer LOGOUT = 9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        PrimaryDrawerItem marcarConsulta = new PrimaryDrawerItem().withIdentifier(MARCAR_CONSULTA).withName("Marcar consulta");
        PrimaryDrawerItem consultaEfetuada = new PrimaryDrawerItem().withIdentifier(CONSULTAS_EFETUADAS).withName("Consultas efetuadas");
        PrimaryDrawerItem falarMedico = new PrimaryDrawerItem().withIdentifier(FALAR_MEDICO).withName("Falar com o medico");
        PrimaryDrawerItem pagamento = new PrimaryDrawerItem().withIdentifier(PAGAMENTO).withName("Pagamentos");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(LOGIN).withName("Login");
        SecondaryDrawerItem configuracoes = new SecondaryDrawerItem().withIdentifier(CONFIGURACOES).withName("Configuracoes");
        SecondaryDrawerItem ajuda = new SecondaryDrawerItem().withIdentifier(AJUDA).withName("Ajuda");
        SecondaryDrawerItem logout = new SecondaryDrawerItem().withIdentifier(LOGOUT).withName("Logout");



        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.ic_launcher_background)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com")
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();


//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        marcarConsulta,
                        consultaEfetuada,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if(drawerItem.getIdentifier() == MARCAR_CONSULTA){
                            getSupportActionBar().setTitle("Marcar Consulta");
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new MarcarConsultaFragment()).commit();
                        }

                        if(drawerItem.getIdentifier() == CONSULTAS_EFETUADAS){
                            getSupportActionBar().setTitle("Consultas Efetuadas");
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new ConsultasEfetuadasFragment()).commit();
                        }
//
//                        if(drawerItem.getIdentifier() == FALAR_MEDICO){
//                            getSupportActionBar().setTitle("Falar com o Medico");
//                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new FalarMedicoFragment()).commit();
//                        }

//                        if(drawerItem.getIdentifier() == PAGAMENTO){
//                            getSupportActionBar().setTitle("Pagamentos");
//                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new PagamentosFragment()).commit();
//                        }

                        if(drawerItem.getIdentifier() == LOGIN){
                            getSupportActionBar().setTitle("Login");
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new LoginFragment()).commit();
                        }
//
//                        if(drawerItem.getIdentifier() == CONFIGURACOES){
//                            getSupportActionBar().setTitle("Configurações");
//                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new ConfiguracoesFragment()).commit();
//                        }

//                        if(drawerItem.getIdentifier() == AJUDA){
//                            getSupportActionBar().setTitle("Ajuda");
//                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new AjudaFragment()).commit();
//                        }

                        return false;
                    }
                })
                .build();
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new MarcarConsultaFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
