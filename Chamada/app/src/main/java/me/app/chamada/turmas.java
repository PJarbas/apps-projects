package me.app.chamada;

import android.content.Intent;
import android.os.Parcel;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.view.View;
import android.widget.Adapter;
import butterknife.ButterKnife;
import android.widget.TextView;

import org.parceler.Parcels;

public class turmas extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turmas);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_layour_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        final ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<String> alunos = new ArrayList<>();
        alunos.add("J1");
        alunos.add("J2");
        alunos.add("J3");
        alunos.add("J4");
        alunos.add("J5");

        for (int i = 0; i < 10; i++){
            Turma novaTurma = new Turma();
            novaTurma.setNome("Vespertino - " + i + " ANO");
            novaTurma.setNumero_alunos(12*i);
            novaTurma.setAlunos(alunos);

            turmas.add(novaTurma);
        }

        TurmasAdapter adapter = new TurmasAdapter(turmas, new TurmasAdapter.OnClickItem() {
            @Override
            public void onClickItem(int position) {
                IrparaChamada(turmas.get(position));
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void IrparaChamada(Turma turma){
        Intent intent = new Intent(getApplicationContext(), Chamada.class);
        intent.putExtra("turma", Parcels.wrap(turma));
        startActivity(intent);
    }
}
