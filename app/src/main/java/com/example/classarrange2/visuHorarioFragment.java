package com.example.classarrange2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class visuHorarioFragment extends Fragment {
    private Spinner spinnerCurso;
    private Spinner spinnerTurma;
    private Spinner spinnerSemestre;
    private Button btnVisualizarHorario;
    private Button btnGerarHorario;
    private TableLayout tableLayoutVisualizar;
    private TableLayout tableLayoutGerar;
    private List<String> cursosList;
    private List<String> turmasList;
    private List<String> semestresList;

    private Random random;

    private static final int NUM_COLUNAS = 5;
    private static final int NUM_LINHAS = 3;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visu_horario, container, false);

        spinnerCurso = view.findViewById(R.id.spinner_curso);
        spinnerTurma = view.findViewById(R.id.spinner_turma);
        spinnerSemestre = view.findViewById(R.id.spinner_semestre);
        btnVisualizarHorario = view.findViewById(R.id.btn_visualizar_horario);
        btnGerarHorario = view.findViewById(R.id.btn_gerar_horario);
        tableLayoutVisualizar = view.findViewById(R.id.table_layout_visualizar);
        tableLayoutGerar = view.findViewById(R.id.table_layout_gerar);
        cursosList = DadosEstaticos.getCursos();
        semestresList = DadosEstaticos.getSemestres();

        random = new Random();

        ArrayAdapter<String> cursoAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, cursosList);
        spinnerCurso.setAdapter(cursoAdapter);

        spinnerCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String curso = spinnerCurso.getSelectedItem().toString();
                loadTurmas(curso);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<String> semestreAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, semestresList);
        spinnerSemestre.setAdapter(semestreAdapter);

        btnVisualizarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curso = spinnerCurso.getSelectedItem().toString();
                String turma = spinnerTurma.getSelectedItem().toString();
                String semestre = spinnerSemestre.getSelectedItem().toString();
                List<String> disciplinas = DadosEstaticos.getDisciplinas(curso, semestre);
                obterDisciplinas(disciplinas);
                tableLayoutVisualizar.setVisibility(View.VISIBLE);
                tableLayoutGerar.setVisibility(View.GONE);
            }
        });

        btnGerarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curso = spinnerCurso.getSelectedItem().toString();
                String turma = spinnerTurma.getSelectedItem().toString();
                String semestre = spinnerSemestre.getSelectedItem().toString();
                List<String> disciplinas = DadosEstaticos.getDisciplinas(curso, semestre);
                gerarHorario(disciplinas);
                tableLayoutVisualizar.setVisibility(View.GONE);
                tableLayoutGerar.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void loadTurmas(String curso) {
        turmasList = DadosEstaticos.getTurmas(curso);

        ArrayAdapter<String> turmaAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, turmasList);
        spinnerTurma.setAdapter(turmaAdapter);
    }

    private void obterDisciplinas(List<String> disciplinas) {
        tableLayoutVisualizar.removeAllViews();

        for (String disciplina : disciplinas) {
            adicionarLinhaTabela(disciplina, tableLayoutVisualizar);
        }
    }

    private void gerarHorario(List<String> disciplinas) {
        tableLayoutGerar.removeAllViews();

        List<String> disciplinasAleatorias = new ArrayList<>(disciplinas);
        Collections.shuffle(disciplinasAleatorias);

        List<Integer> indicesUtilizados = new ArrayList<>();
        int contadorDisciplinas = 0;

        int numLinhas = NUM_LINHAS;

        for (int i = 0; i < numLinhas; i++) {
            TableRow row = new TableRow(getActivity());
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);

            for (int j = 0; j < NUM_COLUNAS; j++) {
                TextView disciplinaTextView = new TextView(getActivity());
                disciplinaTextView.setPadding(16, 16, 16, 16);

                if (contadorDisciplinas < disciplinasAleatorias.size()) {
                    int index = obterIndiceAleatorio(indicesUtilizados, disciplinasAleatorias.size());
                    String disciplina = disciplinasAleatorias.get(index);

                    disciplinaTextView.setText(disciplina);

                    indicesUtilizados.add(index);
                    contadorDisciplinas++;
                } else {
                    disciplinaTextView.setText("");
                }

                row.addView(disciplinaTextView);
            }

            tableLayoutGerar.addView(row);
        }
    }

    private int obterIndiceAleatorio(List<Integer> indicesUtilizados, int tamanhoLista) {
        int index = random.nextInt(tamanhoLista);

        while (indicesUtilizados.contains(index)) {
            index = random.nextInt(tamanhoLista);
        }

        return index;
    }

    private void adicionarLinhaTabela(String disciplina, TableLayout tableLayout) {
        TableRow row = new TableRow(getActivity());
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(layoutParams);

        TextView disciplinaTextView = new TextView(getActivity());
        disciplinaTextView.setText(disciplina);
        disciplinaTextView.setPadding(16, 16, 16, 16);
        row.addView(disciplinaTextView);

        tableLayout.addView(row);
    }
}
