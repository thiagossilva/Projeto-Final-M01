package tech.devinhouse.labschoolapi1.exception;

public class RegistroNaoEncontradoException extends RuntimeException{
    public RegistroNaoEncontradoException(String nomeRecurso, Integer idRecurso) {
        super(nomeRecurso + " com identificador " + idRecurso + " não encontrado");
    }
}
