package com.example.todo_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TarefaActivity extends AppCompatActivity {

    private TextView textViewTituloTarefa;
    private  TextView textViewDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        textViewTituloTarefa = findViewById(R.id.textViewTituloTarefa);
        textViewDescricao = findViewById(R.id.textViewDescricao);


        Intent intent = getIntent();
        String titulo = intent.getStringExtra("TITULO");
        String descricao = intent.getStringExtra("DESCRICAO");

        textViewTituloTarefa.setText(titulo);
        textViewDescricao.setText(descricao);
    }
}
