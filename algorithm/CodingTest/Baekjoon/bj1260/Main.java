package bj1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    /**
     * N = 정점의 갯수
     * M = 간선의 갯수
     * V = 탐색 시작점
     */
    static int N, M, V;
    static int[][] adj; // 행렬이니까 2차원 배열이 필요하다.
    static boolean[] visit;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void process() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        for (int i = 1; i <=N ; i++) visit[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y = 1; y <= N; y++) {
            if(adj[x][y] == 0) continue;
            if(visit[y]) continue;
            dfs(y);
        }

    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            start = que.poll();
            sb.append(start).append(' ');
            for (int y = 1; y <=N ; y++) {
                if(adj[start][y] == 0) continue;
                if(visit[y]) continue;
                que.add(y);
                visit[y] = true;
            }
        }

    }

    public static void main(String[] args) {
        input();
        process();
    }
}
