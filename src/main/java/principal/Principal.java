package principal;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.EmprestimoFerramentasImpl;

public class Principal {

    private static final Logger LOGGER = Logger.getLogger(Principal.class.getName());
    private static final int[] PORTAS_RMI = {1099, 1098, 1097, 1096, 1095};

    private static Registry iniciarRegistro() throws RemoteException {
        Registry registry = null;
        RemoteException lastException = null;

        for (int porta : PORTAS_RMI) {
            try {
                registry = LocateRegistry.createRegistry(porta);
                LOGGER.info("Servidor RMI iniciado na porta " + porta);
                System.out.println("Servidor RMI em execução na porta " + porta);
                return registry;
            } catch (RemoteException e) {
                lastException = e;
                LOGGER.warning("Porta " + porta + " em uso, tentando próxima porta...");
                System.out.println("Porta " + porta + " em uso, tentando próxima porta...");
            }
        }

        if (lastException != null) {
            throw new RemoteException("Não foi possível iniciar o servidor RMI em nenhuma porta", lastException);
        }
        return registry;
    }

    public static void main(String[] args) {
        try {
            // Criar e exportar o objeto remoto
            EmprestimoFerramentasImpl obj = new EmprestimoFerramentasImpl();

            // Criar e iniciar o registro RMI
            Registry registry = iniciarRegistro();

            // Registrar o objeto remoto com um nome
            registry.rebind("EmprestimoFerramentas", obj);

            // Mantém o servidor rodando
            Thread.currentThread().join();

        } catch (RemoteException e) {
            LOGGER.log(Level.SEVERE, "Erro ao iniciar servidor RMI", e);
            System.err.println("Erro ao iniciar servidor RMI: " + e.getMessage());
            System.exit(1);
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARNING, "Servidor RMI interrompido", e);
            System.err.println("Servidor RMI interrompido: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
