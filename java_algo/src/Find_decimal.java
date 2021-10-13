public class Find_decimal {
    static boolean[] prime;

    public static void main(String[] args) {

        int N = 100;


        prime = new boolean[N + 1];

        if (N < 2) {
            return;
        }
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(prime[i] == true){
                continue;
            }
            for (int j = i * i; j < prime.length; j = j + 1) {
                prime[j] = true;
                System.out.println(j);
            }
        }
    }
}
