import java.io.IOException;

public class Hello {

    record Position(int x, int y) {}
    static private final int[][] maze = {
            {1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        var current = new Position(1, 1);
        var goal = new Position(4, 3);

        for (;;) {

            drawMaze(current.x(), current.y());
            if (current.equals(goal)) break;

            // input move key WASD
            int ch = System.in.read();

            var next = switch (ch) {
                case 'w' -> new Position(current.x(), current.y()-1);
                case 'a' -> new Position(current.x()-1, current.y());
                case 's' -> new Position(current.x(), current.y()+1);
                case 'd' -> new Position(current.x()+1, current.y());
                default -> current;
            };

            if (maze[next.y()][next.x()] == 0) {
                current = next;
            }
        }

        System.out.println("Goal!");
    }

    static private void drawMaze(int cx, int cy) {
        // draw maze
        for (int y=0; y<maze.length; y++) {
            for (int x=0; x<maze[y].length; x++) {
                if (x == cx && y == cy) {
                    System.out.print("o");
                } else {
                    System.out.print(maze[y][x]==0 ? "." : "*");
                }
            }
            System.out.println(); // 改行
        }
    }
}
