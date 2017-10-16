
import java.io.File;
import java.rmi.*;
import java.util.ArrayList;

public interface interface_servidor extends Remote {
	public String criar_arquivo(String arquivo) throws RemoteException;
	public String apagar_arquivo(String nome) throws RemoteException;
	public String copiar_arquivo(String arquivo, String novo) throws RemoteException;
	public String escrever_arquivo(String nome, String texto) throws RemoteException;
	public ArrayList<String> ler_arquivo(String nome) throws RemoteException;
}