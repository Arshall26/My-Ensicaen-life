package fr.ensicaen.ecole.genielogiciel.model;

import java.io.IOException;

public class ProxyServerModel implements IServerModel{
    private IServerModel _server;
    public Float parseSalary() throws IOException{
        if (_server == null){
            _server = new ServerModel();
        }
        return _server.parseSalary();
    }
}
