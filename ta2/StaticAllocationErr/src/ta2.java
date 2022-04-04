// Java program to demonstrate the above example
 
public class ta2 {
    private String name;
    private static int number = 3;
 
    ta2(String name)
    {
        this.name = name;
        number++;
    }
 
    public void fly()
    {
        System.out.println("This bird flies");
    }
 
    public int getNumber()
    {
        return number;
    }
 
    public String getName()
    {
        return name;
    }

 

    public static void main(String args[])
    {
    	ta2 b1 = new ta2("Parrot");
    	ta2 b2 = new ta2("Sparrow");
    	ta2 b3 = new ta2("Pigeon");
 
        System.out.println(b1.getNumber());
    }
}