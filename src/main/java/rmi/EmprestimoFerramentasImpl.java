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

/**
 * Implementação remota do serviço de empréstimo de ferramentas.
 * 
 * Esta classe expõe os métodos definidos na interface EmprestimoFerramentasInterface
 * utilizando RMI, permitindo operações CRUD para Amigo, Ferramenta e Empréstimo.
 */
public class EmprestimoFerramentasImpl extends UnicastRemoteObject implements EmprestimoFerramentasInterface {

    private AmigoDAO amigoDAO;
    private FerramentaDAO ferramentaDAO;
    private EmprestimoDAO emprestimoDAO;

    /**
     * Construtor padrão que instancia os DAOs utilizados.
     * 
     * @throws RemoteException se houver falha na comunicação remota.
     */
    public EmprestimoFerramentasImpl() throws RemoteException {
        super();
        this.amigoDAO = new AmigoDAO();
        this.ferramentaDAO = new FerramentaDAO();
        this.emprestimoDAO = new EmprestimoDAO();
    }
    
    // -----------------------------
    //        MÉTODOS AMIGO
    // -----------------------------

    /**
     * Cadastra um novo amigo atribuindo um novo ID.
     *
     * @param amigo objeto Amigo a ser salvo.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void cadastrarAmigo(Amigo amigo) throws RemoteException {
        amigo.setIdAmigo(amigoDAO.maiorIDAmigo() + 1);
        amigoDAO.insertAmigoBD(amigo);
    }

    /**
     * Atualiza os dados de um amigo existente.
     *
     * @param amigo objeto Amigo com dados atualizados.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void atualizarAmigo(Amigo amigo) throws RemoteException {
        amigoDAO.updateAmigoBD(amigo);
    }

    /**
     * Exclui um amigo pelo ID.
     *
     * @param id identificador do amigo.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void excluirAmigo(int id) throws RemoteException {
        amigoDAO.deleteAmigoBD(id);
    }

    /**
     * Busca um amigo pelo ID.
     *
     * @param id identificador do amigo.
     * @return Amigo encontrado ou null.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public Amigo buscarAmigoPorId(int id) throws RemoteException {
        return amigoDAO.RecuperaAmigoBD(id);
    }

    /**
     * Lista todos os amigos cadastrados.
     *
     * @return lista de amigos.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public List<Amigo> listarAmigos() throws RemoteException {
        return amigoDAO.getListaAmigo();
    }
    
    // -----------------------------
    //      MÉTODOS FERRAMENTA
    // -----------------------------

    /**
     * Cadastra uma nova ferramenta atribuindo um novo ID.
     *
     * @param ferramenta objeto Ferramenta a ser salvo.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void cadastrarFerramenta(Ferramenta ferramenta) throws RemoteException {
        ferramenta.setIdFerramentas(ferramentaDAO.MaiorIdFerramentas() + 1);
        ferramentaDAO.InsertFerramentaDB(ferramenta);
    }

    /**
     * Atualiza os dados de uma ferramenta existente.
     *
     * @param ferramenta objeto Ferramenta atualizado.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void atualizarFerramenta(Ferramenta ferramenta) throws RemoteException {
        ferramentaDAO.UpdateFerramentaDB(ferramenta);
    }

    /**
     * Exclui uma ferramenta pelo ID.
     *
     * @param id identificador da ferramenta.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void excluirFerramenta(int id) throws RemoteException {
        ferramentaDAO.DeleteFerramentaDB(id);
    }

    /**
     * Busca uma ferramenta pelo ID.
     *
     * @param id identificador da ferramenta.
     * @return Ferramenta encontrada ou null.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public Ferramenta buscarFerramentaPorId(int id) throws RemoteException {
        return ferramentaDAO.RecuperaFerramentaDB(id);
    }

    /**
     * Lista todas as ferramentas cadastradas.
     *
     * @return lista de ferramentas.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public List<Ferramenta> listarFerramentas() throws RemoteException {
        return ferramentaDAO.getListaFerramentas();
    }

    // -----------------------------
    //       MÉTODOS EMPRÉSTIMO
    // -----------------------------

    /**
     * Registra um novo empréstimo atribuindo um ID automaticamente.
     *
     * @param emprestimo objeto Emprestimo contendo os dados.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void registrarEmprestimo(Emprestimo emprestimo) throws RemoteException {
        emprestimo.setIdEmprestimo(emprestimoDAO.maiorIDEmprestimo() + 1);
        emprestimoDAO.insertEmprestimoBD(emprestimo);
    }

    /**
     * Registra a devolução de uma ferramenta atualizando a data de devolução.
     *
     * @param emprestimoId identificador do empréstimo.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public void devolverFerramenta(int emprestimoId) throws RemoteException {
        Emprestimo emprestimo = emprestimoDAO.RecuperaEmprestimoDB(emprestimoId);
        if (emprestimo != null) {
            emprestimo.setDataDev(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
            emprestimoDAO.updateEmprestimoBD(emprestimo);
        }
    }

    /**
     * Lista todos os empréstimos realizados.
     *
     * @return lista de empréstimos.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public List<Emprestimo> listarEmprestimos() throws RemoteException {
        return emprestimoDAO.getListaEmprestimo();
    }

    /**
     * Filtra os empréstimos realizados por um amigo específico.
     *
     * @param amigoId identificador do amigo.
     * @return lista de empréstimos do amigo.
     * @throws RemoteException caso ocorra erro remoto.
     */
    @Override
    public List<Emprestimo> buscarEmprestimosPorAmigo(int amigoId) throws RemoteException {
        List<Emprestimo> todosEmprestimos = emprestimoDAO.getListaEmprestimo();
        List<Emprestimo> emprestimosDoAmigo = new ArrayList<>();
        
        for (Emprestimo emp : todosEmprestimos) {
            if (emp.getIdAmigo() == amigoId) {
                emprestimosDoAmigo.add(emp);
            }
        }
        return emprestimosDoAmigo;
    }
}
