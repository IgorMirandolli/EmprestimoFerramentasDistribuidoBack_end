package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Emprestimo;

public interface EmprestimoInterface extends Remote {
    void registrarEmprestimo(Emprestimo emprestimo) throws RemoteException;
    void devolverFerramenta(int emprestimoId) throws RemoteException;
    List<Emprestimo> listarEmprestimos() throws RemoteException;
    List<Emprestimo> buscarEmprestimosPorAmigo(int amigoId) throws RemoteException;
}
