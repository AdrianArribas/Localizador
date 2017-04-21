package a01.deberes.loc_cliente01;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import Javabeans.Objeto;
import modelo.GestionComunicacion;

import static android.webkit.WebSettings.PluginState.ON;
import static java.util.logging.Level.OFF;

public class SETXY extends AppCompatActivity {
    static Context ctx;
    public String datos;
    private ToggleButton interruptor;
    EditText nombreUser;
    String nombre="UNNAMED  USER";
    Objeto POS=new Objeto(nombre,0,0);
    GestionComunicacion GCom=new GestionComunicacion();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setxy);
        listenerToggle();
        ctx = this;
    }

    public void listenerToggle() {

        interruptor = (ToggleButton) findViewById(R.id.espia);

        interruptor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (interruptor.isChecked()) {

                    Toast.makeText(SETXY.this, "ACTIVADO", Toast.LENGTH_SHORT).show();

                    //obtenemos un obj locationmanager
                    LocationManager lm=(LocationManager)SETXY.this.getSystemService(Context.LOCATION_SERVICE);
                    //dato1=proveedor del servicio/dato2 espera entre actualizaciones
                    // /dato 3 distancia minima entre actualizaciones
                    // / hacia que objeto va dirigido
                    try {

                        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000,10,new Localizador());
                    }catch(SecurityException e){

                        e.printStackTrace();
                    }

                } else {

                    Toast.makeText(SETXY.this, "DESACTIVADO", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SETXY.this,Localizador.class);
                    SETXY.this.stopService(intent);
                }
            }
        });
    }
    public class Localizador implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            nombreUser=(EditText)SETXY.this.findViewById(R.id.Nombrepos);
            nombre=nombreUser.getText().toString();
            Toast.makeText(SETXY.this,"DETECTADO MOVIMIENTO DE "+nombre, Toast.LENGTH_SHORT).show();
            POS.setLatitud(location.getLatitude());
            POS.setLongitud(location.getLongitude());
            POS.setNombre(nombre);
            GCom.recuperarLugares(POS);
            //lo imprimimos en un toast
            Toast.makeText(SETXY.this,POS.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

}