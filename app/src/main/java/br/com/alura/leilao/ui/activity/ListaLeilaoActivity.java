package br.com.alura.leilao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

public class ListaLeilaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_leilao);
        ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(this, leiloesDeExemplo());
        RecyclerView recyclerView = findViewById(R.id.lista_leilao_recyclerview);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ListaLeilaoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Leilao leilao) {
                Intent vaiParaLancesLeilao = new Intent(ListaLeilaoActivity.this, LancesLeilaoActivity.class);
                vaiParaLancesLeilao.putExtra("leilao", leilao);
                startActivity(vaiParaLancesLeilao);
            }
        });
    }

    private List<Leilao> leiloesDeExemplo() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("John"), 200.0));
        console.propoe(new Lance(new Usuario("Igor"), 30.0));
        return new ArrayList<>(Arrays.asList(
                console
        ));
    }

}
