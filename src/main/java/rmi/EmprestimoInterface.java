package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import modelo.Emprestimo;

// Interface remota para operações relacionadas a empréstimos,
// utilizada pelo RMI para permitir chamadas remotas entre cliente e servidor.
public interface EmprestimoInterface extends Remote {

    // Registra um novo empréstimo no sistema.
    void registrarEmprestimo(Emprestimo emprestimo) throws RemoteException;

    // Marca a devolução de uma ferramenta referente ao empréstimo informado.
    void devolverFerramenta(int emprestimoId) throws RemoteException;

    // Retorna uma lista com todos os empréstimos cadastrados.
    List<Emprestimo> listarEmprestimos() throws RemoteException;

    // Busca todos os empréstimos associados a um amigo específico.
    List<Emprestimo> buscarEmprestimosPorAmigo(int amigoId) throws RemoteException;
}
