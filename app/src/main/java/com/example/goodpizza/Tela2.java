package com.example.goodpizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2 extends AppCompatActivity {

    private Button btnMenos1, btnMais1, btnMenos2, btnMais2, btnMenos3, btnMais3, btnMenos4, btnMais4, btnPedido;
    private TextView edtQuantMussa, edtQuantCala, edtQuantMarg, edtQuantPort;
    int quant1 = 0, quant2 = 0, quant3 = 0, quant4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenos1 = findViewById(R.id.btnMenos1);
        btnMais1 = findViewById(R.id.btnMais1);
        btnMenos2 = findViewById(R.id.btnMenos2);
        btnMais2 = findViewById(R.id.btnMais2);
        btnMenos3 = findViewById(R.id.btnMenos3);
        btnMais3 = findViewById(R.id.btnMais3);
        btnMenos4 = findViewById(R.id.btnMenos4);
        btnMais4 = findViewById(R.id.btnMais4);

        btnPedido = findViewById(R.id.btnPedido);

        edtQuantMussa = findViewById(R.id.edtQuantMussa);
        edtQuantCala = findViewById(R.id.edtQuantCala);
        edtQuantMarg = findViewById(R.id.edtQuantMarg);
        edtQuantPort = findViewById(R.id.edtQuantPort);

        // MUSSARELA
        btnMais1.setOnClickListener(v -> {
            quant1++;
            edtQuantMussa.setText(String.valueOf(quant1));
        });

        btnMenos1.setOnClickListener(v -> {
            if (quant1 > 0) { // Evita números negativos
                quant1--;
            }
            edtQuantMussa.setText(String.valueOf(quant1));
        });

        // CALABRESA
        btnMais2.setOnClickListener(v -> {
            quant2++;
            edtQuantCala.setText(String.valueOf(quant2));
        });

        btnMenos2.setOnClickListener(v -> {
            if (quant2 > 0) { // Evita números negativos
                quant2--;
            }
            edtQuantCala.setText(String.valueOf(quant2));
        });

        // MARQUERITTA
        btnMais3.setOnClickListener(v -> {
            quant3++;
            edtQuantMarg.setText(String.valueOf(quant3));
        });

        btnMenos3.setOnClickListener(v -> {
            if (quant3 > 0) { // Evita números negativos
                quant3--;
            }
            edtQuantMarg.setText(String.valueOf(quant3));
        });

        // PORTUGUESA
        btnMais4.setOnClickListener(v -> {
            quant4++;
            edtQuantPort.setText(String.valueOf(quant4));
        });

        btnMenos4.setOnClickListener(v -> {
            if (quant4 > 0) { // Evita números negativos
                quant4--;
            }
            edtQuantPort.setText(String.valueOf(quant4));
        });


    }

    public void fazerPedido(View view){

        if(quant1 > 0 || quant2 > 0 || quant3 > 0 || quant4 > 0) {
            Intent it = new Intent(getApplicationContext(), TelaFinal.class);
            it.putExtra("quantmussa", quant1);
            it.putExtra("quantcala", quant2);
            it.putExtra("quantmargue", quant3);
            it.putExtra("quantportu", quant4);
            startActivity(it);
        } else {
            Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT).show();
        }
    }
}