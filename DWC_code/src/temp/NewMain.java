/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
class df {
public Integer it;            
        }        
        long lt = 15;
        System.out.println(lt);
        ArrayList<df> it = new ArrayList<>();
        df a = new df(),b=new df(),c=new df(),d=new df(),e=new df();
        a.it = 12;
        b.it = 12;c.it = 12;d.it = 12;e.it = 12;
        it.add(a);
         it.add(b); it.add(c); it.add(d); it.add(e);
        for(df f : it){
            System.out.println(f.it);
        f.it = 13;
        }
        System.out.println("After change!!");
        for(df g : it){
            System.out.println(g.it);
        
        }
        ArrayList<Integer> ighj = new ArrayList<>();
        ighj.add(2);ighj.add(62);ighj.add(52);ighj.add(42);ighj.add(32);
        System.out.println("All at once");
        String str = ighj.toString();
        System.out.println(str);
    }
}
