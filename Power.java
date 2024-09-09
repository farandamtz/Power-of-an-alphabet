import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
public class Power{
    //Función del problema 1
    public static String[] concatenarAlfabetos(String L1[], String L2[]){
        BiFunction<String, String, String>concatenar=(l1, l2)->l1+l2;
        List <String> conc=new ArrayList<>();
        if(L1.length==0||L2.length==0)
            System.out.println("\0");
        else{
            for(String s1:L1){
                for(String s2:L2)
                    conc.add(concatenar.apply(s1,s2));
            }
        }
        return conc.toArray(new String [conc.size()]);
    }

    //Función del problema 2
    public static String[] potenciaAlfabeto(String L[], int n){
        String potencia[]={""};
        if(L.length==0)
            System.out.print("\n0");
        else{
            System.out.print("\nL^0=");
            imprimirAlfabeto(potencia);
            for(int i=0; i<n; i++){
                potencia=concatenarAlfabetos(potencia, L);
                System.out.print("\nL^"+(i+1)+"=");
                imprimirAlfabeto(potencia);
            }
        }
        return potencia;
    }

    //Imprimir un alfabeto
    public static void imprimirAlfabeto(String[] L){
        if(L.length==0)
            System.out.print("0");
        else{
            for(int k=0; k<L.length; k++)
                System.out.print("'"+L[k]+"' ");
        }
    }

    public static void main(String[] args) throws Exception{
        int n=3;
        String conc[], pot[];
        pot=new String[(int) Math.pow(2,n)];
        String L[]={"10", "11", "00"};
        String L1[]={"aa", "ab", "ba", "bb"};
        String L2[]={"M", "N", "NM", "MN"};
        System.out.print("******Concatenación de alfabetos******\nL1:");
        imprimirAlfabeto(L1);
        System.out.print("\nL2");
        imprimirAlfabeto(L2);
        System.out.print("\nL1°L2=");
        conc=concatenarAlfabetos(L1, L2);
        imprimirAlfabeto(conc);
        System.out.print("\n\n\n******Alfabeto potencia******\nL=");
        imprimirAlfabeto(L);
        pot=potenciaAlfabeto(L, n);
    }
}
