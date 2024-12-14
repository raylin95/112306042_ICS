public class Main {

    public static void main(String[] args) {
        int numOfDisks = 5; // 設定盤子的數量
        HanoiTower tower = new HanoiTower(numOfDisks);
        tower.start();
        System.out.println("Total moves: " + tower.getTimes());
    }
}
