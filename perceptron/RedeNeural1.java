public class RedeNeural1 {
    public static void main(String[] args) {
        int x = 1;
        int y = 0;
        
        double[] weights = {Math.random(),Math.random(),Math.random()};    
        for (int i = 0;i<50;i++){
            Perceptron(1,1,0,weights);
            Perceptron(1,0,1,weights);
            Perceptron(0,1,1,weights);
            Perceptron(0,0,0,weights);
            System.out.println(weights[0]+" | "+weights[1]+" | "+weights[2]);
        }
        calcular(weights);
    }
    
    public static void Perceptron (int input1, int input2, int output, double[] weights){
        int lr = 1;
        int bias = 1;
        double outputP = input1*weights[0]+input2*weights[1]+bias*weights[2];
        if (outputP > 0) {
            outputP = 1;
        }
        else {
            outputP = 0;
        }
        double error = output - outputP;
        weights[0] = weights[0] + error * input1 * lr;
        weights[1] = weights[1] + error * input2 * lr;
        weights[2] = weights[2] + error * bias * lr;
    }

    public static void calcular (double[] weights){
        int input1 = 1;
        int input2 = 1;
        int output = 0;
        int bias = 1;
        double outputP = input1*weights[0]+input2*weights[1]+bias*weights[2];
        if (outputP > 0){
            output = 1;            
        }
        else{
            output = 0;
        }
        System.out.println(output);
    }
}