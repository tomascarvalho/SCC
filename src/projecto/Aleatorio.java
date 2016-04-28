// Classe para geração de números aleatórios segundos várias distribuições
// Apenas a distribuição exponencial negativa está definida

public class Aleatorio
{

    // Gera um numero segundo uma distribuicao exponencial negativa de media m
    static double exponencial (double m)
    {
        return (-m*Math.log(Math.random()));
    }

    // Gera um número segundo uma distribuição exponencial negativa de média m
    static double exponencial (double m, int seed)
    {
        return (-m*Math.log(RandomGenerator.rand(seed)));
        //return m;
    }

    // Gera um número segundo uma distribuição normal com média m e desvio padrão d
    public static  double []normal (double m, double d, int randStream)
    {

        double V1, V2, W;

        double Y [] = new double [2];

        do
        {
            V1 = 2 * RandomGenerator.rand(randStream) - 1;
            V2 = 2 * RandomGenerator.rand(randStream) - 1;
            W = V1*V1 + V2*V2;
        } while(W > 1);

        Y[0] = Math.abs((V1*Math.sqrt(-2 * Math.log(W) / W))*d + m);
        Y[1] = Math.abs((V2*Math.sqrt(-2 * Math.log(W) / W))*d + m);

        return Y;
    }

    public static  double uniforme (double m, double d, int seed)
    {
        return (m-d) + RandomGenerator.rand(seed) * (2*d);
    }
}