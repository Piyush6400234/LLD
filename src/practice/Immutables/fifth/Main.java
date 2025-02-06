package practice.Immutables.fifth;

import practice.Immutables.fifth.consumer.specific.ChildClass;
import practice.Immutables.fifth.finalExplored.BaseClass;
import practice.Immutables.fifth.util.Logger;

public class Main {
    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();

        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("--------------------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("--------------------------------");
        child.recommendedMethod();

        System.out.println("---------------------------------------------------------------------------------");


        parent.recommendedStatic();
        System.out.println("--------------------------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("--------------------------------");
        child.recommendedStatic();

        System.out.println("--------------------------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only thi ssection ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After Method, xArgument "+ xArgument);
        System.out.println("After the method "+ zArgument);

        System.out.println("-------".repeat(5));
        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = "+tracker);

    }

    private static void doXYZ(String x , int y, final StringBuilder z){
        final String c = x+y;
        System.out.println("c= "+c);
        x = c;
        z.append(y);

//        z = new StringBuilder("This is a new refernece");
    }
}
