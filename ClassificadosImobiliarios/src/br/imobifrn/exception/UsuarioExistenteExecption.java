package br.imobifrn.exception;

public class UsuarioExistenteExecption extends Exception {
	private static final long serialVersionUID = 1L;

	public UsuarioExistenteExecption(String message) {
		super(message);
	}
}
