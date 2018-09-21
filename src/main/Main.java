/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
    import models.ModelBloc;
    import views.ViewBlocNotas;
    import controllers.ControllerBloc;
    

/**
 *
 * @author Octaviano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelBloc modelBloc = new ModelBloc();
        ViewBlocNotas viewBlocNotas=new ViewBlocNotas();
        ControllerBloc controllerBloc=new ControllerBloc(modelBloc,viewBlocNotas);
    }
    
}
