package com.example.todo_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todo_list.adapter.TarefaAdapter;
import com.example.todo_list.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarTarefas();

        listView = findViewById(R.id.listViewTarefas);

        arrayAdapterTarefa = new TarefaAdapter(MainActivity.this,
                (ArrayList<Tarefa>) tarefas);
        listView.setAdapter(arrayAdapterTarefa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* Toast toast =  Toast.makeText(getApplicationContext(),
                        tarefas.get(position).getNome(),
                        Toast.LENGTH_LONG); toast.show();*/
                Intent intent = new Intent(MainActivity.this, TarefaActivity.class);
                intent.putExtra("TITULO", tarefas.get(position).getNome());
                intent.putExtra("DESCRICAO",tarefas.get(position).getDescricao());
                startActivity(intent);
            }
        });
    }

    public void criarTarefas(){
        tarefas.add(new Tarefa("1","Estudar Android",false,"Faça a Tarefa"));
        tarefas.add(new Tarefa("2", "Estudar Testes",false,"Estude o Teste"));
        tarefas.add(new Tarefa("3","Jogar coupe",false,"Jogue o Coupe"));
    }
}
