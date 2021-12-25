package gms.sda_ap.controller;

public class persistenceFactory {
    private static persistenceFactory pf;
    private persistenceFactory()
    {
        
    }

    public static persistenceFactory getInstance(){
        if(pf==null)
        {
            //pf = Persistence.createEntityManagerFactory();
        }
        return pf;
    }
}
