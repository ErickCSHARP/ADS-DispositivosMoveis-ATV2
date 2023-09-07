package com.example.casosdeusojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class CadastroActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initializeProfissoes();
    }

    private void initializeProfissoes()
    {
        // Obtém a referência do Spinner em seu código
        Spinner spinner = findViewById(R.id.cad_profissao);

        // Obtém a lista de itens do arquivo de recursos
        String[] itens = getResources().getStringArray(R.array.source_profissoes);

        // Cria um ArrayAdapter usando a lista de itens
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);

        // Define o layout que será usado para exibir os itens na lista suspensa
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Define o adaptador para o Spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String itemSelecionado = (String) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
    }

    public void salvarClick(View view)
    {
        super.onBackPressed();
    }


    public void voltarClick(View view)
    {
        super.onBackPressed();
    }
}