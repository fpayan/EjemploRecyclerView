package esoftwar.es.ejemplorecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import esoftwar.es.ejemplorecyclerview.Adapters.UsersAdapter;
import esoftwar.es.ejemplorecyclerview.models.User;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 - Obteber una referencia a nuestro RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.primaryRecyclerView);
        // 2 - Creamos el LayoutManager
        layoutManager = new LinearLayoutManager( MainActivity.this );
        // 3 - Asignamos el LayoutManager
        recyclerView.setLayoutManager(layoutManager);
        // 4 - Crear el adaptador y asigmarlo al RecyclerView.
        adapter = new UsersAdapter( createAdapterUsers() );
        //
        recyclerView.setAdapter(adapter);
    }


    private List<User> createAdapterUsers() {
        List<User> users = new ArrayList<>();
        users.add( new User( 1, "Francisco Payán", 51 ) );
        users.add( new User( 2, "Maria Dolores Hernández", 55 ) );
        users.add( new User( 3, "Irene Payán", 21 ) );
        users.add( new User( 4, "Eduardo Rodriguez", 15 ) );
        users.add( new User( 5, "Elena Gómez", 34 ) );
        users.add( new User( 6, "Fernando Díaz", 45 ) );
        users.add( new User( 7, "Gullermo Tell", 23 ) );
        users.add( new User( 8, "Ana De La Torre", 35 ) );
        users.add( new User( 9, "Carlos Daza", 17 ) );
        users.add( new User( 10, "Francisco Delamo", 42 ) );
        users.add( new User( 11, "Irene Gomez", 78 ) );
        users.add( new User( 12, "José Heredia", 53 ) );

        return users;
    }

}
