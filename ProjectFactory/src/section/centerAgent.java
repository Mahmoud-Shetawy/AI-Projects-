package section;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import javax.swing.*;
import java.util.Scanner;

import static section.customName.customN;
import static section.customName.customN1;
import static section.customName.customN2;
//////////// to enter any name
    class customName {
           public static String customN ;
          public static String customN1 ;
          public static String customN2 ;

}
public class centerAgent {



    public static void main( String[] args ) {


        Scanner input = new Scanner( System.in );


                jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl( "localhost" , 1000 , "Testplatform" );
        ContainerController containerController = runtime.createMainContainer( profile );
          //   runtime.setCloseVM( true );
        try {

            AgentController rma  = containerController.createNewAgent( "rma" , "jade.tools.rma.rma" , null );
            rma.start();

            customN=JOptionPane.showInputDialog( "Enter Your Name ,please! " );


            AgentController Factory  = containerController.createNewAgent( "factory" , "section.factory" , null );
            Factory.start();

            AgentController customName1 = containerController.createNewAgent( customN , "section.customes" , null );
            customName1.start();
            customN1=JOptionPane.showInputDialog( "Enter Your Name customer2 , please! " );
            AgentController customName2 = containerController.createNewAgent( customN1 , "section.customer2" , null );
            customName2.start();
            //customN1=JOptionPane.showInputDialog( "Enter Your Name customer3 , please! " );

           /* AgentController customName3 = containerController.createNewAgent( c
           ustomN2 , "section.customer3" , null );
            customName3.start();*/
        } catch ( StaleProxyException e ) {
            e.printStackTrace( );
        }
    }
}
