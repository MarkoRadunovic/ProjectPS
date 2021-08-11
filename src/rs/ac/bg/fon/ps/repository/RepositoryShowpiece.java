/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Showpiece;

/**
 *
 * @author Korisnik
 */
public class RepositoryShowpiece {
    private final List<Showpiece> showpieces;

    public RepositoryShowpiece() {
        this.showpieces = new ArrayList<Showpiece>();
    }
    
    public void add(Showpiece showpiece){
        showpieces.add(showpiece);
    }

    public List<Showpiece> getShowpieces() {
        return showpieces;
    }

    public void delete(Showpiece showpiece) throws Exception {
        int index = showpieces.indexOf(showpiece);
        if(index>=0){
        showpieces.remove(index);
        }else{
            throw new Exception("Error!");
        }
        
    }
    
    
    
}
