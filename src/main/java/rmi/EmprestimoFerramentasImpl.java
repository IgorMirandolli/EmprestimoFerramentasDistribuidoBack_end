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