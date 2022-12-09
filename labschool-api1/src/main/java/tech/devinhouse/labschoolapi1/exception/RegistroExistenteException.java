package tech.devinhouse.labschoolapi1.exception;

public class RegistroExistenteException extends RuntimeException{
    public RegistroExistenteException(String nomeRecurso, Integer idRecurso) {
        super(nomeRecurso + " com identificador " + idRecurso +  " já existente");
    }
}
