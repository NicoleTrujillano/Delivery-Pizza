package com.example.goodpizza;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaFinal extends AppCompatActivity {

    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_final);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int quantmussa = getIntent().getIntExtra("quantmussa", 0);
        int quantcala = getIntent().getIntExtra("quantcala", 0);
        int quantmargue = getIntent().getIntExtra("quantmargue", 0);
        int quantportu = getIntent().getIntExtra("quantportu", 0);

        txtInfo = findViewById(R.id.txtInfo);

        String mussa = "";
        String cala = "";
        String margue = "";
        String portu = "";

        if (quantmussa != 0){
            mussa = ("- \t" + quantmussa + "x Pizza de Mussarela -------------------- R$" + String.format("%.2f", quantmussa*39.9) + "\n");
        }

        if (quantcala != 0){
            cala = ("- \t" + quantcala + "x Pizza de Calabresa -------------------- R$" + String.format("%.2f", quantcala*43.0) + "\n");
        }

        if (quantmargue != 0){
            margue = ("- \t" + quantmargue + "x Pizza de Margherita -------------------- R$" + String.format("%.2f", quantmargue*38.5) + "\n");
        }

        if (quantportu != 0){
            portu = ("- \t" + quantportu + "x Pizza de Portuguesa -------------------- R$" + String.format("%.2f", quantportu*45.00) + "\n");
        }

        double valortotal = quantmussa*39.9 + quantcala*43.0 + quantmargue*38.5 + quantportu*45.00;
        String total = ("- \tValor total:  R$" + String.format("%.2f",valortotal));

        txtInfo.setText(mussa + cala + margue + portu + "\n" + total);
    }
}