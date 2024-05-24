public class LamportClock{
    public static void printValues(int e1, int e2, int[] p1, int[] p2){
        System.out.println("\nThe time stamps of events in process P1:\n");
        for (int i = 0; i < e1; i++) {
            System.out.print(p1[i] + " ");
        }
        System.out.println("\nThe time stamps of events in process P2:\n");
        for (int i = 0; i < e2; i++) {
            System.out.print(p2[i] + " ");
        }
        System.out.println();
    }
    public static void lamportLogicalClock(int e1, int e2, int m[][]) {
        int p1[] = new int[e1];
        int p2[] = new int[e2];
        for (int i = 0; i < e1; i++){
            p1[i] = i + 1;
        }
        for (int i = 0; i < e2; i++){
            p2[i] = i + 1;
        }
        for (int i = 0; i < e2; i++){
            System.out.print("\te2" + (i + 1));
        }
        for (int i = 0; i < e1; i++) {
            System.out.print("\n e1" + (i + 1) + "\t");
            for (int j = 0; j < e2; j++){
                System.out.print(m[i][j] + "\t");
            }
        }
        for (int i = 0; i < e1; i++) {
            for (int j = 0; j < e2; j++) {
                if (m[i][j] == 1) {
                    p2[j] = Math.max(p2[j], p1[i] + 1);
                    for (int k = j + 1; k < e2; k++)
                        p2[k] = p2[k - 1] + 1;
                }
                if (m[i][j] == -1) {
                    p1[i] = Math.max(p1[i], p2[j] + 1);
                    for (int k = i + 1; k < e1; k++)
                        p1[k] = p1[k - 1] + 1;
                }
            }
        }
        printValues(e1, e2, p1, p2);
    }

    public static void main(String[] args) {

        int e1 = 7, e2 = 6;
        int m[][] = new int[e1][e2];
        m[0][0] = 0;
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = 0;
        m[0][4] = 0;
        m[0][5] = 0;
        m[1][0] = 0;
        m[1][1] = 0;
        m[1][2] = 1;
        m[1][3] = 0;
        m[1][4] = 0;
        m[1][5] = 0;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = 0;
        m[2][3] = 0;
        m[2][4] = 0;
        m[2][5] = 0;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 0;
        m[3][4] = 0;
        m[3][5] = 0;
        m[4][0] = 0;
        m[4][1] = 0;
        m[4][2] = 0;
        m[4][3] = 0;
        m[4][4] = 1;
        m[4][5] = 0;
        m[5][0] = 0;
        m[5][1] = 0;
        m[5][2] = 0;
        m[5][3] = 0;
        m[5][4] = 0;
        m[5][5] = 0;
        m[6][0] = 0;
        m[6][1] = 0;
        m[6][2] = 0;
        m[6][3] = -1;
        m[6][4] = 0;
        m[6][5] = 0;

        lamportLogicalClock(e1, e2, m);
    }
}