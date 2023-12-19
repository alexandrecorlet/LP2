package alunos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;
    private Aluno aluna;

    @BeforeEach
    void preparaAlunos() {
        this.aluno = new Aluno("Alexandre Corlet", "119", "Computação");
        this.aluna = new Aluno("Mariana Barbosa", "120", "Arquitetura");
    }

    @Test
    void alunoNomeNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            new Aluno(null, "119", "Computação");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void alunoMatriculaNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            new Aluno("Obi-Wan", null, "Computação");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void alunoCursoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            new Aluno("Obi-Wan", "119", null);
        });

        String expectedMessage = "CURSO INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void alunoSemNome() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno("   ", "119", "Jedi");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void alunoSemMatricula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno("Anakin", " ", "Jedi");
        });

        String expectedMessage = "MATRÍCULA INVÁLIDA";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void alunoSemCurso() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno("Anakin", "199", "  ");
        });

        String expectedMessage = "CURSO INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testEqualsReflexivo() {
        String msg = "ESPERANDO QUE SEJA IGUAL";
        boolean expected = true;
        boolean actual = this.aluno.equals(this.aluno);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testNotEquals() {
        String msg = "ESPERANDO QUE ALUNOS SEJAM DIFERENTES";
        boolean unexpected = true;
        boolean actual = this.aluno.equals(this.aluna);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testNotEqualsNull() {
        String msg = "ESPERANDO QUE ALUNO SEJA DIFERENTE DE NULL";
        boolean unexpected = true;
        boolean actual = this.aluno.equals(null);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testEqualsClassesDiferentes() {
        String msg = "ESPERANDO QUE SEJAM DIFERENTES";
        boolean unexpected = true;
        boolean actual = this.aluno.equals(1);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testHashCode() {
        String msg = "ESPERANDO QUE ALUNAS SEJAM IGUAIS";
        Aluno aluna1 = new Aluno("Mariana Barbosa", "120", "Arquitetura");
        boolean expected = true;
        boolean actual = (aluna1.hashCode() == this.aluna.hashCode()) &&
                        aluna1.equals(this.aluna) && this.aluna.equals(aluna1);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAlunoToString() {
        String msg = "ESPERANDO DADOS DO ALUNO";
        String expected = "Aluno: 119 - Alexandre Corlet - Computação";
        String actual = this.aluno.toString();
        assertEquals(expected, actual, msg);
    }
}