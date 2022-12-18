package bj1260;

import java.util.*;

public class Main2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    /**
     * N = 정점의 갯수
     * M = 간선의 갯수
     * V = 탐색 시작점
     */
    static int N, M, V;
    static ArrayList<Integer>[] adj; // 행렬이니까 2차원 배열이 필요하다.
    static boolean[] visit;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
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
        for(int y : adj[x]){
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
            for(int y : adj[start]){
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
