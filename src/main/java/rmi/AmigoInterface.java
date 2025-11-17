package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Amigo;

public interface AmigoInterface extends Remote {
    /* Cadastra um novo amigo no sistema. */
    void cadastrarAmigo(Amigo amigo) throws RemoteException;
    /*Atualiza os dados de um amigo existente. */
    void atualizarAmigo(Amigo amigo) throws RemoteException;
    /*Exclui um amigo com base em seu identificador único. */
    void excluirAmigo(int id) throws RemoteException;
    /*Busca um amigo por seu ID. */
    Amigo buscarAmigoPorId(int id) throws RemoteException;
    /*Lista todos os amigos cadastrados no sistema. */
    List<Amigo> listarAmigos() throws RemoteException;
}
