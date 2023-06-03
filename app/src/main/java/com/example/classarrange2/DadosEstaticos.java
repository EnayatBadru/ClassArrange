package com.example.classarrange2;

import java.util.ArrayList;
import java.util.List;

public class DadosEstaticos {

    public static List<String> getCursos() {
        List<String> cursos = new ArrayList<>();
        cursos.add("LASIR");
        cursos.add("LDS");
        return cursos;
    }

    public static List<String> getTurmas(String curso) {
        List<String> turmas = new ArrayList<>();
        if (curso.equals("LASIR")) {
            turmas.add("LASIR1");
            turmas.add("LASIR2");
        } else if (curso.equals("LDS")) {
            turmas.add("LDS1");
            turmas.add("LDS2");
        }
        return turmas;
    }

    public static List<String> getSemestres() {
        List<String> semestres = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semestres.add(String.valueOf(i));
        }
        return semestres;
    }

    public static List<String> getDisciplinas(String curso, String semestre) {
        List<String> disciplinas = new ArrayList<>();
        if (curso.equals("LASIR")) {
            if (semestre.equals("1")) {
                disciplinas.add("IT"); // Inglês Técnico
                disciplinas.add("IL"); // Introdução à Lógica
                disciplinas.add("ALGA"); // Álgebra Linear e Geometria Analítica
                disciplinas.add("LP"); // Lógica de Programação
                disciplinas.add("SD"); // Sistemas Digitais
            } else if (semestre.equals("2")) {
                disciplinas.add("AM1"); // Análise Matemática I
                disciplinas.add("P1"); // Programação I
                disciplinas.add("AC"); // Arquitetura de Computadores
                disciplinas.add("EF"); // Ética Fundamental
                disciplinas.add("MP"); // Metodologia de Pesquisas
            } else if (semestre.equals("3")) {
                disciplinas.add("AM2"); // Análise Matemática II
                disciplinas.add("ADS"); // Análise e Desenho de Sistemas
                disciplinas.add("MD"); // Matemática Discreta
                disciplinas.add("EDA"); // Estruturas de Dados e Algoritmos
                disciplinas.add("P2"); // Programação II
            } else if (semestre.equals("4")) {
                disciplinas.add("SO"); // Sistemas Operativos
                disciplinas.add("IBD"); // Introdução a Base de Dados
                disciplinas.add("NDH"); // Noções de Dignidade Humana
                disciplinas.add("IRC"); // Introdução a Redes de Computadores
            } else if (semestre.equals("5")) {
                disciplinas.add("SSC"); // Segurança de Sistemas e Criptografia
                disciplinas.add("ASL"); // Administração de Sistemas Linux
                disciplinas.add("SDIS"); // Sistemas Distribuídos
                disciplinas.add("TC"); // Tecnologias de Comunicação
                disciplinas.add("SGBD"); // Sistemas de Gestão de Base de Dados
            } else if (semestre.equals("6")) {
                disciplinas.add("LR"); // Laboratório de Redes
                disciplinas.add("ES"); // Engenharia de Software
                disciplinas.add("GAE"); // Gestão e Administração de Empresas
                disciplinas.add("TRC"); // Tecnologia de Redes de Computadores
                disciplinas.add("DH"); // Direitos Humanos
                disciplinas.add("CMRF"); // Computação Móvel e Redes Sem Fio
            } else if (semestre.equals("7")) {
                disciplinas.add("TFCR"); // Técnicas Forenses para Computadores e Redes
                disciplinas.add("SRC"); // Segurança em Redes de Computadores
                disciplinas.add("GSI"); // Gestão de Segurança de Informação
                disciplinas.add("PDR"); // Planeamento e Desenho de Redes
                disciplinas.add("PF1"); // Projeto Final I
            } else if (semestre.equals("8")) {
                disciplinas.add("PF2"); // Projeto Final II
                disciplinas.add("EMP"); // Empreendedorismo
                disciplinas.add("EDP"); // Ética e Deontologia Profissional
            }
        } else if (curso.equals("LDS")) {
            if (semestre.equals("1")) {
                disciplinas.add("IL"); // Introdução à Lógica
                disciplinas.add("AM1"); // Análise Matemática I
                disciplinas.add("ALGA"); // Álgebra Linear e Geometria Analítica
                disciplinas.add("P1"); // Programação I
                disciplinas.add("LP"); // Lógica de Programação
            } else if (semestre.equals("2")) {
                disciplinas.add("ADS"); // Análise e Desenho de Sistemas
                disciplinas.add("EDA"); // Estruturas de Dados e Algoritmos
                disciplinas.add("MD"); // Matemática Discreta
                disciplinas.add("IBD"); // Introdução a Base de Dados
                disciplinas.add("P2"); // Programação II
            } else if (semestre.equals("3")) {
                disciplinas.add("SO"); // Sistemas Operativos
                disciplinas.add("IRC"); // Introdução a Redes de Computadores
                disciplinas.add("NDH"); // Noções de Dignidade Humana
                disciplinas.add("ASL"); // Administração de Sistemas Linux
                disciplinas.add("TC"); // Tecnologias de Comunicação
            } else if (semestre.equals("4")) {
                disciplinas.add("ES"); // Engenharia de Software
                disciplinas.add("GAE"); // Gestão e Administração de Empresas
                disciplinas.add("SDIS"); // Sistemas Distribuídos
                disciplinas.add("TRC"); // Tecnologia de Redes de Computadores
                disciplinas.add("DH"); // Direitos Humanos
                disciplinas.add("CMSF"); // Computação Móvel e Redes Sem Fio
            } else if (semestre.equals("5")) {
                disciplinas.add("BD"); // Bases de Dados
                disciplinas.add("IA"); // Inteligência Artificial
                disciplinas.add("ADO"); // Análise e Desenho Orientado a Objetos
                disciplinas.add("PP"); // Paradigma de Programação
                disciplinas.add("PWA"); // Programação Web Avançada (ASP.NET)
            } else if (semestre.equals("6")) {
                disciplinas.add("PF1"); // Projeto Final I
                disciplinas.add("ESA"); // Engenharia de Software Avançada
                disciplinas.add("RAP"); // Redesenho e Automação de Processos
                disciplinas.add("AM"); // Aplicações Móveis
                disciplinas.add("EDP"); // Ética e Deontologia Profissional
                disciplinas.add("POOA"); // Programação Orientada a Objetos Avançada
            } else if (semestre.equals("7")) {
                disciplinas.add("PF2"); // Projeto Final II
                disciplinas.add("EMP"); // Empreendedorismo
            }
        }
        return disciplinas;
    }
}
