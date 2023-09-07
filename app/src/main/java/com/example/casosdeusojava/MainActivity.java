package com.example.casosdeusojava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity
{
    FloatingActionButton btnAdd;
    ListView listview;
    Dados dados = new Dados();
  /*  String mNome[] = {"Alex Rese", "Julio Cesar", "Ayton Senna", "Sigmund Freud", "Quentian Terantino"};
    String mDescricao[] = {"Professor da disciplina", "Imperador Romano", "Piloto",
                           "Reponsável pela revolkução", "Diretor de filmes Pop"};

    int images[] = {R.drawable.diana, R.drawable.dom, R.drawable.senna, R.drawable.diana, R.drawable.dom};
*/    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnIncluir);
        btnAdd.setOnClickListener(view ->
        {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        initializeListView();
    }


    LinearLayout _lastContainerSelected;
    private void initializeListView()
    {
        listview = findViewById(R.id.minhaListagem);
        CadastroAdapter adapter = new CadastroAdapter(this,
                dados.nomes, dados.profissoes, dados.idades, dados.descricoes, dados.images);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((parent, view, position, id) ->
        {
            LinearLayout containerSelect = (LinearLayout)view.findViewById(R.id.containerDetelhes);

            /*if (_lastContainerSelected != null) _lastContainerSelected.setVisibility(View.GONE);
            else if (_lastContainerSelected == linearLayoutSelect) {
                return;
            }*/

            if (_lastContainerSelected != null)
            {
                if (_lastContainerSelected != containerSelect)
                {
                    _lastContainerSelected.setVisibility(View.GONE);
                }
                /*else
                int lastVisibility = _lastContainerSelected.getVisibility();
                _lastContainerSelected.setVisibility(lastVisibility == View.VISIBLE ? View.GONE : View.VISIBLE);*/
            }

            int currentVisibility = containerSelect.getVisibility();
            containerSelect.setVisibility(currentVisibility == View.VISIBLE ? View.GONE : View.VISIBLE);

            _lastContainerSelected = containerSelect;
            Toast.makeText(MainActivity.this, dados.nomes[position], Toast.LENGTH_SHORT).show();
        });
    }
}

class CadastroAdapter extends ArrayAdapter
{
    Context context;
    String rNome[];
    String rProfissao[];
    int rIdade[];
    String rDescricao[];
    int rImgs[];

    public CadastroAdapter(Context c, String nome[], String profissao[], int idade[], String descricao[], int images[])
    {
        super(c, R.layout.elemento, R.id.textoNome, nome);
        this.context = c;
        this.rNome = nome;
        this.rProfissao = profissao;
        this.rIdade = idade;
        this.rDescricao = descricao;
        this.rImgs = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        LayoutInflater layoutInflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View elemento = layoutInflater.inflate(R.layout.elemento, parent, false);
        ImageView image = elemento.findViewById(R.id.image);
        TextView nome = elemento.findViewById(R.id.textoNome);
        TextView profissao = elemento.findViewById(R.id.textoProfissao);
        TextView idade = elemento.findViewById(R.id.textoIdade);
        TextView descricao = elemento.findViewById(R.id.textoDescricao);

        image.setImageResource(rImgs[position]);
        nome.setText(rNome[position]);
        profissao.setText(rProfissao[position]);
        idade.setText( "Idade: " + Integer.toString(rIdade[position]) + "anos");
        descricao.setText(rDescricao[position]);
        descricao.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        descricao.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);


        return elemento;
    }
}
class ContatoAdapter extends ArrayAdapter
{
    Context context;
    String rNome[];
    String rDescricao[];
    int rImgs[];

    public ContatoAdapter(Context c, String nome[], String descricao[], int images[])
    {
        super(c, R.layout.elemento, R.id.textoNome, nome);
        this.context = c;
        this.rNome = nome;
        this.rDescricao = descricao;
        this.rImgs = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        LayoutInflater layoutInflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View elemento = layoutInflater.inflate(R.layout.elemento, parent, false);
        ImageView images = elemento.findViewById(R.id.image);
        TextView meuNome = elemento.findViewById(R.id.textoNome);
        TextView minhaDescricao = elemento.findViewById(R.id.textoDescricao);

        images.setImageResource(rImgs[position]);
        meuNome.setText(rNome[position]);
        minhaDescricao.setText(rDescricao[position]);


        return elemento;
    }
}