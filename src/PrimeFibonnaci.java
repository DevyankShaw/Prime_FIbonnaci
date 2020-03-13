import java.util.*;

public class PrimeFibonnaci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int h = sc.nextInt();

        if((l>=2 && l<=100) && (h>=2 && h<=100) && ((h-l)>=35)) {

            ArrayList<Integer> primeList1 = new ArrayList<>();
            Set<Integer> combinationPrime = new HashSet<>();
            ArrayList<Integer> primeList2 = new ArrayList<>();
            ArrayList<Long> fibonacci = new ArrayList<>();

            PrimeFibonnaci primeFibonnaci = new PrimeFibonnaci();

            //Storing the prime numbers between l and h in primeList1 list
            for (int i = l; i <= h; i++) {
                int c = primeFibonnaci.checkPrime(i);
                if (c == 2)
                    primeList1.add(i);
            }

            //Generating all possible combinations with the generated prime numbers
            for (int i = 0; i < primeList1.size(); i++) {
                for (int j = 0; j < primeList1.size(); j++) {
                    if (primeList1.get(i).equals(primeList1.get(j)))
                        continue;
                    int n1 = primeList1.get(i);
                    int n2 = primeList1.get(j);
                    String n = n1 + Integer.toString(n2);
                    int num = Integer.parseInt(n);
                    combinationPrime.add(num);
                }
            }

            //Storing the prime numbers from the combinationPrime list into primeList2 list
            for (int cp : combinationPrime) {
                int c = primeFibonnaci.checkPrime(cp);
                if (c == 2)
                    primeList2.add(cp);
            }

            //Fetching the minimum and maximum elements from the primeList2 list
            Object obj_min = Collections.min(primeList2);
            Object obj_max = Collections.max(primeList2);

            long a = Long.parseLong(obj_min.toString());
            long b = Long.parseLong(obj_max.toString());
            //Generating fibonacci series
            for (int i = 1; i <= primeList2.size(); i++) {
                fibonacci.add(a);
                long sum = a + b;
                a = b;
                b = sum;
            }

            //Printing the last value of the fibonacci series
            System.out.println(fibonacci.get(fibonacci.size() - 1));
        }
    }

    public int  checkPrime(int n){
        int c=0;
        for(int i=1;i<=n;i++){
            if(n%i==0)
                c++;
        }
        return c;
    }
}
