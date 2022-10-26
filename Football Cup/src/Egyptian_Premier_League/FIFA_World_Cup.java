package Egyptian_Premier_League;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import org.w3c.dom.ls.LSOutput;

public class FIFA_World_Cup  extends Agent {
        protected  void setup(){
            ACLMessage aclMessage = new ACLMessage(  );
            aclMessage.addReceiver( new AID( "ENPPI" ,false ) );
            aclMessage.setContent( "Welcom " );
            aclMessage.setPerformative( ACLMessage.INFORM );
            send( aclMessage );
        }
}
