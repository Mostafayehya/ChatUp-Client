package eg.gov.iti.jets.io;

import clientInterface.ClientCallbacks;
import eg.gov.iti.jets.data.DataBaseConnection;
import eg.gov.iti.jets.services.implementations.*;
import services.*;


import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Server server;
    Registry registry;
    AuthenticationService authenticationService;
    UpdateService updateService;
    HandleContactsService handleContactsService;
    SingleChatService singleChatService;
    GroupChatService groupChatService;
    //list of onlineClients
    Map<String, ClientCallbacks> onlineClients;
    DataBaseConnection databaseConnection;

    private Server() {
        onlineClients = new HashMap<>();
        try {

            registry = LocateRegistry.createRegistry(8189);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Server getInstance() {
        if (server == null)
            server = new Server();
        return server;
    }


    //use in login
    public void addClient(String phoneNumber, ClientCallbacks clientImpl) {
        onlineClients.put(phoneNumber, clientImpl);
        System.out.println("User: " + phoneNumber + " was added to online ");

    }

    //use in signOut or exit
    public void removeClient(String phoneNumber) {
        onlineClients.remove(phoneNumber);
    }

    public void stopServer() {
        for (Map.Entry<String, ClientCallbacks> entry : onlineClients.entrySet()) {
            try {
                entry.getValue().closeApp();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        databaseConnection.closeConnection();
        try {
            registry.unbind("AuthenticationService");
            registry.unbind("HandleContactService");
            registry.unbind("SingleChatService");
            registry.unbind("UpdateService");
            registry.unbind("GroupChatService");
            UnicastRemoteObject.unexportObject(updateService, true);
            UnicastRemoteObject.unexportObject(authenticationService, true);
            UnicastRemoteObject.unexportObject(handleContactsService, true);
            UnicastRemoteObject.unexportObject(singleChatService, true);
            UnicastRemoteObject.unexportObject(groupChatService, true);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, ClientCallbacks> getOnlineClients() {
        return onlineClients;
    }

    public void startServer() {
        onlineClients = new HashMap<>();
        databaseConnection = DataBaseConnection.getInstance();
        try {
            authenticationService = new AuthenticationServiceImpl();
            handleContactsService = new HandleContactServiceImpl();
            singleChatService = new SingleChatServiceImpl();
            updateService = new UpdateServiceImpl();
            groupChatService = new GroupChatServiceImpl();
            registry = LocateRegistry.getRegistry(8189);
            registry.bind("SingleChatService", singleChatService);
            registry.bind("AuthenticationService", authenticationService);
            registry.bind("HandleContactService", handleContactsService);
            registry.bind("UpdateService", updateService);
            registry.bind("GroupChatService",groupChatService);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
