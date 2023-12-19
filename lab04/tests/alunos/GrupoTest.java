package alunos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    private Grupo ufcg;
    private Grupo ufcgArq;
    private Aluno aluno;
    private Aluno aluna;

    @BeforeEach
    void preparaGrupo() {
        this.ufcg = new Grupo("UFCG", "");
        this.aluno = new Aluno("Alexandre Corlet", "119", "Computação");
        this.aluna = new Aluno("Mariana Barbosa", "120", "Arquitetura");
        this.ufcgArq = new Grupo("UFCG-ARQUITETURA", "Arquitetura");
    }

    @Test
    void grupoNomeNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            new Grupo(null, "teste");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void grupoNomeSemNome() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Grupo(" ", "teste");
        });

        String expectedMessage = "NOME INVÁLIDO";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void grupoRestricaoNull() {
        Exception exception = assertThrows(InputMismatchException.class, () -> {
            new Grupo("FERAS-CC", null);
        });

        String expectedMessage = "RESTRIÇÃO INVÁLIDA";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testAlocarAluno() {
        String msg = "ESPERANDO QUE ALOCAÇÃO SEJA REALIZADA";
        boolean expected = true;
        boolean actual = this.ufcg.alocarAluno(this.aluno);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testIsParticipante() {
        String msg = "ESPERANDO QUE ALUNO SEJA PARTICIPANTE";
        ufcg.alocarAluno(this.aluno);
        boolean expected = true;
        boolean actual = this.ufcg.isParticipante(this.aluno);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testNaoEhParticipante() {
        String msg = "ESPERANDO QUE NÃO SEJA PARTICIPANTE";

        boolean expected = false;
        boolean actual = this.ufcg.isParticipante(this.aluna);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testEquals() {
        String msg = "ESPERANDO QUE GRUPOS SEJAM IGUAIS";
        boolean expected = true;
        boolean actual = this.ufcg.equals(this.ufcg);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testNotEquals() {
        String msg = "ESPERANDO QUE GRUPOS SEJAM DIFERENTES";
        boolean unexpected = true;
        boolean actual = this.ufcg.equals(this.ufcgArq);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testNotEqualsNull() {
        String msg = "ESPERANDO QUE GRUPO NÃO SEJA IGUAL AO NULL";
        boolean unexpected = true;
        boolean actual = this.ufcg.equals(null);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testEqualsClassesDiferentes() {
        String msg = "ESPERANDO QUE SEJA DIFERENTE";
        boolean unexpected = true;
        boolean actual = this.ufcg.equals(1);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testHashCode() {
        String msg = "ESPERANDO QUE HASH SEJA IGUAL";

        Grupo ufcg1 = new Grupo("UFCG", "");

        boolean expected = true;
        boolean actual = (ufcg1.equals(this.ufcg) && this.ufcg.equals(ufcg1)) &&
                (ufcg1.hashCode() == this.ufcg.hashCode());

        assertEquals(expected, actual, msg);
    }
}