package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Ferramenta;

// Interface remota para operação de CRUD de ferramentas
public interface FerramentaInterface extends Remote {
    
    // Cadastra nova ferranebta
    void cadastrarFerramenta(Ferramenta ferramenta) throws RemoteException;
    
    // Atualiza ferramenta ja existente
    void atualizarFerramenta(Ferramenta ferramenta) throws RemoteException;
    
    // Exclui ferramenta pelo ID
    void excluirFerramenta(int id) throws RemoteException;
    
    // Busca ferramenta pelo ID
    Ferramenta buscarFerramentaPorId(int id) throws RemoteException;
    
    //Lista todas as ferramentas cadastradas
    List<Ferramenta> listarFerramentas() throws RemoteException;
}
