package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;
import dao.AmigoDAO;
import dao.FerramentaDAO;
import dao.EmprestimoDAO;
import modelo.Amigo;
import modelo.Ferramenta;
import modelo.Emprestimo;

public class EmprestimoFerramentasImpl extends UnicastRemoteObject implements EmprestimoFerramentasInterface {
    private AmigoDAO amigoDAO;
    private FerramentaDAO ferramentaDAO;
    private EmprestimoDAO emprestimoDAO;

    public EmprestimoFerramentasImpl() throws RemoteException {
        super();
        this.amigoDAO = new AmigoDAO();
        this.ferramentaDAO = new FerramentaDAO();
        this.emprestimoDAO = new EmprestimoDAO();
    }
    
    // Implementações para Amigo
    @Override
    public void cadastrarAmigo(Amigo amigo) throws RemoteException {
        amigo.setIdAmigo(amigoDAO.maiorIDAmigo() + 1);
        amigoDAO.insertAmigoBD(amigo);
    }

    @Override
    public void atualizarAmigo(Amigo amigo) throws RemoteException {
        amigoDAO.updateAmigoBD(amigo);
    }

    @Override
    public void excluirAmigo(int id) throws RemoteException {
        amigoDAO.deleteAmigoBD(id);
    }
    
        @Override
    public Amigo buscarAmigoPorId(int id) throws RemoteException {
        return amigoDAO.RecuperaAmigoBD(id);
    }
        @Override
    public List<Amigo> listarAmigos() throws RemoteException {
        return amigoDAO.getListaAmigo();
    }
    
// Implementações para Ferramenta
        @Override
    public void cadastrarFerramenta(Ferramenta ferramenta) throws RemoteException {
        ferramenta.setIdFerramentas(ferramentaDAO.MaiorIdFerramentas() + 1);
        ferramentaDAO.InsertFerramentaDB(ferramenta);
    }
    
        @Override
    public void atualizarFerramenta(Ferramenta ferramenta) throws RemoteException {
        ferramentaDAO.UpdateFerramentaDB(ferramenta);
    }
    