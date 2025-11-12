package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Amigo;

public interface AmigoInterface extends Remote {
    void cadastrarAmigo(Amigo amigo) throws RemoteException;
    void atualizarAmigo(Amigo amigo) throws RemoteException;
    void excluirAmigo(int id) throws RemoteException;
    Amigo buscarAmigoPorId(int id) throws RemoteException;
    List<Amigo> listarAmigos() throws RemoteException;
}
