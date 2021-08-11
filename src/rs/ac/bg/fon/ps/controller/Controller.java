/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.util.List;
import rs.ac.bg.fon.ps.domain.Showpiece;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.ps.repository.RepositoryShowpiece;
import rs.ac.bg.fon.ps.repository.RepositoryUser;

/**
 *
 * @author Korisnik
 */
public class Controller {
    
    private final RepositoryUser repositoryUser;
    private final RepositoryShowpiece repositoryShowpiece;

    private static Controller controller;
    
    private Controller() {
        this.repositoryUser = new RepositoryUser();
        this.repositoryShowpiece = new RepositoryShowpiece();
    }
    
    public User login (String username, String password) throws Exception{
        List<User> users = repositoryUser.getUsers();
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new Exception("Unknown user!");
    }
    
    public static Controller getInstance(){
        if(controller==null) controller = new Controller();
        return controller;
    }
    
    public void addShowpiece(Showpiece showpiece){
        repositoryShowpiece.add(showpiece);
    }

    public List<Showpiece> getAllShowpieces() {
        return repositoryShowpiece.getShowpieces();
    }

    public void deleteShowpiece(Showpiece showpiece) throws Exception {
        repositoryShowpiece.delete(showpiece);
    }
    
    
    
}
