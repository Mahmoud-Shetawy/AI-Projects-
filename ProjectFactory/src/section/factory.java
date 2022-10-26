package section;

import jade.core.AID;
import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static section.customName.customN;
import static section.customName.customN1;
import static section.customName.customN2;

public class factory extends Agent {




    String  []products = { "A" , "B" , "C" };
    double  [] prices = { 30 , 60 , 120 };
    int  [] quantity = { 10 , 15 , 20 };

      /*  System.out.println( "products :" );
        for ( int i = 0 ; i < products.length ; i++ ) {
            System.out.println( "Product " + products[ i ] + " .price =" + prices[ i ] + "$ .Quantity =" + quantity[ i ] );

        }
*/

    public void sendMessage( String contct ){

        ACLMessage message = new ACLMessage( );

        message.addReceiver( new AID( customN , false ) );
        message.addReceiver( new AID( customN1 , false ) );
        // message.addReceiver( new AID( customN2 , false ) );
        message.setContent( contct );
        // System.out.println("is you own moneyWallet ? " );
        message.setPerformative( ACLMessage.INFORM );
        send( message );
    }










    String productName;
    boolean offerstate=true , t=true;
    int numberOfRequire , times =0 ,allMoney , of ,index ,freeTake=0;



    public void Receive() {
        times =0;
        addBehaviour( new CyclicBehaviour( ) {
                          @Override

                          public void action() {
                              ACLMessage aclMessage = receive( );
                              if ( aclMessage != null ) {
                                  String st = aclMessage.getContent( );

                                  if ( times == 0 ) {
                                      productName = st.substring( st.indexOf( "of" ) + 3 );

                                      of= Integer.parseInt( st.substring( 0 , st.indexOf( "of" ) - 1 ) );
                                      switch ( productName ) {
                                          case "A" -> {
                                              // quantity[ 0 ] = quantity[ 0 ] - of;
                                              index=0;
                                              //  System.out.println( quantity[ 0 ] );
                                          }
                                          case "B" -> {
                                              //quantity[ 1 ] = quantity[ 1 ] - of;
                                              index=1;
                                          }
                                          case "C" -> {
                                              //quantity[ 2 ] = quantity[ 2 ] - of;
                                              index=2;
                                          }
                                          default -> {
                                              JOptionPane.showMessageDialog( null,"Error!! The product not Found." );
                                              doDelete( );
                                          }

                                      }
                                      times++;
                                  } else if ( times == 1 ) {

                                      // System.out.println( "vvsvvsvsvsv" );
                                      //if ( t ){
                                          allMoney=Integer.parseInt( st );
                                          t=false;

                                     // }
                                      if ( quantity[ index ] > 0 && quantity[ index ] >= of  ) {

                                          // System.out.println( st );


                                          if ( allMoney>=(of* prices[index])) {
                                              quantity[index]-=of;

                                              JOptionPane.showMessageDialog( null, "Your purchase succeeded : sir "/*+getLocalName() */ );
                                              allMoney -= ( of * prices[ index ] );
                                              JOptionPane.showMessageDialog( null,"Mr: "+/*getAID(customN).getLocalName() */" your total money after the Buy = " + allMoney );
                                              for ( int i = 0 ; i<3;i++ ){
                                                  // prices[i] -= 2;
                                                  JOptionPane.showMessageDialog( null,"Product " + products[ i ] + " .price =" + prices[ i ] + "$ .Quantity =" + quantity[ i ]  );
                                                  //  sendMessage(  "Product " + products[ i ] + " .price =" + prices[ i ] + "$ .Quantity =" + quantity[ i ] );

                                              }

                                              times++;

                                              // sendMessage( "can buy any th" );



                                          } else {

                                              JOptionPane.showMessageDialog( null,"Your money not enough can you take product 2th " );
                                              while ( freeTake<2){
                                                  allMoney-=(of* prices[index]);

                                                  JOptionPane.showMessageDialog( null,"Please pay the rest of the money = "+(-1*allMoney) );
                                                  freeTake++;
                                              }
                                              Receive();
                                          }
                                      }else {

                                          sendMessage( "Product Executed Choose another product" );
                                          Receive();

//block();
                                      }


                                  }if ( times==2){
                                      sendMessage( "Want to see any offers?(Y , N)" );


                                      if ( st.equals( "Y" ) ){
                                          offer( 1 );
                                          // System.out.println("hghghggh" );

                                        Receive();

                                      }
                                    //  times=0;
                                     /* if ( st.equals( "Y" ) ){
                                         // System.out.println("hghghggh" );
                                          offer( 1 );

                                      }*/
                                  }
                                  /*System.out.println("The product custom Needs is  " + st );
                                   System.out.println( "the sender is "+aclMessage.getSender());
                                  System.out.println(numberOfRequire );
                                  System.out.println(poductName );*/

                              }
                             // times=0;
                          }
                      }
        );
    }






    public void Checkmoney() {

        // sendMessage( "is you own moneyWallet ? (Y , N )" );
        sendMessage(  "please! Enter moneyWallet is : " );

    }





    public void offer(int time) {
        time = time * 1000; // sec =1000
        //   System.out.println("hjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" );



        if ( offerstate ) {
            addBehaviour(new TickerBehaviour(this, time) {//180000

                @Override
                protected void onTick() {
//                System.out.println("Product prices update:");

                    if (offerstate) {
                        for (int i = 0; i < prices.length; i++) {
                            prices[i] = prices[i] - (prices[i] * .1);
                            // acl.setPerformative(ACLMessage.INFORM);
                            // acl.setContent( );
                            //send(acl);
                            JOptionPane.showMessageDialog( null,"Discount:\nProduct " + products[i] + " .price =" + prices[i] + "$\n" );
                        }
                        offerstate = false;

                    } else {

                        prices[0]=30;
                        prices[1]=60;
                        prices[2]=120;
                       // update();


                    }
                }

            });

//    }
        }
    }




    public void update(){
        addBehaviour( new TickerBehaviour(this,20000 ) {
            @Override
            protected void onTick() {
                JOptionPane.showMessageDialog( null,"can you see  new Update " );

                for ( int i = 0 ; i<3;i++ ){
                    prices[i] += 5;
                    //   System.out.println( "Product " + products[ i ] + " .price =" + prices[ i ] + "$ .Quantity =" + quantity[ i ] );
                    JOptionPane.showMessageDialog( null,"Product " + products[ i ] + " .price =" + prices[ i ] + "$ .Quantity =" + quantity[ i ] );

                }
//         block();
                // System.out.println( "Product " + products[ i ] + " .price =" + prices[ i ] + "$ .Quantity =" + quantity[ i ] );
            }
        } );

    }

    protected void setup() {
        JOptionPane.showMessageDialog( null, "Custom Name is :  " +getAID(customN).getLocalName() );

        //  System.out.println("Agent reciver" );

        Receive( );
        Checkmoney( );
        // offer( 3 );

         update();
        // doDelete();
    }


    protected void takeDown() {
        JOptionPane.showMessageDialog( null,"Agent killed " );
    }
}