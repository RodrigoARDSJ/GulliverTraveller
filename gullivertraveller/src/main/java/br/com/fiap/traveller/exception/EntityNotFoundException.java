package br.com.fiap.traveller.exception;

public class EntityNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException() {
        super("Entidade n�o encontrada");
    }

    public EntityNotFoundException(String msg) {
        super(msg);
    }

}
