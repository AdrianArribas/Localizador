package a01.deberes.loc_cliente01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setXY (View v){
        this.startActivity(new Intent(this,SETXY.class));
    }

    public void getXY (View v){
        this.startActivity(new Intent(this,GETXY.class));
    }

}
