package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII_431 {
    //Given a 2D board and a list of words from the dictionary, find all words in the board.
    //Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
    //cells are those horizontally or vertically neighboring. The same letter cell may not be used
    //more than once in a word.

    //For example: Given words = ["oath","pea","eat","rain"] and
    // board =
    //[
    //  ['o','a','a','n'],
    //  ['e','t','a','e'],
    //  ['i','h','k','r'],
    //  ['i','f','l','v']
    //]
    //Return ["eat","oath"].

    //Note: You may assume that all inputs are consist of lowercase letters a-z.

    //step 1. use dict to construct a trie
    //step 2. dfs the 2D matrix and check
    public List<String> findWords(char[][] board, String[] dict) {
        //corner case
        if (board == null || board.length == 0 || board[0].length == 0 || dict == null || dict.length == 0) {
            return new ArrayList<>();
        }
        //1. creat trie
        TrieNode root = createTrie(dict);
        //2. dfs the 2D matrix
        int[][] dirs = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        HashSet<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(ans, visited, root, board, dirs, sb, i, j);
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(HashSet<String> ans, boolean[][] visited, TrieNode root, char[][] board, int[][] dirs,
                     StringBuilder sb, int rows, int cols) {
        //base case: visited, !match, outofbound
        if (visited[rows][cols] || root.children[board[rows][cols] - 'a'] == null ||
                rows < 0 || rows >= board.length || cols < 0 || cols >= board[0].length) {
            return;
        }
        //match
        root = root.children[board[rows][cols] - 'a'];
        sb.append(board[rows][cols]);
        visited[rows][cols] = true;
        if (root.isWord) {
            ans.add(sb.toString());
        }
        for (int[] dir : dirs) {
            int neix = rows + dir[0];
            int neiy = cols + dir[1];
            dfs(ans, visited, root, board, dirs, sb, neix, neiy);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[rows][cols] = false;
    }

    private TrieNode createTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String dict : dictionary) {
            TrieNode cur = root;
            for (int i = 0; i < dict.length(); i++) {
                TrieNode next = cur.children[dict.charAt(i) - 'a'];
                if (next == null) {
                    next = new TrieNode();
                    cur.children[dict.charAt(i) - 'a'] = next;
                }
                cur = next;
            }
            cur.isWord = true;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
    }



}
