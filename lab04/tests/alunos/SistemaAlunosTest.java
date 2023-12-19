package alunos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class SistemaAlunosTest {

    private SistemaAlunos sistemaAlunos;

    @BeforeEach
    void preparaSistemaAlunos() {
        this.sistemaAlunos = new SistemaAlunos();
        this.sistemaAlunos.cadastrarAluno("Gabriel Reyes", "250", "Computação");
        this.sistemaAlunos.cadastrarAluno("Lili Camposh", "200", "Computação");
        this.sistemaAlunos.cadastrarAluno("Angela Ziegler", "202", "Medicina");
        this.sistemaAlunos.cadastrarAluno("Torbjorn Lindholm", "201", "Engenharia Mecânica");
        this.sistemaAlunos.cadastrarGrupo("Programação OO", "");
        this.sistemaAlunos.cadastrarGrupo("Listas", "Computação");
        this.sistemaAlunos.alocarAluno("202", "Programação OO");
        this.sistemaAlunos.registrarAluno("201");
    }

    @Test
    void testCadastrarAluno() {
        String msg = "ESPERANDO CADASTRO REALIZADO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.cadastrarAluno("Alexandre Corlet", "119", "Computação");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastrarAlunoCadastrado() {
        String msg = "ESPERANDO ALUNO JÁ CADASTRADO";
        boolean expected = false;
        boolean actual = this.sistemaAlunos.cadastrarAluno("Angela Ziegler", "202", "Medicina");
        assertEquals(expected, actual, msg);
    }


    @Test
    void testConsultarAluno() {
        String msg = "ESPERANDO DADOS DO ALUNO SEREM EXIBIDOS";
        String expected = "Aluno: 250 - Gabriel Reyes - Computação";
        String actual = this.sistemaAlunos.consultarAluno("250");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testConsultarAlunoNaoCadastrado() {
        String msg = "ESPERANDO QUE UMA EXCEÇÃO SEJA LANÇADA";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.consultarAluno("100");
        });

        String expectedMessage = "ALUNO NÃO CADASTRADO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, msg);
    }

    @Test
    void testConsultarAlunoMatriculaInvalida() {
        String msg = "ESPERANDO QUE MATRÍCULA SEJA INVÁLIDA";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.consultarAluno(" ");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, msg);

    }

    @Test
    void testConsultarAlunoMatriculaNull() {
        String msg = "ESPERANDO QUE MATRÍCULA SEJA INVÁLIDA";
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.consultarAluno(null);
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, msg);
    }

    @Test
    void testIsAlunoCadastrado() {
        String msg = "ESPERANDO QUE ALUNO SEJA CADASTRADO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.isAlunoCadastrado("201");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsAlunoNaoCadastrado() {
        String msg = "ESPERANDO ALUNO NÃO CADASTRADO.";
        boolean expected = false;
        boolean actual = this.sistemaAlunos.isAlunoCadastrado("100");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsAlunoCadastradoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.isAlunoCadastrado(null);
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsAlunoCadastradoSemMatricula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.isAlunoCadastrado(" ");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testCadastrarGrupoSemRestricao() {
        String msg = "ESPERANDO CADASTRO REALIZADO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.cadastrarGrupo("Cantina da UFCG", "");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastrarGrupoComRestricao() {
        String msg = "ESPERANDO CADASTRO REALIZADO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.cadastrarGrupo("Alunos da Computação", "Computação");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastrarGrupoJaCadastrado() {
        String msg = "ESPERANDO GRUPO JA CADASTRADO";
        boolean expected = false;
        boolean actual = this.sistemaAlunos.cadastrarGrupo("Listas", "Computação");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsGrupoCadastrado() {
        String msg = "ESPERANDO GRUPO JA CADASTRADO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.isGrupoCadastrado("Listas");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsGrupoNaoCadastrado() {
        String msg = "ESPERANDO QUE GRUPO NÃO SEJA CADASTRADO";
        boolean expected = false;
        boolean actual = this.sistemaAlunos.isGrupoCadastrado("Nescau é melhor que Toddy");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsGrupoCadastradoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.isGrupoCadastrado(null);
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsGrupoCadastradoSemNome() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.isGrupoCadastrado(" ");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAlunoGrupoSemRestricao() {
        String msg = "ESPERANDO ALOCAÇÃO EM GRUPO REALIZADA COM SUCESSO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.alocarAluno("200", "Programação OO");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAlocarAlunoGrupoComRestricao1() {
        String msg = "ESPERANDO ALOCAÇÃO EM GRUPO REALIZADA";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.alocarAluno("250", "Listas");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAlocarAlunoGrupoComRestricao2() {
        String msg = "ESPERANDO GRUPO COM RESTRIÇÃO";
        boolean expected = false;
        boolean actual = this.sistemaAlunos.alocarAluno("201", "Listas");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAlocarAlunoMatriculaNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.alocarAluno(null, "Listas");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAlunoGrupoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.alocarAluno("200", null);
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAlunoSemMatricula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.alocarAluno(" ", "Programação OO");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAlunoGrupoSemNome() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.alocarAluno("200", " ");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAlunoNaoCadastrado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.alocarAluno("119", "Listas");
        });

        String expectedMessage = "ALUNO NÃO CADASTRADO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAlunoGrupoNaoCadastrado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.alocarAluno("250", "Batatas");
        });

        String expectedMessage = "GRUPO NÃO CADASTRADO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsParticipanteGrupo() {
        String msg = "ESPERANDO QUE ALUNA SEJA PARTICIPANTE";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.isParticipanteGrupo("Programação OO", "202");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsNotParticipanteGrupo() {
        String msg = "ESPERANDO QUE ALUNO NÃO SEJA PARTICIPANTE";
        boolean unexpected = true;
        boolean actual = this.sistemaAlunos.isParticipanteGrupo("Programação OO", "200");
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testIsParticipanteGrupoMatriculaNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.isParticipanteGrupo("Programação OO", null);
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsParticipanteGrupoNomeGrupoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.isParticipanteGrupo(null, "200");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsParticipanteGrupoSemMatricula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.isParticipanteGrupo("Programação OO", "   ");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsParticipanteGrupoSemNomeGrupo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.isParticipanteGrupo("   ", "200");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsParticipanteGrupoAlunoNaoCadastrado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.isParticipanteGrupo("Programação OO", "199");
        });

        String expectedMessage = "ALUNO NÃO CADASTRADO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsParticipanteGrupoGrupoNaoCadastrado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.isParticipanteGrupo("Batatas-UFCG", "200");
        });

        String expectedMessage = "GRUPO NÃO CADASTRADO";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testRegistrarAluno() {
        String msg = "ESPERANDO QUE ALUNO SEJA REGISTRADO COM SUCESSO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.registrarAluno("250");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testRegistrarAlunoNaoCadastrado() {
        String msg = "ESPERANDO QUE ALUNO NÃO SEJA REGISTRADO";
        boolean expected = false;
        boolean actual = this.sistemaAlunos.registrarAluno("119");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testRegistrarAlunoRegistrado() {
        String msg = "ESPERANDO QUE ALUNO SEJA REGISTRADO COM SUCESSO";
        boolean expected = true;
        boolean actual = this.sistemaAlunos.registrarAluno("201");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testRegistrarAlunoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.registrarAluno(null);
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testRegistrarAlunoSemMatricula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.registrarAluno("   ");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testContabilizarRestricao1() {
        String msg = "ESPERANDO QUANTIDADE DE GRUPOS COM UM DETERMINADO CURSO COMO RESTRICAO DE ENTRADA";
        int expected = 1;
        int actual = this.sistemaAlunos.contabilizarRestricao("Computação");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testContabilizarRestricao2() {
        String msg = "ESPERANDO GRUPOS SEM DETERMINADO CURSO COMO RESTRICAO DE ENTRADA";
        int expected = 0;
        int actual = this.sistemaAlunos.contabilizarRestricao("Anatomia");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testContabilizarRestricaoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            this.sistemaAlunos.contabilizarRestricao(null);
        });

        String expectedMessage = "CURSO INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testContabilizarRestricaoCursoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.sistemaAlunos.contabilizarRestricao("    ");
        });

        String expectedMessage = "CURSO INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}