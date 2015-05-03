package Model;

import java.util.LinkedList;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class SQLTESTER {

   public SQLTESTER(){

        ApplicationUser aa = new ApplicationUser();
        Termin bb = new Termin();
       Sonnenbank cc = new Sonnenbank();

        LinkedList<ApplicationUserObject> obj1  =  aa.getAllApplicationUser();
        LinkedList<TerminObject> obj2  =  bb.getAllTermin();
        LinkedList<SonnenbankObject> obj3  =  cc.getAllSonnenbank();


       int a = 0;
    }


}
