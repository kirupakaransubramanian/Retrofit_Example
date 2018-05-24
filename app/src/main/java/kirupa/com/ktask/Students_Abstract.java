package kirupa.com.ktask;

/**
 * Created by kirupa on 18/4/18.
 */


public abstract class Students_Abstract extends SecondAbstract
{
    public void name()              // concrete (non-abstract) method
    {
        System.out.println("Name is Kirupa");
    }
    public void marks()             // concrete (non-abstract) method
    {
        System.out.println("Marks scored are 80");
    }
    public static void main(String args[])
    {

//        System.out.println("Main");
//
//        Students_Abstract s1 = new Students_Abstract();   // Error raised, see the errror in screenshot
//        s1.name();
//        s1.marks();
    }
}