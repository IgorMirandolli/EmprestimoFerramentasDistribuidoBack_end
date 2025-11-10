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
