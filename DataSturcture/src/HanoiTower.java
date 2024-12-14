public class HanoiTower {

    private MyStack<Integer> rodA;
    private MyStack<Integer> rodB;
    private MyStack<Integer> rodC;
    private int numOfDisks;
    private int step;

    public HanoiTower(int numOfDisks) {
        this.numOfDisks = numOfDisks;
        this.rodA = new MyStack<>("A");
        this.rodB = new MyStack<>("B");
        this.rodC = new MyStack<>("C");
        this.step = 0;
		
	
		

        // 初始化 rodA，將盤子從大到小放入
        for (int i = numOfDisks; i > 0; i--) {
            rodA.push(i);
        }
    }

    public void start() {
        execute(numOfDisks, rodA, rodC, rodB);
    }

    private void execute(int n, MyStack<Integer> src, MyStack<Integer> dest, MyStack<Integer> spare) {
        if (n == 1) {
            move(src, dest);
        } else {
            execute(n - 1, src, spare, dest);
            move(src, dest);
            execute(n - 1, spare, dest, src);
        }
    }

    private void move(MyStack<Integer> src, MyStack<Integer> dest) {
        if (!src.isEmpty() && (dest.isEmpty() || src.top() < dest.top())) {
            int disk = src.pop();
            dest.push(disk);
            step++;
            System.out.println("Step " + step + ": Move disk " + disk + " from " + src.getName() + " to " + dest.getName());
            printHanoiTower();
        }
    }

    public int getTimes() {
        return (int) Math.pow(2, numOfDisks) - 1;
    }

    public int getStep() {
        return step;
    }

    private void printHanoiTower() {
        System.out.println("Current state:");
        rodA.printStack();
        rodB.printStack();
        rodC.printStack();
        System.out.println("--------------");
    }
}
