package HW_1;

public class task_2 {
    // вот и решето Эратосфена пригодилось
    public static void main(String[] args){
        int[] simples = new int[1000];
        for (int i = 2; i < simples.length; i++){
            simples[i] = 1;
        }
        for (int i = 2; i < simples.length; i++){
            if (simples[i] == 1){
                System.out.println(i);
                for (int j = i * 2; j < simples.length; j += i){
                    simples[j] = 0;
                }
            }
        }
    }
}
