package com.example.appporcentagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nomeDoProduto;
    private TextInputEditText precoDoProduto;
    private TextInputEditText porcentagemDeDesconto;
    private Button valorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeDoProduto = findViewById(R.id.edtProduto);
        precoDoProduto = findViewById(R.id.edtPreco);
        porcentagemDeDesconto = findViewById(R.id.edtPorcentagem);
        valorTotal = findViewById(R.id.button);

        valorTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String precoProduto = precoDoProduto.getText().toString();
                String porcentagemDesconto = porcentagemDeDesconto.getText().toString();

                if (!precoProduto.isEmpty()){
                    if (!porcentagemDesconto.isEmpty()){
                        double resultadoPorcentagem = (Double.parseDouble(precoProduto) / 100)*Double.parseDouble(porcentagemDesconto) ;
                        double resultadoFinal = Double.parseDouble(precoProduto) - resultadoPorcentagem;

                        valorTotal.setText(String.valueOf(resultadoFinal));
                    }else {
                        Toast.makeText(getApplicationContext(),"Favor preencher o desconto !",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Favor preencher o preço !",Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}
