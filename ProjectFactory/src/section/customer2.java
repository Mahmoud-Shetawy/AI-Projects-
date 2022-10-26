package section;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


import javax.swing.*;
import java.util.Scanner;
import java.util.jar.JarEntry;

public class customer2 extends Agent {

    Scanner input = new Scanner( System.in );
    String price ;



//
//public void customName() {
//    //*    send message ----> factory */
//
//}

/*public void readmessage(){

}*/

    public void sendmessage(String contct){

        ACLMessage message = new ACLMessage( );
        message.addReceiver( new AID( "Factory" , false ) );
        message.setContent( contct );
        // System.out.println("is you own moneyWallet ? " );
        message.setPerformative( ACLMessage.INFORM );
        send( message );
    }

    String product ;
    int Quantity;
    int step;
    boolean t=true , y =true;
    public void moneyWallet (){
        step=0;

        addBehaviour( new CyclicBehaviour( ) {
            @Override
            public void action() {

                ACLMessage aclMessage = receive( );
                if ( aclMessage != null ) {
                    String st = aclMessage.getContent( );
                    //  JOptionPane.showMessageDialog(null, st );
                    if ( step == 0 ) {


                        product = JOptionPane.showInputDialog( " Enter product is : " );
                        // System.out.print( " " );
                        String nn;
                        nn = JOptionPane.showInputDialog( "Enter Quantity of product  is :" );
                        Quantity = Integer.parseInt( nn );

                        sendmessage( Quantity + " of " + product );

                        step++;

                    }
                    System.out.println(step );
                    switch ( step  ) {
                        case 1:

                            price = JOptionPane.showInputDialog( st );


                            sendmessage( price );
                            step++;

                            break;

                        case 2:

                            String mag = JOptionPane.showInputDialog( st );
                            sendmessage( mag );
                            step++;

                            break;
/*                        case 3:
                                         System.out.println( st );
                                        JOptionPane.showMessageDialog( null , st );

                            step++;
                                    break;*/


                    }

                }
            }} );
    }



                    /*
                       // System.out.println( st );

                        addBehaviour( new CyclicBehaviour( ) {
                            @Override
                            public void action() {
                                ACLMessage aclMessage = receive();
                                if ( aclMessage != null){
                                    String st = aclMessage.getContent();
                                    System.out.println( st );
                                   //if ( st!=null && y ){
                                    String mag = input.next();
                                    //  System.out.println("mag" );
                                    sendmessage( mag);
                                  //  t=false;
                                   //}
                                   // System.out.println( st +"jk");


                                }
                            } });
                        //System.out.println("hhhjjh" );
                     //   step++;
                    }*/
/*if ( step==4 ){
                        addBehaviour( new CyclicBehaviour( ) {
                            @Override
                            public void action() {
                                ACLMessage aclMessage = receive();
                                if ( aclMessage != null){
                                    String st = aclMessage.getContent();
                                    System.out.println( st );
                                }
                            } });*/




  /*enter  product

System.out.print("please! Enter moneyWallet is : " );
                        int moneyWallet = input.nextInt();*/























    protected void setup(){
//        customName();
        moneyWallet();


    }

}
