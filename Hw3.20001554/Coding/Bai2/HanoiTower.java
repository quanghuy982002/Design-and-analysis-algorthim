package hw4;

class HanoiTower
{

    public static int towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
    {
        int count = 0;
        if (n == 1)
        {
            System.out.println("Di chuyển đĩa 1 từ cột " +  from_rod + " sang cột " + to_rod);
            return 1;
        }
        count += towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Di chuyển đĩa " + n + " từ cột " +  from_rod + " sang cột " + to_rod);
        count++;
        count += towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
        return count;
    }

    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        int n = 30; // Number of disks
        int moves = towerOfHanoi(n, 'A', 'C', 'B');
        long endTime = System.currentTimeMillis();
        long total = endTime - startTime;
        System.out.println("Tổng số lần dịch chuyển " + moves);
        System.out.println("Thời gian chạy là: " + total + " ms.");
    }
}