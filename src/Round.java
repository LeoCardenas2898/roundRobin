import java.io.DataInputStream;
import java.io.IOException;

public class Round {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        int i, j, k, q, sum = 0;
        System.out.println("Cantidad de proceso: ");
        int n = Integer.parseInt(in.readLine());
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] a = new int[n];
        System.out.println("Ingresa la ráfaga de los " + n + " procesos: ");
        for (i = 0; i < n; i++) {
            System.out.println("Ingresa el tiempo de ráfaga del P" + (i + 1));
            bt[i] = Integer.parseInt(in.readLine());
        }
        System.out.println("Ingrese el quantum:");
        q = Integer.parseInt(in.readLine());
        for (i = 0; i < n; i++) a[i] = bt[i];
        for (i = 0; i < n; i++) wt[i] = 0;
        do {
            for (i = 0; i < n; i++) {
                if (bt[i] > q) {
                    bt[i] -= q;
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0))
                            wt[j] += q;
                    }
                } else {
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0))
                            wt[j] += bt[i];
                    }
                    bt[i] = 0;
                }
            }
            sum = 0;
            for (k = 0; k < n; k++)
                sum = sum + bt[k];
        }
        while (sum != 0);
        for (i = 0; i < n; i++)
            tat[i] = wt[i] + a[i];
        System.out.println("Proceso\t\tRáfaga\tWT\tTAT");
        for (i = 0; i < n; i++) {
            System.out.println("Proceso" + (i + 1) + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        float avg_wt = 0;
        float avg_tat = 0;
        for (j = 0; j < n; j++) {
            avg_wt += wt[j];
        }
        for (j = 0; j < n; j++) {
            avg_tat += tat[j];
        }
        System.out.println("AWT " + (avg_wt / n) + "\nAverage turn around time: " + (avg_tat / n));
    }
}
