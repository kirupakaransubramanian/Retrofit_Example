package kirupa.com.ktask;

import android.util.Log;

// File Name: Singleton.java
public class Singleton {

   private static Singleton singleton = new Singleton( );
    String kkk="kirupa";

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private Singleton() {

      Log.d("Singleton","constructor");
   }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {

      Log.d("Singleton","getInstance");

      return singleton;
   }


   /* Other methods protected by singleton-ness */
   protected static void demoMethod( ) {
      Log.d("Singleton","demoMethod for singleton");

   }

    /* Other methods protected by singleton-ness */
    protected static void demoMethod1( ) {
        Log.d("Singleton","demoMethod1 for singleton");

    }
}