package gms.sda_ap;

import javax.persistence.Persistence;

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
