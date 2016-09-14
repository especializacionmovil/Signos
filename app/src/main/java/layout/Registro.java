package layout;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaimea.signos.BaseDatos.BaseDatos;
import com.example.jaimea.signos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Registro extends Fragment {

    TextView nombre, apellido, rh, telefono, correo;
    Button registrar;
    BaseDatos objeto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_registro, container, false);

        objeto= new BaseDatos(getContext().getApplicationContext());

        //Se instancian los objetos
        nombre=(TextView) v.findViewById(R.id.nombre);
        apellido=(TextView) v.findViewById(R.id.apellido);
        rh= (TextView) v.findViewById(R.id.rh);
        telefono= (TextView) v.findViewById(R.id.telefono);
        correo = (TextView) v.findViewById(R.id.correo);
        registrar= (Button) v.findViewById(R.id.btn_enviar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Guardar(view);
            }
        });


        return v;
    }

    public void Guardar(View v) {

        final SQLiteDatabase db = objeto.getWritableDatabase();
        // Gets the data repository in write mode

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BaseDatos.PregTabla.COLUMNA_NOMBRE, nombre.getText().toString());
        values.put(BaseDatos.PregTabla.COLUMNA_APELLIDO, apellido.getText().toString());
        values.put(BaseDatos.PregTabla.COLUMNA_RH, rh.getText().toString());
        values.put(BaseDatos.PregTabla.COLUMNA_TELEFONO, telefono.getText().toString());
        values.put(BaseDatos.PregTabla.COLUMNA_CORREO, correo.getText().toString());


        Toast.makeText(getContext().getApplicationContext(),""+values, Toast.LENGTH_LONG).show();
// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                BaseDatos.PregTabla.TABLE_NAME,
                null,//DataBase.PregTabla.COLUMNA_ID,
                values);
        Snackbar.make(v,"Se guardó la información "+newRowId,Snackbar.LENGTH_LONG).show();

        if(newRowId>1){
            nombre.setText(" ");
            apellido.setText(" ");
            rh.setText(" ");
            telefono.setText(" ");
            correo.setText(" ");
        }
    }
}
