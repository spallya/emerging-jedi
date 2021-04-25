import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeAmazonOA {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("Hello, " + name.toUpperCase());

        /* Stars in front of the question represents the frequency of it getting asked */
        /* 1.  **  */
        twoSum();
        /* 2.  **  */
        twoSumUniquePair();
        /* 3.  **  */
        topNCompetitor();
        /* 4.  **  */
        rottingOranges();
        /* 5.  **  */
        zombieInMatrix();
        /* 6.  **  */
        gcd();
        /* 7.  **  */
        substringOfSizeKWithKDistinctChars();
        /* 8.  **  */
        longestPalindromicSubstring();
        /* 9.  **  */
        search2DMatrix();
        /* 10. **  */
        mostCommonWordExcludingBannedWords();
        /* 11. **  */
        reorderDataInLogFiles();
        /* 12. **  */
        favouriteGenres();
        /* 13. *   */
        partitionLabels();
    }

    private static void partitionLabels() {
        System.out.println("partitionLabels");
        System.out.println("for input \"ababcbacadefegdehijhklij\" : " +
                partitionLabels("ababcbacadefegdehijhklij"));
    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int i =  0;
        while (i < s.length()) {
            int end = lastIndex[s.charAt(i) - 'a'];
            int j = i;
            while(j != end) {
                end = Math.max(end, lastIndex[s.charAt(j++) - 'a']);
            }
            res.add(j - i + 1);
            i = j + 1;
        }
        return res;
    }

    private static void favouriteGenres() {
        System.out.println("favouriteGenres");
        Map<String, List<String>> userMap = new HashMap<>();
        List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        List<String> list2 = Arrays.asList("song5", "song6", "song7");
        userMap.put("David", list1);
        userMap.put("Emma", list2);

        Map<String, List<String>> genreMap = new HashMap<>();
        List<String> list3 = Arrays.asList("song1", "song3");
        List<String> list4 = Arrays.asList("song7");
        List<String> list5 = Arrays.asList("song2", "song4");
        List<String> list6 = Arrays.asList("song5", "song6");
        List<String> list7 = Arrays.asList("song8", "song9");
        genreMap.put("Rock", list3);
        genreMap.put("Dubstep", list4);
        genreMap.put("Techno", list5);
        genreMap.put("Pop", list6);
        genreMap.put("Jazz", list7);
        System.out.println(favouriteGenres(userMap, genreMap));
    }

    private static Map<String, List<String>> favouriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, String> songToGenre = new HashMap<>();
        songGenres.forEach((genre, songs) -> songs.forEach(song -> songToGenre.put(song, genre)));
        Map<String, List<String>> userToFavouriteGenre = new HashMap<>();
        userSongs.forEach((user, songs) -> userToFavouriteGenre.put(user, calculateFavouriteGenres(songs, songToGenre)));
        return userToFavouriteGenre;
    }

    private static List<String> calculateFavouriteGenres(List<String> songs, Map<String, String> songToGenre) {
        Map<String, Integer> genreCount = new HashMap<>();
        int maxFrequency = 0;
        for (String song : songs) {
            String genre = songToGenre.get(song);
            int count = genreCount.getOrDefault(genre, 0) + 1;
            genreCount.put(genre, count);
            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }
        int finalMaxFrequency = maxFrequency;
        return genreCount.entrySet().stream()
                .filter(e -> e.getValue() == finalMaxFrequency)
                .map(Map.Entry::getKey).distinct().collect(Collectors.toList());
    }

    private static void reorderDataInLogFiles() {
        System.out.println("reorderDataInLogFiles");
        System.out.println(" for input [\"dig1 8 1 5 1\",\"let1 art can\",\"dig2 3 6\"," +
                "\"let2 own kit dig\",\"let3 art zero\"] : " +
                Arrays.toString(reorderDataInLogFiles(
                        (String[]) Arrays.asList("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero").toArray())));
    }

    private static String[] reorderDataInLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] s1 = log1.split(" ", 2);
            String[] s2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int i = s1[1].compareTo(s2[1]);
                return i != 0 ? i : s1[0].compareTo(s2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    private static void mostCommonWordExcludingBannedWords() {
        System.out.println("mostCommonWordWithoutBannedWords");
        System.out.println("for input paragraph: a b c d a,a,a,a,b,b,b,c,d and banned words: {\"c\", \"b\"}, most common word is: "
                + mostCommonWordExcludingBannedWords("a b c d a,a,a,a,b,b,b,c,d", new String[]{"c", "b"}));
        System.out.println("for input paragraph: \"Hot. Ball, Bob\" and banned words: {\"hot\", \"ball\"}, most common word is: "
                + mostCommonWordExcludingBannedWords("Hot. Ball, Bob", new String[]{"hot", "ball"}));
        System.out.println("for input paragraph: " +
                "\"Bob hit a ball, the hit BALL flew far after it was hit.\" and banned words: {\"hit\"}, most common word is: "
                + mostCommonWordExcludingBannedWords(
                "Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    private static String mostCommonWordExcludingBannedWords(String paragraph, String[] banned) {
        Set<String> ban = Arrays.stream(banned)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        StringBuilder wordBuffer = new StringBuilder();
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;
        char[] chars = paragraph.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                wordBuffer.append(Character.toLowerCase(c));
                if (i != chars.length - 1) {
                    continue;
                }
            }
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                if (!ban.contains(word)) {
                    int count = map.getOrDefault(word, 0);
                    count = count + 1;
                    map.put(word, count);
                    if (count > maxCount) {
                        ans = word;
                        maxCount = count;
                    }
                }
            }
            wordBuffer = new StringBuilder();
        }
        return ans.toLowerCase();
    }

    private static void search2DMatrix() {
        System.out.println("search2DMatrix");
        System.out.println("for input {{1,5,8,10}, {2,3,4,5}} and target 5: " +
                search2DMatrix(new int[][]{{1, 5, 8, 10}, {2, 3, 4, 5}}, 5));
        System.out.println("for input {{1,5,8,10}, {2,3,4,5}} and target 7: " +
                search2DMatrix(new int[][]{{1, 5, 8, 10}, {2, 3, 4, 5}}, 7));
    }

    private static boolean search2DMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static void longestPalindromicSubstring() {
        System.out.println("longestPalindromicSubstring");
        System.out.println("for aaabbbaaaca : " + longestPalindromicSubstring("aaabbbaaaca"));
    }

    private static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandFromCenter(s, i, i);
            int l2 = expandFromCenter(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (end - start < l) {
                start = i - ((l - 1) / 2);
                end = i + (l / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        if (s.length() < 1 || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static void substringOfSizeKWithKDistinctChars() {
        System.out.println("substringOfSizeKWithKDistinctChars");
        System.out.println(substringOfSizeKWithKDistinctChars("abcabc", 3));
        System.out.println(substringOfSizeKWithKDistinctChars("sbvbwebiowebvcascavwefcwecw", 3));

    }

    private static List<String> substringOfSizeKWithKDistinctChars(String s, int k) {
        int len = s.length();
        int start = 0;
        int end = 0;
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        while (end < len) {
            char c = s.charAt(end);
            while (window.contains(c) || window.size() >= k) {
                window.remove(s.charAt(start));
                start++;
            }
            window.add(c);
            if (end - start + 1 == k) result.add(s.substring(start, end + 1));
            end++;
        }
        return new ArrayList<>(result);
    }

    private static void gcd() {
        System.out.println("gcd");
        int[] arr = {2, 4, 6, 8, 10};
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            for (int i = 1; i <= e; i++) {
                if (e % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == arr.length && e.getKey() > max) {
                max = e.getKey();
            }
        }
        System.out.println(max);
    }

    private static void zombieInMatrix() {
        System.out.println("zombieInMatrix");
        int[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        System.out.println(zombieInMatrix(grid));
    }

    private static int zombieInMatrix(int[][] grid) {
        Set<String> zombie = new HashSet<>();
        Set<String> human = new HashSet<>();
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    zombie.add("" + i + j);
                } else if (grid[i][j] == 0) {
                    human.add("" + i + j);
                }
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!human.isEmpty()) {
            Set<String> infected = new HashSet<>();
            for (String s : zombie) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for (int[] d : directions) {
                    int newI = i + d[0];
                    int newJ = j + d[1];
                    String key = "" + newI + newJ;
                    if (human.contains(key)) {
                        human.remove(key);
                        infected.add(key);
                    }
                }
            }
            if (infected.isEmpty()) {
                return -1;
            }
            minutes++;
            zombie = infected;
        }
        return minutes;
    }

    private static void rottingOranges() {
        System.out.println("rottingOranges");
        System.out.println("For input [[2,1,1],[1,1,0],[0,1,1]] : " +
                rottingOranges(new char[][]{{'2', '1', '1'}, {'1', '1', '0'}, {'0', '1', '1'}}));
        System.out.println("For input [[2,1,1],[0,1,1],[1,0,1]] : " +
                rottingOranges(new char[][]{{'2', '1', '1'}, {'0', '1', '1'}, {'1', '0', '1'}}));
        System.out.println("For input [[0,2]] : " +
                rottingOranges(new char[][]{{'0', '2'}}));
    }

    private static int rottingOranges(char[][] grid) {
        Set<String> rotten = new HashSet<>();
        Set<String> fresh = new HashSet<>();
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '2') {
                    rotten.add("" + i + j);
                } else if (grid[i][j] == '1') {
                    fresh.add("" + i + j);
                }
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!fresh.isEmpty()) {
            Set<String> infected = new HashSet<>();
            for (String s : rotten) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for (int[] d : directions) {
                    int newI = i + d[0];
                    int newJ = j + d[1];
                    String key = "" + newI + newJ;
                    if (fresh.contains(key)) {
                        fresh.remove(key);
                        infected.add(key);
                    }
                }
            }
            if (infected.isEmpty()) {
                return -1;
            }
            minutes++;
            rotten = infected;
        }
        return minutes;
    }

    private static void topNCompetitor() {
        System.out.println("topNCompetitor");
        int k1 = 2;
        String[] keywords1 = {"anacell", "cetracular", "betacellular"};
        String[] reviews1 = {"Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",};
        int k2 = 2;
        String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.",};
        System.out.println(topNCompetitor(keywords1, reviews1, k1));
        System.out.println(topNCompetitor(keywords2, reviews2, k2));
    }

    private static List<String> topNCompetitor(String[] keywords, String[] reviews, int n) {
        List<String> finalList = new ArrayList<>();
        Set<String> keys = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        Arrays.asList(keywords).forEach(k -> keys.add(k.toLowerCase()));
        for (String review : reviews) {
            String[] words = review.split("\\W");
            Set<String> added = new HashSet<>();
            for (String word : words) {
                word = word.toLowerCase();
                if (keys.contains(word) && !added.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    added.add(word);
                }
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) ->
                a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        q.addAll(map.entrySet());
        while (!q.isEmpty() && n-- > 0) finalList.add(q.poll().getKey());
        return finalList;
    }

    private static void twoSumUniquePair() {
        System.out.println("twoSumUniquePair");
        System.out.println(twoSumUniquePair(new int[]{1, 2, 3, 50, 49, 48, 1, 50, 2, 49}, 51));
    }

    private static int twoSumUniquePair(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(target - num) && !seen.contains(num)) {
                count++;
                seen.add(target - num);
                seen.add(num);
            }
            set.add(num);
        }
        return count;
    }

    private static void twoSum() {
        System.out.println("twoSum");
        int[] ints = twoSum(new int[]{1, 2, 3, 50, 56, 89}, 92);
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
