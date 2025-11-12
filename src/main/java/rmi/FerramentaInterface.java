package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Ferramenta;

public interface FerramentaInterface extends Remote {
    void cadastrarFerramenta(Ferramenta ferramenta) throws RemoteException;
    void atualizarFerramenta(Ferramenta ferramenta) throws RemoteException;
    void excluirFerramenta(int id) throws RemoteException;
    Ferramenta buscarFerramentaPorId(int id) throws RemoteException;
    List<Ferramenta> listarFerramentas() throws RemoteException;
}
