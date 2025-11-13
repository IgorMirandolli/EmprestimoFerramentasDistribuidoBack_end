package rmi;

/**
 * Interface combinada que expõe todos os métodos remotos usados pelo cliente.
 * Ela estende as interfaces específicas para empréstimos, amigos e ferramentas.
 */
public interface EmprestimoFerramentasInterface extends EmprestimoInterface, AmigoInterface, FerramentaInterface {

}
