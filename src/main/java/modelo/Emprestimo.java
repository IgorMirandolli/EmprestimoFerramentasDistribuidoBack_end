package modelo;

import dao.EmprestimoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Classe do empréstimo, com IdEmprestimo, IdAmigo, IdFerramentas, dataEmp.
 */
public class Emprestimo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private int IdEmprestimo;
    private int IdAmigo;
    private int IdFerramentas;
    private String dataEmp;
    private String dataDev;
    private transient EmprestimoDAO dao;

/**
* Construtor para a classe Emprestimo, inicializa o empréstimo com IdAmigo do amigo, id da ferramenta e data do emprestimo.
*/
    public Emprestimo() {
        this(0, 0, 0, "", "");
    }

/**
* @param IdEmprestimo; Id do empréstimo feito.
* @param IdAmigo; Nome do amigo fazendo o empréstimo.
* @param IdFerramentas; Id da ferramenta emprestada.
* @param dataEmp; Data do empréstimo
*/
