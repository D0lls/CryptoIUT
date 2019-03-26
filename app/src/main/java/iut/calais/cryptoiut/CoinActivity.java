package iut.calais.cryptoiut;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.squareup.picasso.Picasso;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class CoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        CoinInfo coin_info = intent.getParcelableExtra("coin_property");
        TextView nom_crypto =  (TextView) findViewById(R.id.textCoin);
        TextView prix_crypto =  (TextView) findViewById(R.id.CoinPrice);
        nom_crypto.setText(coin_info.getName());
        prix_crypto.setText("https://images.coinviewer.io/currencies/64x64/"+coin_info.getSymbol()+".png");
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 1*parseFloat(coin_info.getPercentChange24h()))
        });
        ImageView imageViewCoin = (ImageView) findViewById((R.id.imageView3));
        Picasso.get().load("https://chasing-coins.com/api/v1/std/logo/"+coin_info.getSymbol()).into(imageViewCoin);
        graph.addSeries(series);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
