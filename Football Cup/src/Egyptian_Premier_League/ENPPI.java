package Egyptian_Premier_League;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ENPPI  extends Agent {

protected void setup(){
    System.out.println("jhjhjjjjjj" );
    addBehaviour( new CyclicBehaviour( ) {
        @Override
        public void action() {
            ACLMessage st = receive();
            if ( st!=null ){
                String stri = st.getContent();
                System.out.println("ddddddm  "+stri );
            }
        }
    } );
}
}
